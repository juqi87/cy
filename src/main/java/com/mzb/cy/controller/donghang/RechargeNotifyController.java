package com.mzb.cy.controller.donghang;

import com.mzb.cy.base.BasicRespCode;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.bean.cy.CyRechargeNotifyRequest;
import com.mzb.cy.bean.cy.base.CyBaseResponse;
import com.mzb.cy.dao.CyOrdLogMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.enums.TransStatEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.List;

@RestController
@Slf4j
public class RechargeNotifyController {

    @Autowired
    private CyOrdLogMapper cyOrdLogMapper;


    @GetMapping("/cyRechargeNotify")
    public CyBaseResponse cyRechargeNotify(CyRechargeNotifyRequest request) {
        log.info("畅由订单异步响应通知， CyRechargeNotifyRequest==>{}", request);
        CyBaseResponse cyBaseResponse = new CyBaseResponse();
        try{
            //校验


            //更新DB
            List<CyOrdLogDO> list = cyOrdLogMapper.queryByOrdId(request.getOrderId());
            if(CollectionUtils.isEmpty(list)){
                log.info("畅由订单异步响应通知， 订单不存在， orderId==>{}", request.getOrderId());
                throw new BusinessException(BasicRespCode.DATA_IS_NULL);
            }

            CyOrdLogDO cyOrdLogDO = list.get(0);
            log.info("畅由订单异步响应通知， 对应cyOrdLogDO==>{}", cyOrdLogDO);
            if(!StringUtils.equals(cyOrdLogDO.getStat(), TransStatEnum.P.getCode())){
                log.info("畅由订单异步响应通知， 订单状态非P， orderId==>{}", request.getOrderId());
                throw new BusinessException(BasicRespCode.FINAL_DATA_NOT_EXIST);
            }

            CyOrdLogDO cyOrdLogDOUpdate = new CyOrdLogDO();
            cyOrdLogDOUpdate.setTransDate(cyOrdLogDO.getTransDate())
                            .setTransSeqId(cyOrdLogDO.getTransSeqId());
            if(StringUtils.equals(request.getOrderStatus(), "1")){
                cyOrdLogDOUpdate.setStat(TransStatEnum.S.getCode());
            }else if(StringUtils.equals(request.getOrderStatus(), "2")){
                cyOrdLogDOUpdate.setStat(TransStatEnum.F.getCode());
            }
            cyOrdLogMapper.updateByPk(cyOrdLogDOUpdate);
            cyBaseResponse.setCode(BasicRespCode.SUCCESS.getRespCode());
            cyBaseResponse.setMsg(BasicRespCode.SUCCESS.getRespDesc());
        } catch (BusinessException be){
            log.error("畅由订单异步响应通知， 业务异常", be);
            cyBaseResponse.setCode(be.getErrCode());
            cyBaseResponse.setMsg(be.getErrDesc());
        } catch (Exception e){
            log.error("畅由订单异步响应通知， 系统异常", e);
            cyBaseResponse.setCode(BasicRespCode.FAILED.getRespCode());
            cyBaseResponse.setMsg(BasicRespCode.FAILED.getRespDesc());
        }

        return cyBaseResponse;
    }

}
