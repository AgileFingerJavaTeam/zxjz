package com.zxjz.enums;

public enum MerchantsChangeHeadEnum {
    CHANGE_SUCCESS(1,"变更成功"),
    CHANGE_FAIL(-1,"变更失败");


    private int code;
    private String codeInfo;

    MerchantsChangeHeadEnum(int code, String codeInfo) {
        this.code = code;
        this.codeInfo = codeInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "MerchantsChangeHeadEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
