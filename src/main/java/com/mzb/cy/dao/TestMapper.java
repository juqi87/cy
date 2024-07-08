package com.mzb.cy.dao;

import com.mzb.cy.dao.model.TestDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    int insert(TestDO row);

    int insertSelective(TestDO row);

    String getVisitStat();
}