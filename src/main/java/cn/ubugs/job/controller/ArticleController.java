package cn.ubugs.job.controller;

import cn.ubugs.job.domain.Article;
import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.domain.resp.ArticleResp;
import cn.ubugs.job.domain.resp.PageListResp;
import cn.ubugs.job.interceptor.Auth;
import cn.ubugs.job.resp.ResultData;
import cn.ubugs.job.service.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Validated
@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;

    @GetMapping(value = "/job/list")
    public ResultData<Object> list(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", defaultValue = "20") Integer size) {
        PageListResp<ArticleResp> articleList = articleService.list(page, size);
        return ResultData.success(articleList);
    }

    @PostMapping(value = "/user/job/add", produces = "application/json;charset=UTF-8")
    @Auth(permissions = "user")
    public ResultData<Object> add(@RequestBody @Valid ArticleReq articleReq) {
        articleService.add(articleReq);
        return ResultData.success();
    }

    @GetMapping(value = "/user/job/list")
    @Auth(permissions = "user")
    public ResultData<Object> list1(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", defaultValue = "20") Integer size) {
        PageListResp<Article> articleList = articleService.list1(page, size);
        return ResultData.success(articleList);
    }

    @PostMapping(value = "/user/job/update/{id}", produces = "application/json;charset=UTF-8")
    @Auth(permissions = "user")
    public ResultData<Object> update(@PathVariable Integer id, @RequestBody @Valid ArticleReq articleReq) {
        articleService.update(id, articleReq);
        return ResultData.success();
    }

    @GetMapping(value = "/user/job/delete/{id}")
    @Auth(permissions = "user")
    public ResultData<Object> delete(@PathVariable Integer id) {
        articleService.delete(id);
        return ResultData.success();
    }
}
