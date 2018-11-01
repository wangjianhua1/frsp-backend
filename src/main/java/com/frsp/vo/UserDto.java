package com.frsp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户相关请求入参类
 */
@Data
public class UserDto implements Serializable {
    private Long id;

    private String username;

    private String password;
}
