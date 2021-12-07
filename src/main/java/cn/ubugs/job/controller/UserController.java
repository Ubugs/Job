package cn.ubugs.job.controller;

import cn.ubugs.job.domain.resp.UserResp;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Size;

@Validated
@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public ResultData<Object> login(
            @RequestParam("username")
            @Size(min = 6, max = 18, message = "用户名必须为6-18位字符")
                    String username,
            @RequestParam("password")
            @Size(min = 6, max = 18, message = "密码必须为6-18位字符")
                    String password
    ) {
        UserResp userResp = userService.login(username, password);
        return ResultData.success(userResp);
    }

    @PostMapping("/register")
    public ResultData<Object> register(
            @RequestParam("username")
            @Size(min = 6, max = 18, message = "用户名必须为6-18位字符")
                    String username,
            @RequestParam("password")
            @Size(min = 6, max = 18, message = "密码必须为6-18位字符")
                    String password
    ) {
        userService.register(username, password);
        return ResultData.success();
    }
}
