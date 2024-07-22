package com.mzb.cy.controller.donghang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mzb.cy.base.BaseController;
import com.mzb.cy.base.BaseResponse;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.base.DataTableResponse;
import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.bis.cy.RechargeManager;
import com.mzb.cy.common.CyConstant;
import com.mzb.cy.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class RechargeController extends BaseController {

    @Resource
    private RechargeManager rechargeManager;

    @GetMapping("/recharge")
    public String toRecharge(){
        log.info("进入充值页面");

        return "cy/recharge1";
    }

    @PostMapping("/doRecharge")
    @ResponseBody
    public BaseResponse<Integer> doRecharge(RechargeVO vo, HttpServletRequest request){
        log.info("开始进行积分充值业务, vo==>{}", vo);
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        try{
            String ip = IPUtils.getClientIP(request);
            log.info("充值IP=====>{}", ip);
            //判断ip是否在CyConstant.whiteIPs中
//            if(!contains( CyConstant.whiteIPs, ip)){
//                log.info("IP地址不在白名单内, ip==>{}", ip);
//                throw new BusinessException("1111","IP地址不在白名单内(CY)");
//            }

            rechargeManager.recharge(vo);
        }catch (BusinessException be) {
            log.error("积分充值业务异常", be);
            return failResp(be);
        }catch (Exception e){
            log.error("系统异常", e);
            return failResp();
        }

        return successResp(null);
    }

    @GetMapping("/cyOrdLogList")
    public String cyOrdLogList(){
        log.info("进入查询充值记录页面");

        return "cy/cyLogList";
    }

    @GetMapping("/queryCyOrdLogList")
    public String queryCyOrdLogList(ModelMap model, RechargeVO condition){
        log.info("进入查询充值记录页面");

        try{
            List<CyOrdLogVO> vos = rechargeManager.queryLogForPage(condition);
            model.put("vos", JSON.toJSONString(vos, SerializerFeature.WriteMapNullValue));
            model.put("condition", condition);
            log.info("查询充值记录成功, vos==>{}", vos);
            log.info("查询条件返回, condition==>{}", condition);
        } catch (Exception e) {
            log.error("查询充值记录异常", e);
        }

        return "cy/cyLogList";
    }

    @PostMapping("/queryCyOrdLogList")
    @ResponseBody
    public DataTableResponse<CyOrdLogVO> queryCyOrdLogList(RechargeVO condition){
        log.info("分页查询呢畅由订单日志信息， condition==>{}", condition);
        DataTableResponse<CyOrdLogVO> dataTableResponse = new DataTableResponse<CyOrdLogVO>();
        dataTableResponse.setDraw(condition.getDraw());
        try{
            List<CyOrdLogVO> vos = rechargeManager.queryLogForPage(condition);
            dataTableResponse.setData(vos)
                            .setRecordsFiltered(condition.getTotalNum())
                            .setRecordsTotal(condition.getTotalNum());
        }catch(BusinessException be){
            log.error("分页查询呢畅由订单日志信息异常", be);
            dataTableResponse.setError(be.getMessage());
        }catch(Exception e){
            log.error("系统异常", e);
            dataTableResponse.setError("系统异常");
        }

        log.info("分页查询呢畅由订单日志信息成功, dataTableResponse==>{}", dataTableResponse);
        return dataTableResponse;
    }

    private boolean contains(String[] array, String value) {
        for (String element : array) {
            if (StringUtils.equals(element, value)) {
                return true;
            }
        }
        return false;
    }

}
