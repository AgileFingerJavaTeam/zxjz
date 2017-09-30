package com.zxjz.enums;

public enum MerchantCommentEnum {
    EVALUATE_SUCCESS(1,"发表成功"),
    ADD_EVALUATE_FORETABLE_FAIL(-1,"评价失败");
    private int code;
    private String codeInfo;

    MerchantCommentEnum(int code, String codeInfo) {
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
        return "MerchantCommentEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
