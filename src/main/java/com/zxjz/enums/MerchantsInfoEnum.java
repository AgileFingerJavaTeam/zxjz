package com.zxjz.enums;

public enum MerchantsInfoEnum {
    INQUIRE_SUCCESS(1,"查询成功"),
    INQUIRE_ERROR(-1,"查询失败");
    private int code;
    private String codeInfo;

    MerchantsInfoEnum(int code, String codeInfo) {
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
        return "MerchantsInfoEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
