package com.zxjz.enums;

public enum CheckBillEnum {

    FIND_BILL_SUCCESS(1),//查询商户账单成功
    FIND_BILL_FAIL(-1),//查询商户账单失败
    FIND_MERCHANTS_NAME_SUCCESS(1),//查询商户名称成功
    FIND_MERCHANTS_NAME_FAIL(-2),//查询商户名称失败
    FIND_MERCHANTS_DETAIL_SUCCESS(1),//查询商户往来账目详情成功
    FIND_MERCHANTS_DETAIL_FAIL(-3),//查询商户往来账目详情失败
    FIND_MERCHANTS_PAY_SUCCESS(1),//查询商户充值详情成功
    FIND_MERCHANTS_PAY_FAIL(-4),//查询商户充值详情失败
    FIND_MERCHANTS_WITHDRAW_SUCCESS(1),//查询商户提现详情成功"
    FIND_MERCHANTS_WITHDRAW_FAIL(-5),//查询商户提现详情失败"
    FIND_FAIL(-6),//查询失败"
    FIND_MERCHANTS_COST_SUCCESS(1),//查询收费单详情成功"
    FIND_PAYMENT_INFO_SUCCESS(1);//查询平台代付工资详情成功"



    private int code;

    CheckBillEnum(int code) {
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
        return "CheckBillEnum{" +
                "code=" + code +
                '}';
    }
}
