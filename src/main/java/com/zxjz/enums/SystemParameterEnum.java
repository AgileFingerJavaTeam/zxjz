package com.zxjz.enums;

public enum SystemParameterEnum {
    QUERY_SUCCESS(1,"查询成功"),
    ADD_SUCCESS(1,"新增系统参数成功"),
    EDIT_SUCCESS(1,"编辑系统参数成功"),
    DEL_SUCCESS(1,"删除系统参数成功"),
    DEL_FAIL(-4,"删除系统参数失败"),
    EDIT_FAIL(-3,"编辑系统参数失败"),
    ADD_FAIL(-2,"新增系统参数失败"),
    QUERY_FAIL(-1,"找不到要查询的参数");
    private int code;
    private String codeInfo;

    SystemParameterEnum(int code, String codeInfo) {
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
        return "SystemParameterEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
