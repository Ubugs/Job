package cn.ubugs.job.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Info {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 软删除：0-未删除，1-已删除
     */
    private Boolean deleted;
}