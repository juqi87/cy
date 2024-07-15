package com.mzb.cy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SequenceMapper {

    @Select("select nextval('#{seqName}')")
    Integer getNextSeqId(@Param("seqName") String seqName);

}
