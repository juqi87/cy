package com.mzb.cy.controller.donghang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RechargeNotifyController {


    @GetMapping("/cyRechargeNotify")
    public String cyRechargeNotify() {
        log.info("畅游订单异步响应通知");




        return "notify";
    }

}
