package com.mzb.cy.bean.cy.base;

import lombok.Data;

@Data
public class CyBaseResponse<T> {

    private String code;
    private String msg;
    private T data;

}
