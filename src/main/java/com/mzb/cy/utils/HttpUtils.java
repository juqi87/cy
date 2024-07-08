package com.mzb.cy.utils;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

@Slf4j
public class HttpUtils {


    public static String doPostToJson(String urlPath, Map<String, String> header, String Json) {
        String result = "";
        BufferedReader reader = null;
        HttpURLConnection conn = null;
        try {
            trustAllHosts();
            URL url = new URL(urlPath);
            if (url.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
                httpsConn.setHostnameVerifier(DO_NOT_VERIFY);
                conn = httpsConn;
            }else {
                conn = (HttpURLConnection) url.openConnection();
            }

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
//            conn.setRequestProperty("Connection", "Keep-Alive");
//            conn.setRequestProperty("Charset", "UTF-8");
//            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            conn.setRequestProperty("accept", "application/json");
//            conn.setRequestProperty("Cookie", "JSESSIONID=5BcV5Wv+lR2Pp+rsJ27x2gNX.undefined; QIANHAIJSESSIONID=ONBugvA5qSFv1aoMOrpNbf2m6$isfGyF; mag_oper_id=juqi");
//            conn.setRequestProperty("Authorization", "Bearer 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");

            if(header != null){
                for(String key : header.keySet()){
                    conn.setRequestProperty(key, header.get(key));
                }
            }

            if (Json != null) {
                byte[] writebytes = Json.getBytes();
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(Json.getBytes());
                outwritestream.flush();
                outwritestream.close();
            }

            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//                result = reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }

            }

        }catch (Exception e) {
            log.error("请求异常", e.getMessage(), e);
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static void setDefaultRequestProperty(HttpURLConnection  conn, Map<String, String> requestPropertyMap) {
        for(String key : requestPropertyMap.keySet()){
            conn.setRequestProperty(key, requestPropertyMap.get(key));
        }
    }
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier()
    {
        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    };

    public static void trustAllHosts() {
        TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager(){

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[] {};
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

                }
            }

        };

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
