package com.frsp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回实体类
 */
@Data
public class UserVo implements Serializable {
    private String username;
    private String password;
    private String status;

}
