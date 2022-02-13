package cn.ubugs.job.domain.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PwdReq {
    /**
     * 用户密码
     */
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 18, message = "密码必须为6-18位字符")
    private String password;
}
