package com.mzb.cy.bean.cy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RechargeResultRequest {

    private String interCode = "MU0001";
    private String character = "00";
    private String version = "1.0.0";
    private String ipAddress;
    private String partnerId;
    private String requestId;

    private String reqTime;//yyyyMMddHHmmss
    private String signType = "MD5";
    private String orderId;
    private String muCard;

    private String hmac;

}
