package com.mzb.cy.dao;

import com.mzb.cy.dao.model.CyOrdLogDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CyOrdLogMapper {

    @Insert("insert into cy_ord_log " +
            "(ip_address, mu_card, ord_id, partner_id, points, stat, trans_date, trans_seq_id, trans_type) " +
            "values " +
            "(#{ipAddress}, #{muCard}, #{ordId}, #{partnerId}, #{points}, #{stat}, #{transDate}, #{transSeqId}, #{transType})")
    public Integer insert(CyOrdLogDO record);

    //根据主键修改
    @Update({"<script>" ,
                "<trim prefix='update' suffixOverrides=','>",
                    "<if test='ipAddress != null'>",
                        "ip_address=#{ipAddress},",
                    "</if>",
                    "<if test='muCard != null'>",
                        "mu_card=#{muCard},",
                    "</if>",
                    "<if test='ordId != null'>",
                        "ord_id=#{ordId},",
                    "</if>",
                    "<if test='partnerId != null'>",
                        "partner_id=#{partnerId},",
                    "</if>",
                    "<if test='points != null'>",
                        "points=#{points},",
                    "</if>",
                    "<if test='stat != null'>",
                        "stat=#{stat},",
                    "</if>",
                    "<if test='transType != null'>",
                        "trans_type=#{transType},",
                    "</if>",
                "</trim>",
            "where trans_date=#{transDate} and trans_seq_id=#{transSeqId}" ,
            "</script>"})
    public Integer updateByPk(CyOrdLogDO record);


    public List<CyOrdLogDO> queryForPage(CyOrdLogDO cyOrdLogDO);

}
