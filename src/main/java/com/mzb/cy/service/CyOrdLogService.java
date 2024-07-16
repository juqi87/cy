package com.mzb.cy.service;

import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.dao.model.CyOrdLogDO;

import java.util.List;

public interface CyOrdLogService {

    public List<CyOrdLogDO> queryLogForPage(RechargeVO vo);

}
