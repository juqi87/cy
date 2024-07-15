package com.mzb.cy.service.cy;

import com.mzb.cy.bean.vo.CyOrdLogVO;
import com.mzb.cy.bean.vo.RechargeVO;

import java.util.List;

public interface RechargeService {


    public void recharge(RechargeVO vo);

    public List<CyOrdLogVO> queryLogForPage(RechargeVO vo);

    public void queryResult(RechargeVO vo);

}
