package com.mzb.cy.bean.vo;

import com.mzb.cy.dao.model.CyOrdLogDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CyOrdLogVO extends CyOrdLogDO {

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;

}
