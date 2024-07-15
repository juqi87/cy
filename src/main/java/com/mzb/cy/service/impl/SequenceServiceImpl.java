package com.mzb.cy.service.impl;

import com.mzb.cy.dao.SequenceMapper;
import com.mzb.cy.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther v-juqi
 * @createDate 2024/7/15 10:22
 **/
@Service
@Slf4j
public class SequenceServiceImpl implements SequenceService {

    public static final char LEFT_PAD_CHAR = '0';

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public String getCyOrdSeqId() {
        int seqId = sequenceMapper.getNextSeqId("CY_ORD_SEQ_ID");
        return StringUtils.leftPad(seqId+"", 10, LEFT_PAD_CHAR);
    }
}
