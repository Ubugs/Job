package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.UserWithRoleWithInfo;

public interface MyUserMapper {
    UserWithRoleWithInfo selectUser(String username);
}
