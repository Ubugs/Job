package cn.ubugs.job.domain.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserReq {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 18, message = "用户名必须为6-18位字符")
    private String username;

    /**
     * 用户密码
     */
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 18, message = "密码必须为6-18位字符")
    private String password;
}
