package com.zxjz.enums;

public enum MerchantsAffirmStudentBreakPromiseEnum {
    AFFIRM_STUDENT_BREAK_PROMISE_FAIL(-1),//确认员工爽约失败
    FIND_DOUBLEID_FAIL(-2),//查询学生ID和招聘ID失败
    OVER_WORK_FAIL(-3),//结束工作失败
    UPDATE_STUDENT_MISS_NUMBER_FAIL(-4),//更新学生爽约次数失败
    UNKNOW_ERROR(-5),//未知错误
    AFFIRM_SUCCESS(1);//成功

    private int code;

    MerchantsAffirmStudentBreakPromiseEnum(int code) {
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
        return "MerchantsAffirmStudentBreakPromiseEnum{" +
                "code=" + code +
                '}';
    }
}
