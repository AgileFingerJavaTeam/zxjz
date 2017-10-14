package com.zxjz.enums;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public enum HomepageGuaranteeEnum {
    FIND_ENROLLJOBSTATUS_SUCCESS(1),//查询兼职状态成功
    IS_MERCHANT_SEE(2),//商家已经查看
    UPDATE_JOB_STATUS_SUCCESS(3),//更改成功
    SIGNUP_SUCCESS(4),//报名成功
    HIRED_SUCCESS(5),//确认录取成功
    NO_HIRED_SUCCESS(6),//拒绝录取成功
    STUDENT_EDIT_SUCCESS(7),//获取学生兼职详情页成功
    FAIL(10),//失败
    BUG(-555),//到这就BUG了
    NO_PRAM(-99),//缺少参数
    INNER_ERROR(-100);//数据库内部错误

    private int code;

    HomepageGuaranteeEnum(int code) {
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
        return "HomepageGuaranteeEnum{" +
                "code=" + code +
                '}';
    }

    public static HomepageGuaranteeEnum stateof(int index) {
        for (HomepageGuaranteeEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }
}
