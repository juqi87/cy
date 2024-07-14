package com.mzb.cy.service.cy.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.bean.cy.RechargeRequest;
import com.mzb.cy.bean.cy.RechargeResponse;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.enums.CyRespEnum;
import com.mzb.cy.service.cy.RechargeService;
import com.mzb.cy.utils.CySignUtils;
import com.mzb.cy.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class RechargeServiceImpl implements RechargeService {


    @Override
    public void recharge(RechargeVO vo) {

        String requestId = "requestId" + UUID.randomUUID().toString();

        RechargeRequest request = new RechargeRequest();
        request.setRequestId(requestId)
                .setPartnerId(CyConstant.partnerId)
                .setMuCard(vo.getMuCard())
                .setPoints(vo.getPoints().toString())
                .setIpAddress("112.64.63.231")
                .setReqTime(DateUtils.getCurrentTime())
                .setNotifyUrl(CyConstant.notifyUrl);

        String macContent = CySignUtils.signContent(request, CyConstant.key);

        //DB

        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");


        log.info("调用畅由支付接口，macContent:{}",macContent);
        String response = HttpRequest.post(CyConstant.url)
                .addHeaders(head).body(macContent)
                .timeout(30000)
                .execute()
                .body();
        log.info("调用畅由支付接口，response:{}",response);

        RechargeResponse result = JSON.parseObject(response, RechargeResponse.class);

        if(!StringUtils.equals(result.getCode(), CyRespEnum.SUCCESS.getCode())){
            log.info("调用畅由支付接口失败，订单号:{}",result.getOrderId());
            throw new BusinessException(result.getCode(), result.getMsg());
        }

        log.info("调用畅由支付接口成功，订单号:{}",result.getOrderId());


    }

    @Override
    public void queryResult(RechargeVO vo) {
        log.info("调用畅由支付接口查询结果");



    }
}
