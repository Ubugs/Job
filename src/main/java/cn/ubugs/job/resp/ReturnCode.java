package cn.ubugs.job.resp;


/**
 * 返回值枚举
 */
public enum ReturnCode {
    /*状态码和描述*/
    RC10000(10000, "ok"),
    RC20000(99999, "系统错误");


    /*自定义状态码*/
    private final Integer code;
    /*自定义描述*/
    private final String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
