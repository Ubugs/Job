package cn.ubugs.job.controller;

import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.interceptor.Auth;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;

    @PostMapping(value = "/job/add", produces = "application/json;charset=UTF-8")
    @Auth(permissions = "user")
    public ResultData<Object> add(@RequestBody @Valid ArticleReq articleReq) {
        articleService.add(articleReq);
        return ResultData.success();
    }
}
