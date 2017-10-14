package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public enum RecruitmentEnum {
    SUCCESS(7),//成功
    FAIL(-7),//失败
    COLLECTION_SUCCESS(1),//查询成功
    ADD_PSW_SUCCESS(2),//添加成功
    UPDATE_PSW_SUCCESS(3),//更改成功
    ADD_JOB_SUCCESS(4),//发布只为成功
    SAVE_JOB_COPY_SUCCESS(5),//保存草稿成功
    UPDATE_SUCCESS(6),//更改状态成功
    COLLECTION_NOT_STATE(-1),//查询失败
    ADD_PSW_FAIL(-2),//添加失败
    UPDATE_PSW_FAIL(-3),//更改失败
    ADD_JOB_FAIL(-4),//发布职位失败
    UPDATE_FAIL(-6),//更改状态失败
    SAVE_JOB_COPY_FAIL(-5),//保存草稿失败
    NO_PRAM(-99),//缺少参数
    INNER_ERROR(-100);//数据库内部错误

        private int code;


    RecruitmentEnum(int code) {
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
}
