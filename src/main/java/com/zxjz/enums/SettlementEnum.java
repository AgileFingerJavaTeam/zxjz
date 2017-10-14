package com.zxjz.enums;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public enum  SettlementEnum {
    SUCCESS(7),//"成功"
    FAIL(-7),//"失败"
    COLLECTION_SUCCESS(1),//"查询成功"
    ADD_PSW_SUCCESS(2),//"添加成功"
    UPDATE_PSW_SUCCESS(3),//"更改成功"
    ADD_JOB_SUCCESS(4),//"发布职位成功"
    SAVE_JOB_COPY_SUCCESS(5),//"保存草稿成功"
    UPDATE_SUCCESS(6),//"更改状态成功"
    NO_PRAM(-99),//"缺少参数"
    INNER_ERROR(-100);//"数据库内部错误"

    private int code;

    SettlementEnum(int code) {
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
        return "SettlementEnum{" +
                "code=" + code +
                '}';
    }

    public static SettlementEnum stateof(int index) {
        for (SettlementEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }

}
