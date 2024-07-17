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

    private Integer draw;//
    private Integer start;//pageNum  页码 从0开始
    private Integer length;//pageSize 分页大小

}
