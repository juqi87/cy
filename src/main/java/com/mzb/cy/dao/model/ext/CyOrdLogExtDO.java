package com.mzb.cy.dao.model.ext;


import com.mzb.cy.dao.model.CyOrdLogDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CyOrdLogExtDO extends CyOrdLogDO {

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;

}
