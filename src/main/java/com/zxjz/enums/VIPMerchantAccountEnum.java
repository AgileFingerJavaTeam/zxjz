package com.zxjz.enums;

public enum VIPMerchantAccountEnum {
    FIND_SUCCESS(1),//查询成功
    FIND_ERROR(-1),//查询错误
    RETURN_SUCCESS(2),//保存成功
    RETURN_FAIL(-2);//保存失败
    private  int code;


    VIPMerchantAccountEnum(int code) {
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
