package cn.ubugs.job.domain.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleReq {
    /**
     * 标题
     */
    @NotEmpty(message = "标题不能为空")
    private String title;

    /**
     * 工作内容
     */
    @NotEmpty(message = "工作内容不能为空")
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
    @NotEmpty(message = "工作地点不能为空")
    private String address;

    /**
     * 工作开始时间
     */
    @NotNull(message = "工作开始时间不能为空")
    private Date startTime;

    /**
     * 工作结束时间
     */
    @NotNull(message = "工作结束时间不能为空")
    private Date endTime;
}
