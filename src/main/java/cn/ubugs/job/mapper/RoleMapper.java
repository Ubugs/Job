package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role findOneByInitial(@Param("initial") Boolean initial);


}