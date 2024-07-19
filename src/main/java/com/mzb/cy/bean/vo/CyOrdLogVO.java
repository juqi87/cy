package com.mzb.cy.bean.vo;

import com.mzb.cy.dao.model.CyOrdLogDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class CyOrdLogVO extends CyOrdLogDO {

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;


    private String statDesc;

    private String updateAtDesc;

}
