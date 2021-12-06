package cn.ubugs.job.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 注册时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 软删除：0-未删除，1-已删除
     */
    private Boolean deleted;
}