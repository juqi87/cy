package com.mzb.cy.bean.cy;

import lombok.Data;

@Data
public class QueryRechargeResult {

    private String partnerId;
    private String requestId;
    private String interCode;
    private String signType;
    private String orderId;
    private String muCard;
    private String status;
    private String version;
    private String hmac;

}
