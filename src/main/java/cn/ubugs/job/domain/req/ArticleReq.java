package cn.ubugs.job.domain.req;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleReq {
    /**
     * 标题
     */
    private String title;

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
