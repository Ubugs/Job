package cn.ubugs.job.service;

import cn.ubugs.job.domain.*;
import cn.ubugs.job.domain.resp.UserResp;
import cn.ubugs.job.exception.ApiException;
import cn.ubugs.job.mapper.*;
import cn.ubugs.job.resp.ReturnCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Resource
    MyUserMapper myUserMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    InfoMapper infoMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    HttpSession session;

    public UserResp login(String username, String password) {
        // 多表联合查询
        UserWithRoleWithInfo myUser = myUserMapper.selectUser(username);
        if (myUser == null) {
            throw new ApiException(ReturnCode.RC10001);
        }
        // 提取账号信息
        User user = myUser.getUser();
        if (user.getDeleted()) {
            throw new ApiException(ReturnCode.RC10003);
        }
        if (!user.getPassword().equals(password)) {
            throw new ApiException(ReturnCode.RC10002);
        }
        // 提取用户和角色信息
        Role role = myUser.getRole();
        Info info = myUser.getInfo();
        // 生成返回对象
        UserResp userResp = new UserResp();
        userResp.setUsername(user.getUsername());
        userResp.setRole_name(role.getName());
        userResp.setRole_id(role.getId());
        userResp.setNickname(info.getNickname());
        userResp.setSign(info.getSign());
        userResp.setPhone(info.getPhone());
        // 保存session
        session.setAttribute("userInfo", myUser);
        return userResp;
    }

    @Transactional
    public void register(String username, String password) {
        // 提取账号信息
        User oneByUsername = userMapper.findOneByUsername(username);
        if (oneByUsername != null) {
            throw new ApiException(ReturnCode.RC10004);
        }
        // 生成用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userMapper.insertSelective(user) != 1) {
            throw new ApiException(ReturnCode.RC10005);
        }
        // 提取默认角色
        Role role = roleMapper.findOneByInitial(true);
        if (role == null) {
            throw new ApiException(ReturnCode.RC10005);
        }
        // 生成账号和角色关联表
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        if (userRoleMapper.insertSelective(userRole) != 1) {
            throw new ApiException(ReturnCode.RC10005);
        }
        // 生成默认用户信息
        Info info = new Info();
        info.setUId(user.getId());
        if (infoMapper.insertSelective(info) != 1) {
            throw new ApiException(ReturnCode.RC10005);
        }
    }
}
