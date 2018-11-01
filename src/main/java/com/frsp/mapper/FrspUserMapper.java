package com.frsp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.frsp.entity.FrspUser;
import org.apache.ibatis.annotations.Param;

public interface FrspUserMapper extends BaseMapper<FrspUser> {
    FrspUser findUserByUsername(@Param("username") String username);
}
