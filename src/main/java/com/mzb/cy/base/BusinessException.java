package com.mzb.cy.base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = 1706834787717796585L;
    
    private String errCode;
    private String errDesc;
    
    /**
     * @param errCode
     * @param errDesc
     */
    public BusinessException(String errCode, String errDesc) {
        super();
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public BusinessException(BasicRespCode basicRespCode) {
        super();
        this.errCode = basicRespCode.getRespCode();
        this.errDesc = basicRespCode.getRespDesc();
    }

    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrDesc() {
        return errDesc;
    }
    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
