package com.frsp.service.impl;

import com.alibaba.fastjson.JSON;
import com.frsp.BaseTest;
import com.frsp.service.UserService;
import com.frsp.vo.UserVo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest{
    @Resource
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLogin(){
        UserVo wangjianhua = userService.findUserByUsername("admin");
        System.out.println(JSON.toJSONString(wangjianhua));
    }



    @After
    public void tearDown() throws Exception {
    }
}