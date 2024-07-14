package com.mzb.cy.base;

public enum BasicRespCode {

    SUCCESS("0000", "交易成功"),
    RESULT_FAILED("0101", "请求失败"),
    DATA_NULL("0001", "请求参数含有空数据"),
    DATA_LENGTH_ERROR("0002", "请求参数长度不正确"),
    FINAL_DATA_NOT_EXIST("0003", "固定数据没有匹配项"),
    DATA_FOMART_MATCH_ERROR("0004", "数据格式不正确"),
    DATA_IS_NULL("0005", "暂无数据"),
    DATA_INSERT_FAIL("0006", "数据新增失败"),

    ;


    private String respCode;
    private String respDesc;

    private BasicRespCode(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }
}
