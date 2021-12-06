package cn.ubugs.job.controller;

import cn.ubugs.job.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
public class TestController {
    @Resource
    TestService testService;

    @GetMapping("/")
    public String test() {
        testService.login();
        return "test";
    }
}
