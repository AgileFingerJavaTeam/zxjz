package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public enum MerchantApprovalEnum {
    FIND_SUCCESS(1), //查询成功
    FIND_FAIL   (-1), //查询失败
    ADD_SUCCESS(2),//添加成功
    ADD_FAIL(-2),//添加失败
    UP_SUCCESS(3),//更改成功
    UP_FAIL(-3);//更改失败
    private int code;


    MerchantApprovalEnum(int code) {
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



}