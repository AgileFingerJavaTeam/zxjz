package com.zxjz.enums;

public enum AddMerchantEnum {
    FIND_SUCCESS(1),//查询成功
    FIND_FAIL(-1),//查询失败
    EDIT_SUCCESS(1),//编辑成功
    EDIT_FAIL(-2),//编辑失败
    INERT_SUCCESS(1),//新增成功
    INERT_FAIL(-3),//新增失败
    ;
    private int code;

    AddMerchantEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
