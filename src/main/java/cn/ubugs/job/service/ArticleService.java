package cn.ubugs.job.service;

import cn.ubugs.job.domain.Article;
import cn.ubugs.job.domain.ArticleWithInfo;
import cn.ubugs.job.domain.User;
import cn.ubugs.job.domain.UserWithRoleWithInfo;
import cn.ubugs.job.domain.req.ArticleReq;
import cn.ubugs.job.domain.resp.ArticleResp;
import cn.ubugs.job.domain.resp.PageListResp;
import cn.ubugs.job.exception.ApiException;
import cn.ubugs.job.mapper.ArticleMapper;
import cn.ubugs.job.mapper.MyArticleMapper;
import cn.ubugs.job.resp.ReturnCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Resource
    HttpSession session;
    @Resource
    ArticleMapper articleMapper;
    @Resource
    MyArticleMapper myArticleMapper;

    /*所有人*/
    public PageListResp<ArticleResp> list(Integer pageNum, Integer pageSize) {
        /*使用PageHelper进行分页*/
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleWithInfo> articles = myArticleMapper.selectAll();
        /*生成分页数据*/
        PageInfo<ArticleWithInfo> pageInfo = new PageInfo<>(articles);
        /*创建返回数据列表*/
        List<ArticleResp> listArticle = new ArrayList<>();
        /*处理数据*/
        for (ArticleWithInfo item : pageInfo.getList()) {
            ArticleResp articleResp = new ArticleResp();
            BeanUtils.copyProperties(item.getInfo(), articleResp);
            BeanUtils.copyProperties(item.getArticle(), articleResp);
            listArticle.add(articleResp);
        }
        /*创建返回数据类*/
        PageListResp<ArticleResp> pageList = new PageListResp<>();
        pageList.setList(listArticle);
        pageList.setTotal(Math.toIntExact(pageInfo.getTotal()));
        return pageList;
    }

    /*登录用户 添加兼职信息*/
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

    /*登录用户 获取发布列表*/
    public PageListResp<Article> list1(Integer pageNum, Integer pageSize) {
        /*从session中提取uid*/
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        User user = userInfo.getUser();
        /*使用PageHelper进行分页*/
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleMapper.findAllByUId(user.getId());
        /*生成分页数据*/
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        /*创建返回数据类*/
        PageListResp<Article> pageList = new PageListResp<>();
        pageList.setList(pageInfo.getList());
        pageList.setTotal(Math.toIntExact(pageInfo.getTotal()));
        return pageList;
    }

    /*登录用户 修改兼职信息*/
    public void update(Integer id, ArticleReq articleReq) {
        // 获取用户session
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        User user = userInfo.getUser();
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article == null) {
            throw new ApiException(ReturnCode.RC10007);
        }
        if (!user.getId().equals(article.getUId())) {
            throw new ApiException(ReturnCode.RC10008);
        }
        BeanUtils.copyProperties(articleReq, article);
        int i = articleMapper.updateByPrimaryKeySelective(article);
        if (i != 1) {
            throw new ApiException(ReturnCode.RC10009);
        }
    }

    /*登录用户 删除兼职信息*/
    public void delete(Integer id) {
        // 获取用户session
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        User user = userInfo.getUser();
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article == null) {
            throw new ApiException(ReturnCode.RC10007);
        }
        if (!user.getId().equals(article.getUId())) {
            throw new ApiException(ReturnCode.RC10008);
        }
        article.setDeleted(true);
        int i = articleMapper.updateByPrimaryKeySelective(article);
        if (i != 1) {
            throw new ApiException(ReturnCode.RC10010);
        }
    }
}
