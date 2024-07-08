package com.mzb.cy;

import com.mzb.cy.bean.cy.RechargeRequest;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.utils.CySignUtils;
import com.mzb.cy.utils.DateUtils;
import com.mzb.cy.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

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

}
