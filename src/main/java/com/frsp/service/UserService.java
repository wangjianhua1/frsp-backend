package com.frsp.service;

import com.frsp.entity.FrspUser;
import com.frsp.vo.UserVo;

public interface UserService {
    UserVo findUserByUsername(String username);
}
