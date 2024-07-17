package com.mzb.cy.bean.cy;

import lombok.Data;

@Data
public class CyRechargeNotifyRequest {

    private String partnerId;
    private String reqTime;
    private String orderId;
    private String orderTime;
    private String orderStatus;
    private String hmac;

}
