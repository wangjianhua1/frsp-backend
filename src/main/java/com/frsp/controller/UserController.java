package com.frsp.controller;

import com.frsp.service.UserService;
import com.frsp.utils.ResultVOUtils;
import com.frsp.vo.ResultVO;
import com.frsp.vo.UserDto;
import com.frsp.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserDto dto){
        UserVo user = userService.findUserByUsername(dto.getUsername());
        return ResultVOUtils.success(user);
    }
}
