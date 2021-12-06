package cn.ubugs.job.service;

import cn.ubugs.job.domain.VO.UserVO;
import cn.ubugs.job.mapper.UserVOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    UserVOMapper userVOMapper;

    public Object login() {
        UserVO userVO = userVOMapper.selectUserVO("123456");
        System.out.println(userVO.getUser());
        System.out.println(userVO.getRole());
        return userVO;
    }
}
