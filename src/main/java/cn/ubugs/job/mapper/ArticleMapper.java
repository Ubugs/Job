package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> findAllByUId(@Param("uId") Integer uId);

    Map<String, Integer> findAllSumByUId(Integer uId);

    int updateStateById(@Param("updatedState") Integer updatedState, @Param("id") Integer id);


}