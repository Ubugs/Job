package cn.ubugs.job.controller;

import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.ArticleService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;

    public ResultData<Object> add(ArticleReq articleReq) {
        articleService.add(articleReq);
        return ResultData.success();
    }
}
