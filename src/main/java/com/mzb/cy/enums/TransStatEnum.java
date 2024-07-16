package com.mzb.cy.enums;

import lombok.Getter;

@Getter
public enum TransStatEnum {

    I("I", "初始"),
    P("P", "处理中"),
    S("S", "成功"),
    F("F", "失败"),
    C("C", "取消"),

    ;

    private final String code;
    private final String desc;

    TransStatEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TransStatEnum getByCode(String code) {
        for (TransStatEnum transStatEnum : TransStatEnum.values()) {
            if (transStatEnum.getCode().equals(code)) {
                return transStatEnum;
            }
        }
        return null;
    }
}
