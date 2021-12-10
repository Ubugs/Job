package cn.ubugs.job.service;

import cn.ubugs.job.domain.Article;
import cn.ubugs.job.domain.ArticleWithUser;
import cn.ubugs.job.domain.User;
import cn.ubugs.job.domain.UserWithRoleWithInfo;
import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.exception.ApiException;
import cn.ubugs.job.mapper.ArticleMapper;
import cn.ubugs.job.mapper.MyArticleMapper;
import cn.ubugs.job.resp.ReturnCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ArticleService {
    @Resource
    HttpSession session;
    @Resource
    ArticleMapper articleMapper;
    @Resource
    MyArticleMapper myArticleMapper;

    public List<ArticleWithUser> query() {
        List<ArticleWithUser> articles = myArticleMapper.selectAll();
        return articles;
    }

    public void add(ArticleReq articleReq) {
        // 获取用户session
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        User user = userInfo.getUser();
        Article article = new Article();
        // ArticleReq拷贝给Article
        BeanUtils.copyProperties(articleReq, article);
        // 给setUId赋值
        article.setUId(user.getId());
        int i = articleMapper.insertSelective(article);
        if (i != 1) {
            throw new ApiException(ReturnCode.RC10006);
        }
    }
}
