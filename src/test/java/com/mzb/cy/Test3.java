package com.mzb.cy;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mzb.cy.bean.cy.QueryRechargeResult;
import com.mzb.cy.bean.cy.base.CyBaseResponse;

public class Test3 {

    public static void main(String[] args) {
        String resp = "{\"code\":0,\"msg\":\"成功\",\"data\":\"{\\\"orderId\\\":\\\"MU24071613331287000024\\\",\\\"requestId\\\":\\\"667d6eda-13be-4ddf-ad85-85774cecb4cd\\\",\\\"hmac\\\":\\\"e047e1aae828a003a02e079af0f92f6d\\\",\\\"muCard\\\":\\\"614011667001\\\",\\\"signType\\\":\\\"MD5\\\",\\\"partnerId\\\":\\\"S9990188\\\",\\\"interCode\\\":\\\"MU0001\\\",\\\"version\\\":\\\"1.0.0\\\"}\"}";

//        CyBaseResponse<QueryRechargeResult> result = JSON.parseObject(resp, new TypeReference<CyBaseResponse<QueryRechargeResult>>(){});

//        System.out.println(result);
    }



}
