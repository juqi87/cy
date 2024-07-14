package com.mzb.cy.controller.cy;

import com.mzb.cy.base.BaseController;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.service.cy.RechargeService;
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
    private RechargeService rechargeService;

    @GetMapping("recharge")
    public String toRecharge(){
        log.info("进入充值页面");

        return "recharge";
    }

    @PostMapping
    @ResponseBody
    public String doRecharge(RechargeVO vo){
        log.info("开始进行积分充值业务, vo==>{}", vo);

        try{
            rechargeService.recharge(vo);
        }catch (Exception e) {
            log.error("积分充值业务异常", e);

        }

        return "";
    }

}
