package com.mzb.cy.dao.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class CyOrdLogDO {

    private String transDate;

    private String transSeqId;

    private String transType;

    private String muCard;

    private String points;

    private String ipAddress;

    private String partnerId;

    private String stat;

    private String ordId;

    private String respCode;

    private String respMsg;

    private Timestamp createAt;

    private Timestamp updateAt;

}