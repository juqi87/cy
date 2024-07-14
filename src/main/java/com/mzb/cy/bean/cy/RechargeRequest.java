package com.mzb.cy.bean.cy;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang.StringUtils;

@Data
@Accessors(chain = true)
public class RechargeRequest {

    private String interCode = "MU0001";
    private String character = "00";
    private String version = "1.0.0";
    private String ipAddress;
    private String partnerId;
    private String requestId;

    private String reqTime;//yyyyMMddHHmmss
    private String signType = "MD5";
    private String muCard;
    private String points;
    private String notifyUrl;
    private String hmac;

//    /**
//     *
//     * @return
//     */
//    @Override
//    public String toString(){
//        //将属性以key=value&的像是拼接
//        StringBuilder content = new StringBuilder();
//
//
//
//        if(StringUtils.isNotBlank(interCode)){
//            content.append("interCode=").append(interCode).append("&");
//        }
//
//
//
//        content.append("interCode=").append(interCode).append("&")
//                .append("character=").append(character).append("&")
//                .append("ipAddress=").append(ipAddress).append("&")
//                .append("partnerId=").append(partnerId).append("&")
//                .append("requestId=").append(requestId).append("&")
//                .append("reqTime=").append(reqTime).append("&")
//                .append("signType=").append(signType).append("&")
//                .append("version=").append(version).append("&")
//                .append("type=").append(type).append("&")
//
//                .append("muCard=").append(muCard).append("&")
//                .append("notifyUrl=").append(notifyUrl).append("&")
//                .append("points=").append(points).append("&");
//        return "";
//    }

}
