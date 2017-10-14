package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public enum CreditEnum {
    SUCCESS(100),//成功
    FAIL(-100),//失败
    ADD_SUCCESS(200),//新增成功
    ADD_FAIL(-200),//新增失败
    FIND_SUCCESS(300),//查询成功
    FIND_FAIL(-300),//查询失败
    UPDATE_SUCCESS(400),//修改成功
    UPDATE_FAIL(-400);//修改失败

    private int code;

    CreditEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
