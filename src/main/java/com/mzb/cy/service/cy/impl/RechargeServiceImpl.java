package com.mzb.cy.service.cy.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.mzb.cy.base.BasicRespCode;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.bean.cy.RechargeRequest;
import com.mzb.cy.bean.cy.RechargeResponse;
import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.dao.CyOrdLogMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.enums.CyRespEnum;
import com.mzb.cy.enums.TransStatEnum;
import com.mzb.cy.service.SequenceService;
import com.mzb.cy.service.cy.RechargeService;
import com.mzb.cy.utils.CySignUtils;
import com.mzb.cy.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class RechargeServiceImpl implements RechargeService {


    @Autowired
    private CyOrdLogMapper cyOrdLogMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public void recharge(RechargeVO vo) {

        String transDate = DateUtils.getCurrentDate();
        String transSeqId = sequenceService.getCyOrdSeqId();
        String requestId = "mzb" + transDate + transSeqId;

        CyOrdLogDO cycleLogDO = new CyOrdLogDO();
        cycleLogDO.setTransDate(transDate)
                    .setTransSeqId(transSeqId)
                    .setTransType("CYDH")
                    .setStat(TransStatEnum.I.getCode())
                    .setMuCard(vo.getMuCard())
                    .setPoints(vo.getPoints().toString())
                    .setIpAddress("112.64.63.231")
                    .setPartnerId(CyConstant.partnerId);

        log.info("插入订单日志:{}", cycleLogDO);
        int resp = cyOrdLogMapper.insert(cycleLogDO);
        if(resp != 1){
            log.error("插入订单日志失败");
            throw new BusinessException(BasicRespCode.DATA_INSERT_FAIL);
        }

        RechargeRequest request = new RechargeRequest();
        request.setRequestId(requestId)
                .setPartnerId(CyConstant.partnerId)
                .setMuCard(vo.getMuCard())
                .setPoints(vo.getPoints().toString())
                .setIpAddress("112.64.63.231")
                .setReqTime(DateUtils.getCurrentDateTime())
                .setNotifyUrl(CyConstant.notifyUrl);

        String macContent = CySignUtils.signContent(request, CyConstant.key);


        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");

        log.info("调用畅由支付接口，macContent:{}",macContent);
        String response = HttpRequest.post(CyConstant.url)
                .addHeaders(head)
                .body(macContent)
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
        CyOrdLogDO cyOrdLogDOUpdate = new CyOrdLogDO();
        cyOrdLogDOUpdate.setTransDate(transDate)
                .setTransSeqId(transSeqId)
                .setStat(TransStatEnum.P.getCode())
                .setOrdId(result.getOrderId());

        resp = cyOrdLogMapper.updateByPk(cyOrdLogDOUpdate);
        if(resp != 1){
            log.error("更新订单日志失败, cyOrdLogDOUpdate==>{}", cyOrdLogDOUpdate);
            throw new BusinessException(BasicRespCode.DATA_UPDATE_FAIL);
        }
    }

    @Override
    public List<CyOrdLogVO> queryLogForPage(RechargeVO vo) {
        log.info("分页查询log结果， condition==>{}", vo);



        return null;
    }

    @Override
    public void queryResult(RechargeVO vo) {
        log.info("调用畅由支付接口查询结果");




    }
}
