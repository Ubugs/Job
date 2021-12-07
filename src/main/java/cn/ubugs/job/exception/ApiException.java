package cn.ubugs.job.exception;

import cn.ubugs.job.resp.ReturnCode;


/**
 * 自定义异常
 * 继承RuntimeException
 */
public class ApiException extends RuntimeException {
    private final Integer code;
    private final String msg;

    public ApiException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiException(ReturnCode RC) {
        this(RC.getCode(), RC.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
