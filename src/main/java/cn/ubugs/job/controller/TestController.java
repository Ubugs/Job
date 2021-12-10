package cn.ubugs.job.controller;

import cn.ubugs.job.interceptor.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Auth(permissions = "user")
    @GetMapping("/")
    public String test() {
        return "test";
    }
}
