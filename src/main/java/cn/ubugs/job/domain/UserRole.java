package cn.ubugs.job.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 状态：0-停用，1-正常
     */
    private Integer state;

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