package com.mzb.cy.controller;

import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.dao.TestMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.service.CyOrdLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class VisitController {

    @Autowired
    private TestMapper testMapper;


    @GetMapping("/visit")
    public String testVisit(){
        log.info("测试下server");
        String stat = testMapper.getVisitStat();
        return "server is ok, DB_STAT==>"+stat;
    }

    @GetMapping("/visitIndex")
    public String testIndex(){
        log.info("测试index页面");
        return "index";
    }



    @Autowired
    CyOrdLogService cyOrdLogService;

    @ResponseBody
    @GetMapping("/test")
    public List<CyOrdLogDO> test(){
        log.info("测试下server");
        RechargeVO vo = new RechargeVO();
        vo.setPageNum(1)
                .setPageSize(10);

        List<CyOrdLogDO> list = cyOrdLogService.queryLogForPage(vo);

        return list;
    }

}
