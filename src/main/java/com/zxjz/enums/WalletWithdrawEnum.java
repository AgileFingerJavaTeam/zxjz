package com.zxjz.enums;

public enum WalletWithdrawEnum {
    SUCCESS(1000,"查询成功"),
    FAIL(-1000,"查询失败"),
    ADDSUCCESS(2000,"插入成功"),
    ADDFAIL(-2000,"插入失败"),
    ID_NOT_EXIT(-1111,"ID不存在"),
    INNER_ERROR(-9999,"内部错误"),;
    private  int code;
    private  String codeInfo;

    WalletWithdrawEnum(int code, String codeInfo) {
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
        return "WalletIncomeEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
