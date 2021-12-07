package cn.ubugs.job.service;

import cn.ubugs.job.domain.VO.UserVO;
import cn.ubugs.job.mapper.UserVOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserVOMapper userVOMapper;

    public UserVO login(String username, String password) {
        UserVO userVO = userVOMapper.selectUserVO(username);
//        throw new ApiException(ReturnCode.RC20000);
        return userVO;
    }
}
