package com.mzb.cy.controller.donghang;

import com.mzb.cy.base.BaseController;
import com.mzb.cy.base.BaseResponse;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.bis.cy.RechargeManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class RechargeController extends BaseController {

    @Resource
    private RechargeManager rechargeManager;

    @GetMapping("/recharge")
    public String toRecharge(){
        log.info("进入充值页面");

        return "cy/recharge";
    }

    @PostMapping("/doRecharge")
    @ResponseBody
    public BaseResponse<Integer> doRecharge(RechargeVO vo){
        log.info("开始进行积分充值业务, vo==>{}", vo);
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        try{
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

    @GetMapping("/queryCyOrdLogList")
    public String queryCyOrdLogList(ModelMap model, RechargeVO condition){
        log.info("进入查询充值记录页面");

        try{
            List<CyOrdLogVO> vos = rechargeManager.queryLogForPage(condition);
            model.put("vos", vos);
            model.put("condition", condition);
            log.info("查询充值记录成功, vos==>{}", vos);
            log.info("查询条件返回, condition==>{}", condition);
        } catch (Exception e) {
            log.error("查询充值记录异常", e);
        }

        return "cy/cyLogList";
    }



}
