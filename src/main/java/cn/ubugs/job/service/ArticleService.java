package cn.ubugs.job.service;

import cn.ubugs.job.domain.Article;
import cn.ubugs.job.domain.User;
import cn.ubugs.job.domain.UserWithRoleWithInfo;
import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class ArticleService {
    @Resource
    HttpSession session;
    @Resource
    ArticleMapper articleMapper;

    public void add(ArticleReq articleReq) {
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        User user = userInfo.getUser();
        Article article = new Article();
        article.setUId(user.getId());
        int i = articleMapper.insertSelective(article);
    }
}
