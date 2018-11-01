package com.frsp.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {

    /** 状态码. */
    private Integer status;

    /** 错误码. */
    private Integer errcode;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    private Integer total;
}
