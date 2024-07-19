package com.mzb.cy.bis.cy.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.mzb.cy.base.BasicRespCode;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.bean.cy.QueryRechargeRequest;
import com.mzb.cy.bean.cy.RechargeRequest;
import com.mzb.cy.bean.cy.QueryRechargeResult;
import com.mzb.cy.bean.cy.RechargeResult;
import com.mzb.cy.bean.cy.base.CyBaseResponse;
import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.bis.cy.RechargeManager;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.dao.CyOrdLogMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.enums.CyRespEnum;
import com.mzb.cy.enums.TransStatEnum;
import com.mzb.cy.enums.TransTypeEnum;
import com.mzb.cy.service.CyOrdLogService;
import com.mzb.cy.service.SequenceService;
import com.mzb.cy.utils.CySignUtils;
import com.mzb.cy.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service("rechargeManager")
@Slf4j
public class RechargeManagerImpl implements RechargeManager {


    @Autowired
    private CyOrdLogMapper cyOrdLogMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private CyOrdLogService cyOrdLogService;

    @Override
    public void recharge(RechargeVO vo) {

        String transDate = DateUtils.getCurrentDate();
        String transSeqId = sequenceService.getCyOrdSeqId();
        String requestId = "mzb" + transDate + transSeqId;

        CyOrdLogDO cycleLogDO = new CyOrdLogDO();
        cycleLogDO.setTransDate(transDate)
                .setTransSeqId(transSeqId)
                .setTransType(TransTypeEnum.CYDH.getType())
                .setStat(TransStatEnum.I.getCode())
                .setMuCard(vo.getMuCard())
                .setPoints(vo.getPoints().toString())
                .setIpAddress(CyConstant.ip_add)
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
                .setIpAddress(CyConstant.ip_add)
                .setReqTime(DateUtils.getCurrentDateTime())
                .setNotifyUrl(CyConstant.notifyUrl);

        String macContent = CySignUtils.signContent(request, CyConstant.key);


        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");

        log.info("调用畅由支付接口，macContent:{}",macContent);
        String response = HttpRequest.post(CyConstant.recharge_url)
                .addHeaders(head)
                .body(macContent)
                .timeout(30000)
                .execute()
                .body();
        log.info("调用畅由支付接口，response:{}",response);

        CyBaseResponse result = JSON.parseObject(response, CyBaseResponse.class);

        CyOrdLogDO cyOrdLogDOUpdate = new CyOrdLogDO();
        cyOrdLogDOUpdate.setTransDate(transDate)
                        .setTransSeqId(transSeqId)
                        .setRespCode(result.getCode())
                        .setRespMsg(result.getMsg());

        if(StringUtils.equals(result.getCode(), CyRespEnum.SUCCESS.getCode())
            || StringUtils.equals(result.getCode(), "0")){
            RechargeResult rechargeResult = JSON.parseObject(result.getData(), RechargeResult.class);

            log.info("调用畅由支付接口成功，订单号:{}",rechargeResult.getOrderId());
            cyOrdLogDOUpdate.setStat(TransStatEnum.P.getCode())
                    .setOrdId(rechargeResult.getOrderId());
            cyOrdLogMapper.updateByPk(cyOrdLogDOUpdate);
        }else{
            log.info("调用畅由支付接口失败，订单==>{}, resp=>:{}", cycleLogDO, result.getCode());
            cyOrdLogDOUpdate.setStat(TransStatEnum.F.getCode());
            cyOrdLogMapper.updateByPk(cyOrdLogDOUpdate);
            throw new BusinessException(result.getCode(), result.getMsg());
        }

    }

