package com.zxjz.enums;

public enum StuWalletEnum {
    SUCCESS(1000),//查询成功
    FAIL(-1000),//查询失败
    ID_NOT_EXIT(-1111),//ID不存在
    INNER_ERROR(-9999);//内部错误
    private  int code;


    StuWalletEnum(int code) {
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
