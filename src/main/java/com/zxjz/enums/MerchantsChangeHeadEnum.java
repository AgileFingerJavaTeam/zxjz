package com.zxjz.enums;

public enum MerchantsChangeHeadEnum {
    CHANGE_SUCCESS(1),//变更成功
    CHANGE_FAIL(-1);//变更失败


    private int code;

    MerchantsChangeHeadEnum(int code) {
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
        return "MerchantsChangeHeadEnum{" +
                "code=" + code +
                '}';
    }
}
