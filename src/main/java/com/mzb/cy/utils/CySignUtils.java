package com.mzb.cy.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @auther v-juqi
 * @createDate 2024/7/8 11:50
 **/
@Slf4j
public class CySignUtils {


    public static String sign(Map<String, String> paramsMap, String signkey){

        StringBuilder content = new StringBuilder();

        for (String key : paramsMap.keySet()){
            String value = paramsMap.get(key);
            content.append(key).append("=").append(value).append("&");
        }

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
        log.info("加签字符串:" + builder + signkey);
        log.info("签名:" + md5sign(signStr, "utf-8"));

        return signStr;
    }

    private static String md5sign(String source, String encode) {
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
