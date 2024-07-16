package com.mzb.cy.enums;

import lombok.Getter;

@Getter
public enum TransTypeEnum {

    CYDH("CYDH", "畅由东航充值")
    ;

    private final String type;
    private final String desc;

    TransTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
