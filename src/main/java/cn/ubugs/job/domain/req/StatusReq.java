package cn.ubugs.job.domain.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StatusReq {
    /**
     * 主键ID
     */
    @NotNull(message = "任务id不能为空")
    private Integer id;
    /**
     * 状态码
     */
    @NotNull(message = "状态码不能为空")
    private Integer state;
}
