package cn.ubugs.job.controller;

import cn.ubugs.job.domain.VO.UserVO;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public ResultData<UserVO> login(String username, String password) {
        UserVO user = userService.login(username, password);
        return ResultData.success(user);
    }

}
