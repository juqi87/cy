package com.mzb.cy.enums;


import lombok.Data;

public enum CyRespEnum {

    SUCCESS("0000", "成功"),
    INVALID_PARAM("1000", "请求参数错误"),
    INVALID_SIGN("1001", "其他系统错误"),
    FAIL("9999", "系统忙，请稍后再试"),
    ;

    CyRespEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
