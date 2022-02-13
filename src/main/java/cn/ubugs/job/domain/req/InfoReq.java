package cn.ubugs.job.domain.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class InfoReq {
    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickname;

    /**
     * 签名
     */
    @NotEmpty(message = "签名不能为空")
    private String sign;

    /**
     * 手机
     */
    @NotEmpty(message = "手机号码不能为空")
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    private String phone;
}
