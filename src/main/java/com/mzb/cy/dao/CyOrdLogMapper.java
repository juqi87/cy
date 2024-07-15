package com.mzb.cy.dao;

import com.mzb.cy.dao.model.CyOrdLogDO;
import org.apache.ibatis.annotations.Insert;

public interface CyOrdLogMapper {

    @Insert("insert into cy_ord_log " +
            "(ip_address, mu_card, ord_id, partner_id, points, stat, trans_date, trans_seq_id, trans_type) " +
            "values " +
            "(#{ipAddress}, #{muCard}, #{ordId}, #{partnerId}, #{points}, #{stat}, #{transDate}, #{transSeqId}, #{transType})")
    public void insert(CyOrdLogDO record);

}
