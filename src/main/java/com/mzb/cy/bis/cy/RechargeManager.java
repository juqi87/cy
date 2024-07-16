package com.mzb.cy.bis.cy;

import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;
import com.mzb.cy.dao.model.CyOrdLogDO;

import java.util.List;

public interface RechargeManager {

    public void recharge(RechargeVO vo);

    public List<CyOrdLogVO> queryLogForPage(RechargeVO vo);

    public String queryResult(CyOrdLogDO cyOrdLogDO);

    public CyOrdLogVO queryLogBy(String transDate, String transSeqId);

}
