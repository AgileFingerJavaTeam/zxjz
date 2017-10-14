package com.zxjz.enums;

public enum MerchantsInfoEnum {
    INQUIRE_SUCCESS(1),//查询成功
    INQUIRE_ERROR(-1);//查询失败
    private int code;

    MerchantsInfoEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "MerchantsInfoEnum{" +
                "code=" + code +
                '}';
    }
}
