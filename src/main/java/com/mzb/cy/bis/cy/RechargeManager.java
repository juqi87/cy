package com.mzb.cy.bis.cy;

import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;

import java.util.List;

public interface RechargeManager {

    public void recharge(RechargeVO vo);

    public List<CyOrdLogVO> queryLogForPage(RechargeVO vo);

    public void queryResult(RechargeVO vo);

    public CyOrdLogVO queryLogBy(String transDate, String transSeqId);

}
