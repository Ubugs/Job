package cn.ubugs.job.domain.resp;

import lombok.Data;

@Data
public class UserResp {

    private String username;

    private String nickname;

    private String sign;

    private String phone;

    private Integer role_id;

    private String role_name;

}
