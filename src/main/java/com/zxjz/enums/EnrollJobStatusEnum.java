package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public enum  EnrollJobStatusEnum {
    FIND_ENROLLJOBSTATUS_SUCCESS(1,"查询兼职状态成功"),
    IS_MERCHANT_SEE(2,"商家已经查看"),
    UPDATE_JOB_STATUS_SUCCESS(3,"兼职状态更改成功"),
    SIGNUP_SUCCESS(4,"报名成功"),
    HIRED_SUCCESS(5,"确认录取成功"),

    NO_HIRED_SUCCESS(6,"拒绝录取成功"),
    STUDENT_EDIT_SUCCESS(7,"获取学生兼职详情页成功"),
    BUG(-555,"到这就BUG了"),
    STUDENT_EDIT_FAIL(-10,"获取学生兼职详情页失败"),
    NO_SIGNUP(-9,"没有报名"),
    HIRED_FAIL(-8,"录取失败"),
    NO_DATA(-7,"参数有误"),
    SIGNUP_FAIL(-6,"报名失败"),
    DATA_NULL(-5,"有参数为空"),
    REPEAT_REGISTRATION(-4,"重复报名"),
    UPDATE_JOB_STATUS_FAIL(-3,"兼职状态更改失败"),
    NO_IS_MERCHANT_SEE(-2,"商家没有查看"),
    FIND_ENROLLJOBSTATUS_FAIL(-1,"查询兼职状态失败"),
    NO_PRAM(-99,"缺少参数"),
    INNER_ERROR(-100,"数据库内部错误");

    private int code;

    private String codeInfo;

    EnrollJobStatusEnum(int code, String codeInfo) {
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
        return "EnrollJobStatusEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }

    public static EnrollJobStatusEnum stateof(int index) {
        for (EnrollJobStatusEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }
}
