package com.mzb.cy.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class DataTableResponse<T> {

    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;

    private List<T> data;

    private String error;

}
