package cn.ubugs.job.resp;


/**
 * 返回值枚举
 */
public enum ReturnCode {
    /*状态码和描述*/
    RC10000(10000, "ok"),
    RC10001(10001, "用户不存在"),
    RC10002(10002, "密码错误"),
    RC10003(10003, "用户已被冻结"),
    RC10004(10004, "用户已存在"),
    RC10005(10005, "注册失败"),
    RC60000(60000, "用户未登录"),
    RC60001(60001, "您的权限等级不够,无法进行操作"),
    RC80000(80000, "参数校验失败"),
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
