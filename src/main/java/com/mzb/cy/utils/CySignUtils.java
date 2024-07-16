package com.mzb.cy.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Map;

@Slf4j
public class CySignUtils {


    public static <T> String signContent(T obj, String signkey){

        StringBuilder content = new StringBuilder();

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                // 设置访问权限，因为字段可能是私有的
                field.setAccessible(true);
                if(field.get(obj) == null){
                    continue;
                }
                content.append(field.getName())
                        .append("=")
                        .append(field.get(obj))
                        .append("&");
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
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
        String sign  = MD5Utils.md5sign(signStr, "utf-8");
        log.info("签名:" + sign);

        content.append("hmac=").append(sign);


        return content.toString();
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
