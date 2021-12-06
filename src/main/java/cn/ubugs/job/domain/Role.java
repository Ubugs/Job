package cn.ubugs.job.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 是否为初始化角色：0-不是，1-是
     */
    private Boolean initial;

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