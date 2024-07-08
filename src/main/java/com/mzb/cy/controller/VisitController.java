package com.mzb.cy.controller;

import com.mzb.cy.dao.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class VisitController {

    @Autowired
    private TestMapper testMapper;


    @RequestMapping("/visit")
    public String testVisit(){
        log.info("测试下server");
        String stat = testMapper.getVisitStat();
        return "server is ok, DB_STAT==>"+stat;
    }

}
