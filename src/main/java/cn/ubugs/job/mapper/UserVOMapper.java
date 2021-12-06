package cn.ubugs.job.mapper;

import cn.ubugs.job.domain.VO.UserVO;

public interface UserVOMapper {
    UserVO selectUserVO(String username);
}
