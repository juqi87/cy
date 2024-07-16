package com.mzb.cy.controller.donghang;

import com.mzb.cy.base.BaseController;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.bis.cy.RechargeManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class RechargeController extends BaseController {

    @Resource
    private RechargeManager rechargeManager;

    @GetMapping("recharge")
    public String toRecharge(){
        log.info("进入充值页面");

        return "cy/recharge";
    }

    @PostMapping("doRecharge")
    @ResponseBody
    public String doRecharge(RechargeVO vo){
        log.info("开始进行积分充值业务, vo==>{}", vo);

        try{
            rechargeManager.recharge(vo);
        }catch (Exception e) {
            log.error("积分充值业务异常", e);

        }

        return "";
    }

}
