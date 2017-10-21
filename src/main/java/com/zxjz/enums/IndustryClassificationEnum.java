package com.zxjz.enums;

public enum IndustryClassificationEnum {

    FIND_SUCCESS(1),//成功
    FIND_ERROR(-1),//失败
    RETURN_SUCCESS(2),//保存成功
    RETURN_FAIL(-2),//保存失败
    UPDATE_SUCCESS(3),//修改成功
    UPDATE_FAIL(-3),//修改失败
    DELETE_SUCCESS(4),//删除成功
    DELETE_ERROR(-4);//删除失败




    private int code;

    IndustryClassificationEnum(int code) {
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
        return "IndustryClassificationEnum{" +
                "code=" + code +
                '}';
    }
}
