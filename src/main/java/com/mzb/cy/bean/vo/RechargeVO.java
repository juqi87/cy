package com.mzb.cy.bean.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RechargeVO {

    private String muCard;

    private Long points;

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalNum;

}
