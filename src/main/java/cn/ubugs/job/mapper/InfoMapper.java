package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.Info;
import org.apache.ibatis.annotations.Param;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    Info findOneByUId(@Param("uId") Integer uId);


}