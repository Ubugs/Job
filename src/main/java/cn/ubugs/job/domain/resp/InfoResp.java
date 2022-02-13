package cn.ubugs.job.domain.resp;

import lombok.Data;


@Data
public class InfoResp {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 签名
     */
    private String sign;

    /**
     * 手机
     */
    private String phone;
}
