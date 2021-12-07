package cn.ubugs.job.resp;

import lombok.Data;

/**
 * 统一返回值类
 *
 * @param <T> 任意类型数据
 */
@Data
public class ResultData<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T> ResultData<T> success() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC10000.getCode());
        resultData.setMessage(ReturnCode.RC10000.getMsg());
        return resultData;
    }

    public static <T> ResultData<T> success(String msg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC10000.getCode());
        resultData.setMessage(msg);
        return resultData;
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC10000.getCode());
        resultData.setMessage(ReturnCode.RC10000.getMsg());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(Integer code, String msg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(msg);
        return resultData;
    }

    public static <T> ResultData<T> fail(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC20000.getCode());
        resultData.setMessage(ReturnCode.RC20000.getMsg());
        resultData.setData(data);
        return resultData;
    }
}
