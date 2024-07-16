package com.mzb.cy.service.impl;

import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.dao.CyOrdLogMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.service.CyOrdLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CyOrdLogServiceImpl implements CyOrdLogService {

    @Autowired
    private CyOrdLogMapper cyOrdLogMapper;


    @Override
    public List<CyOrdLogDO> queryLogForPage(RechargeVO vo) {


        return null;
    }

}
