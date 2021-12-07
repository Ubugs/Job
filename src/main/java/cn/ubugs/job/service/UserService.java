package cn.ubugs.job.service;

import cn.ubugs.job.domain.Info;
import cn.ubugs.job.domain.Role;
import cn.ubugs.job.domain.User;
import cn.ubugs.job.domain.VO.UserVO;
import cn.ubugs.job.domain.resp.UserResp;
import cn.ubugs.job.exception.ApiException;
import cn.ubugs.job.mapper.UserVOMapper;
import cn.ubugs.job.resp.ReturnCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserVOMapper userVOMapper;

    public UserResp login(String username, String password) {
        UserVO userVO = userVOMapper.selectUserVO(username);
        if (userVO == null) {
            throw new ApiException(ReturnCode.RC10001);
        }
        User user = userVO.getUser();
        if (user.getDeleted()) {
            throw new ApiException(ReturnCode.RC10003);
        }
        if (!user.getPassword().equals(password)) {
            throw new ApiException(ReturnCode.RC10002);
        }
        Role role = userVO.getRole();
        Info info = userVO.getInfo();
        UserResp userResp = new UserResp();
        userResp.setUsername(user.getUsername());
        userResp.setRole_name(role.getName());
        userResp.setRole_id(role.getId());
        userResp.setNickname(info.getNickname());
        userResp.setSign(info.getSign());
        userResp.setPhone(info.getPhone());
        return userResp;
    }
}
