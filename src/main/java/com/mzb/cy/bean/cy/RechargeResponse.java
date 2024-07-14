package com.mzb.cy.bean.cy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RechargeResponse {

    private String code;
    private String msg;
    private String partnerId;
    private String requestId;
    private String interCode;
    private String signType;
    private String orderId;
    private String muCard;
    private String version;
    private String hmac;
    //data  ?

}
