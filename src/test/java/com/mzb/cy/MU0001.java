package com.mzb.cy;

import cn.hutool.http.HttpRequest;
import com.mzb.cy.utils.MD5Utils;

import java.util.HashMap;
import java.util.Map;

public class MU0001 {


    public static void main(String[] args) {

        String url= "https://test-m-stg3.ppppoints.com/partner-gateway/points/recharge/mu/placeOrder";
        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");

        StringBuilder content = new StringBuilder();
        content.append("interCode=").append("MU0001").append("&")
                .append("character=").append("UTF-8").append("&")
                .append("ipAddress=").append("112.64.63.231").append("&")
                .append("partnerId=").append("S9990188").append("&")
                .append("requestId=").append("201658781116").append("&")
                .append("reqTime=").append("20190416195825").append("&")
                .append("signType=").append("MD5").append("&")
                .append("version=").append("1.0.0").append("&")
                .append("type=").append("api").append("&")

                .append("muCard=").append("614011667001").append("&")
                .append("notifyUrl=").append("https://open.jf.10086.cn/open/bind/bindForm").append("&")
                .append("points=").append("500").append("&");

        String[] arrs = content.toString().split("\\&");
        StringBuilder builder = new StringBuilder();
        for (String vaule : arrs) {
            String[] params = vaule.split("\\=");
            String key = params[0];
            if (params != null && params.length  >  1) {
                // 防止出现特殊字符，导致解析异常
                String valueStr = vaule.substring(vaule.indexOf("=") + 1, vaule.length());
                if (!key.equals("hmac")) {
                    builder.append(valueStr);
                }
            }
        }
        String signStr = builder.toString() + "123456";
        System.out.println("加签字符串:" + builder + "123456");
        String sign  = MD5Utils.md5sign(signStr, "utf-8");
        content.append("hmac=").append(sign);
        System.out.println(content.toString());

        String response = HttpRequest.post(url).addHeaders(head).body(content.toString()).timeout(30000).execute().body();
        System.out.println(response);


    }
}