    @Override
    public List<CyOrdLogVO> queryLogForPage(RechargeVO vo) {
        log.info("分页查询log结果， condition==>{}", vo);

        if(vo.getPageNum() == null){
            vo.setPageNum(1)
                .setPageSize(10);
        }

        List<CyOrdLogDO> cyOrdLogDOList = cyOrdLogService.queryLogForPage(vo);

        List<CyOrdLogVO> vos = new ArrayList<>();
        if(CollectionUtils.isEmpty(cyOrdLogDOList)){
            return null;
        }
        for (CyOrdLogDO cyOrdLogDO : cyOrdLogDOList) {
            CyOrdLogVO cyOrdLogVO = new CyOrdLogVO();
            BeanUtils.copyProperties(cyOrdLogDO, cyOrdLogVO);

            //处理中主动查询订单状态
            if(StringUtils.equals(cyOrdLogDO.getStat(), TransStatEnum.P.getCode())){
                cyOrdLogVO.setStat(queryResult(cyOrdLogDO));
            }
            cyOrdLogVO.setStatDesc(Objects.requireNonNull(TransStatEnum.getByCode(cyOrdLogDO.getStat())).getDesc());

            if(StringUtils.isBlank(cyOrdLogDO.getOrdId())){
                cyOrdLogVO.setOrdId("暂无");
            }
            vos.add(cyOrdLogVO);
        }

        return vos;
    }

    @Override
    public String queryResult(CyOrdLogDO cyOrdLogDO) {
        log.info("调用畅由支付接口查询结果");
        String logStat = cyOrdLogDO.getStat();


        Random random = new Random();
        int r = random.nextInt(1000)+1000;
        String requestId = "mzb-q" + r + cyOrdLogDO.getTransDate() + cyOrdLogDO.getTransSeqId();
        QueryRechargeRequest request = new QueryRechargeRequest();
        request.setIpAddress(CyConstant.ip_add)
                .setPartnerId(CyConstant.partnerId)
                .setRequestId(requestId)
                .setReqTime(DateUtils.getCurrentDateTime())
                .setOrderId(cyOrdLogDO.getOrdId())
                .setMuCard(cyOrdLogDO.getMuCard());

        String macContent = CySignUtils.signContent(request, CyConstant.key);

        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");

        log.info("调用畅由订单查询接口，request:{}",macContent);
        String response = HttpRequest.post(CyConstant.query_url)
                .addHeaders(head)
                .body(macContent)
                .timeout(30000)
                .execute()
                .body();
        log.info("调用畅由订单查询接口，response:{}",response);

        CyBaseResponse result = JSON.parseObject(response, CyBaseResponse.class);

        if(StringUtils.equals(result.getCode(), CyRespEnum.SUCCESS.getCode())
                || StringUtils.equals(result.getCode(), "0")){
            QueryRechargeResult queryRechargeResult = JSON.parseObject(result.getData(), QueryRechargeResult.class);
            switch (queryRechargeResult.getStatus()) {
                case "0":
                    break;
                case "1":
                    logStat = TransStatEnum.S.getCode();
                    break;
                case "2":
                    logStat = TransStatEnum.F.getCode();
                    break;
                default:
                    break;
            }

            CyOrdLogDO cyOrdLogDOUpdate = new CyOrdLogDO();
            cyOrdLogDOUpdate.setTransDate(cyOrdLogDO.getTransDate())
                    .setTransSeqId(cyOrdLogDO.getTransSeqId())
                    .setStat(logStat);
            cyOrdLogMapper.updateByPk(cyOrdLogDOUpdate);
            cyOrdLogDO.setStat(logStat);
        }

        return cyOrdLogDO.getStat();
    }

    @Override
    public CyOrdLogVO queryLogBy(String transDate, String transSeqId) {
        CyOrdLogDO cyOrdLogDO = new CyOrdLogDO();

        QueryRechargeRequest request = new QueryRechargeRequest();
        request.setIpAddress(CyConstant.ip_add)
                .setPartnerId(CyConstant.partnerId)
                .setRequestId("mzb-q" + transDate + transSeqId)
                .setReqTime(DateUtils.getCurrentDateTime())
                .setOrderId(cyOrdLogDO.getOrdId())
                .setMuCard(cyOrdLogDO.getMuCard());

        String macContent = CySignUtils.signContent(request, CyConstant.key);
        Map<String,String> head = new HashMap<>();
        head.put("AuthToken","123456");
        head.put("Content-Type","application/json");

        log.info("调用畅由订单查询接口，macContent:{}",macContent);
        String response = HttpRequest.post(CyConstant.query_url)
                .addHeaders(head)
                .body(macContent)
                .timeout(30000)
                .execute()
                .body();
        log.info("调用畅由订单查询接口，response:{}",response);



        return null;
    }
}
