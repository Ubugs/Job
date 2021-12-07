package cn.ubugs.job.domain;

import lombok.Data;

@Data
public class UserWithRoleWithInfo {
    User user;
    Role role;
    Info info;
}
