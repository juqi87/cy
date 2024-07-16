package com.mzb.cy.base;

public class BaseController<T> {


    public BaseResponse<T> successResp(T data) {
        return new BaseResponse<T>().setCode(BasicRespCode.SUCCESS.getRespCode())
                                    .setMsg(BasicRespCode.SUCCESS.getRespDesc())
                                    .setData(data);
    }

    public BaseResponse<T> failResp(BusinessException be) {
        return new BaseResponse<T>().setCode(be.getErrCode())
                                    .setMsg(be.getErrDesc());
    }

    public BaseResponse<T> failResp() {
        return new BaseResponse<T>().setCode(BasicRespCode.FAILED.getRespCode())
                                    .setMsg(BasicRespCode.FAILED.getRespDesc());
    }

}
