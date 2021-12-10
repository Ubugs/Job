package cn.ubugs.job.controller;

import cn.ubugs.job.domain.req.UserReq;
import cn.ubugs.job.domain.resp.UserResp;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResultData<Object> login(@RequestBody @Valid UserReq userReq) {
        UserResp userResp = userService.login(userReq.getUsername(), userReq.getPassword());
        return ResultData.success(userResp);
    }

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public ResultData<Object> register(@RequestBody @Valid UserReq userReq) {
        userService.register(userReq.getUsername(), userReq.getPassword());
        return ResultData.success();
    }
}
