package com.mzb.cy;

import java.net.URLEncoder;

public class Test1 {

    public static void main(String[] args) throws Exception {
        // callbackUrl需要encode 使用java.net.URLEncoder
        String callBackUrl = URLEncoder.encode("https://www.baidu.com", "utf-8");
        StringBuilder content = new StringBuilder();
        content.append("interCode=").append("CYS0001").append("&")
                .append("character=").append("00").append("&")
                .append("ipAddress=").append("127.0.0.1").append("&")
                .append("partnerId=").append("S1000251").append("&")
                .append("requestId=").append("201103071740065878").append("&")
                .append("reqTime=").append("20190416195825").append("&")
                .append("mobile=").append("15591815501").append("&")
                .append("callbackUrl=").append(callBackUrl).append("&");


        String signkey = "123456";

        System.out.println(content.toString());
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
        String signStr = builder.toString() + signkey;
        System.out.println("加签字符串:" + builder + signkey);
        System.out.println("签名:" + md5sign(signStr, "utf-8"));

    }

    public static String md5sign(String source, String encode) {
        String result = null;
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source.getBytes(encode));
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

