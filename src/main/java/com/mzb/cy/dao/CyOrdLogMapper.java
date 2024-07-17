package com.mzb.cy.dao;

import com.mzb.cy.dao.model.CyOrdLogDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
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
                "update cy_ord_log ",
                "<trim prefix='set' suffixOverrides=','>",
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
                    "<if test='respCode != null'>",
                        "resp_code=#{respCode},",
                    "</if>",
                    "<if test='respMsg != null'>",
                        "resp_msg=#{respMsg},",
                    "</if>",
                "</trim>",
            "where trans_date=#{transDate} and trans_seq_id=#{transSeqId}" ,
            "</script>"})
    public Integer updateByPk(CyOrdLogDO record);


    @Select({"<script>" ,
                "select count(1) from cy_ord_log  ",
                "where 1=1",
                    "<if test='transDate != null'>",
                    "and trans_date=#{transDate}",
                    "</if>",
                    "<if test='transSeqId != null'>",
                    "and trans_seq_id=#{transSeqId}",
                    "</if>",
                    "<if test='muCard != null'>",
                        "and mu_card=#{muCard}",
                    "</if>",
                    "<if test='transType != null'>",
                        "and trans_type=#{transType}",
                    "</if>",
                    "<if test='stat != null'>",
                        "and stat=#{stat}",
                    "</if>",
            "</script>"})
    public Integer countForPage(CyOrdLogDO condition);

    public List<CyOrdLogDO> queryForPage(CyOrdLogDO condition);

}
