package com.mzb.cy;

import com.mzb.cy.bean.cy.RechargeRequest;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.utils.CySignUtils;
import com.mzb.cy.utils.DateUtils;
import com.mzb.cy.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther v-juqi
 * @createDate 2024/7/8 16:18
 **/
@Slf4j
public class Test2 {

    public static void main(String[] args) {
        RechargeRequest req = new RechargeRequest();
        req.setIpAddress("127.0.0.1")
                .setPartnerId(CyConstant.partnerId)
                .setRequestId(UUID.randomUUID().toString())
                .setReqTime(DateUtils.getCurrentDateTime())
                .setMuCard("123456")
                .setPoints("100")
                .setNotifyUrl("http://www.baidu.com");
        // RechargeRequest对象转为map


//        String hmac = CySignUtils.sign(req.toMap(), CyConstant.key);

        log.info("RechargeRequest req:{}", req);

        Map<String, String> header = new HashMap<>();
        header.put("AuthToken", CyConstant.AuthToken);

//        HttpUtils.doPostToJson();


    }

    public static void test11(){
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // 创建HttpPost对象，指定请求URL
            HttpPost httpPost = new HttpPost(CyConstant.url);

            // 设置请求体
            StringEntity input = new StringEntity("{\"key\":\"value\"}", "UTF-8");
            input.setContentType("application/json");
            httpPost.setEntity(input);

            // 执行POST请求
            CloseableHttpResponse response = httpClient.execute(httpPost);

            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();

                // 打印响应状态码和响应内容
                System.out.println("Response status: " + response.getStatusLine().getStatusCode());
                if (entity != null) {
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
            } finally {
                // 关闭响应
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭客户端
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
