package cn.ubugs.job.domain.resp;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleResp {
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
     * 标题
     */
    private String title;

    /**
     * 状态：0-停用，1-正常，2-被管理员封禁
     */
    private Integer state;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 工作薪资
     */
    private Integer money;

    /**
     * 薪资单位：0-小时，1-天
     */
    private Integer unit;

    /**
     * 工作地点
     */
    private String address;

    /**
     * 工作开始时间
     */
    private Date startTime;

    /**
     * 工作结束时间
     */
    private Date endTime;
}
