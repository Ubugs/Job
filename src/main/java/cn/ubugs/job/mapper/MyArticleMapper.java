package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.ArticleWithInfo;

import java.util.List;

public interface MyArticleMapper {
    List<ArticleWithInfo> selectAll();
}
