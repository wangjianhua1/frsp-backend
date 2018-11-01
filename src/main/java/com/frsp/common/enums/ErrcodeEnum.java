package com.frsp.common.enums;

import lombok.Getter;

@Getter
public enum ErrcodeEnum {

    //通用错误码
    SYS_ERR(1, "系统错误"),

    PARAM_ERR(2, "参数错误"),

    AUTH_ERR(3, "认证错误"),

    REQUEST_ERR(4, "请求方式错误"),

    ADD_ERR(6, "添加失败"),

    DEL_ERR(7, "删除失败"),

    UPDATE_ERR(8, "更新失败"),

    FIND_ERR(9, "查询失败"),
    ;











    private Integer code;

    private String message;

    ErrcodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
