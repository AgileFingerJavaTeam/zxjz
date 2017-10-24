package com.zxjz.enums;

public enum StudentWithdrawEnum {

    FIND_SUCCESS(1),//查询成功
    FIND_FAIL(-1),//查询失败
    UPDATA_STUDENT_WITHDRAW_SUCCESS(1),//更新学生提现信息状态成功
    UPDATA_STUDENT_WITHDRAW_FAIL(-2);//更新学生提现信息状态失败
    private int code;

    StudentWithdrawEnum(int code) {
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
        return "StudentWithdrawEnum{" +
                "code=" + code +
                '}';
    }
}
