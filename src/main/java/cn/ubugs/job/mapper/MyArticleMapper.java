package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.ArticleWithUser;

import java.util.List;

public interface MyArticleMapper {
    List<ArticleWithUser> selectAll();
}
