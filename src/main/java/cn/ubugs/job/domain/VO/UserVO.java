package cn.ubugs.job.domain.VO;

import cn.ubugs.job.domain.Info;
import cn.ubugs.job.domain.Role;
import cn.ubugs.job.domain.User;
import lombok.Data;

@Data
public class UserVO {
    User user;
    Role role;
    Info info;
}
