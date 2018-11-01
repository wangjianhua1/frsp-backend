package com.frsp.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.frsp.entity.FrspUser;
import com.frsp.mapper.FrspUserMapper;
import com.frsp.service.UserService;
import com.frsp.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<FrspUserMapper, FrspUser> implements UserService {
    @Autowired
    protected FrspUserMapper frspUserMapper;

    @Override
    public UserVo findUserByUsername(String username) {
        FrspUser user = frspUserMapper.findUserByUsername(username);
        UserVo userVo=new UserVo();
        userVo.setUsername(user.getUsername());
        return userVo;
    }
}
