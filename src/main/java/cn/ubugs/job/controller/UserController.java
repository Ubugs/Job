package cn.ubugs.job.controller;

import cn.ubugs.job.domain.req.InfoReq;
import cn.ubugs.job.domain.req.PwdReq;
import cn.ubugs.job.domain.req.UserReq;
import cn.ubugs.job.domain.resp.InfoResp;
import cn.ubugs.job.domain.resp.UserResp;
import cn.ubugs.job.interceptor.Auth;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/user/info")
    public ResultData<InfoResp> info() {
        InfoResp info = userService.queryInfo();
        return ResultData.success(info);
    }

    @PostMapping(value = "/user/info/update", produces = "application/json;charset=UTF-8")
    @Auth(permissions = "user")
    public ResultData<Object> updateInfo(@RequestBody @Valid InfoReq infoReq) {
        userService.updateInfo(infoReq);
        return ResultData.success();
    }

    @PostMapping(value = "/user/pwd/update", produces = "application/json;charset=UTF-8")
    @Auth(permissions = "user")
    public ResultData<Object> updatePwd(@RequestBody @Valid PwdReq pwdReq) {
        userService.updatePwd(pwdReq);
        return ResultData.success();
    }
}
