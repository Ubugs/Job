package cn.ubugs.job.exception;

import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.resp.ReturnCode;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * 统一处理异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*处理自定义异常*/
    @ExceptionHandler(ApiException.class)
    public ResultData<Object> ApiExceptionHandler(ApiException e) {
        return ResultData.fail(e.getCode(), e.getMsg());
    }

    /*处理参数校验异常1*/
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultData<Object> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> list = new ArrayList<>();
        for (ConstraintViolation<?> item : constraintViolations) {
            list.add(item.getMessage());
        }
        return ResultData.fail(ReturnCode.RC80000.getCode(), ReturnCode.RC80000.getMsg(), list);
    }

    /*处理参数校验异常2*/
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResultData<Object> BindExceptionHandler(BindException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> list = new ArrayList<>();
        for (ObjectError item : allErrors) {
            list.add(item.getDefaultMessage());
        }
        return ResultData.fail(ReturnCode.RC80000.getCode(), ReturnCode.RC80000.getMsg(), list);
    }
}
