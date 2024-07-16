package com.mzb.cy.service.impl;

import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.dao.CyOrdLogMapper;
import com.mzb.cy.dao.model.CyOrdLogDO;
import com.mzb.cy.dao.model.ext.CyOrdLogExtDO;
import com.mzb.cy.service.CyOrdLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
        log.info("queryLogForPage:{}", vo);

        CyOrdLogExtDO cyOrdLogExtDO = new CyOrdLogExtDO();
        BeanUtils.copyProperties(vo, cyOrdLogExtDO);
        cyOrdLogExtDO.setOffset((vo.getPageNum() - 1) * vo.getPageSize());

        Integer total = cyOrdLogMapper.countForPage(cyOrdLogExtDO);
        vo.setTotalNum(total);
        if(total == 0){
            return null;
        }

        return cyOrdLogMapper.queryForPage(cyOrdLogExtDO);
    }

}
