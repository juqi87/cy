package com.mzb.cy.base;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    private String code;
    private String msg;

    private T data;

}
