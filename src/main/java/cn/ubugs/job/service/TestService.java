package cn.ubugs.job.service;

import cn.ubugs.job.domain.UserWithRoleWithInfo;
import cn.ubugs.job.mapper.MyUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    MyUserMapper myUserMapper;

    public Object login() {
        UserWithRoleWithInfo myUser = myUserMapper.selectUser("");
        System.out.println(myUser);
        return myUser;
    }
}
