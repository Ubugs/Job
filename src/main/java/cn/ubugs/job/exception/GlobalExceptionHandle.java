package cn.ubugs.job.exception;

import cn.ubugs.job.resp.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 统一处理异常
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    /*处理自定义异常*/
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultData<Object> baseException(ApiException e) {
        return ResultData.fail(e.getCode(), e.getMsg());
    }
}
