package com.zxjz.enums;

import com.zxjz.entity.CheckStudentsInfo;

import java.util.List;

public enum CheckStudentsEnum {
    CHECK_SUCCESS(1,"审核成功"),
    CHECK_FAIL(-1,"审核失败"),
    FIND_STUDENTS_LIST_SUCCESS(1,"查询学生审核列表成功"),
    FIND_STUDENTS_LIST_FAIL(-2,"查询学生审核列表失败");

    private int code;

    private String codeInfo;

    CheckStudentsEnum(int code, String codeInfo) {
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
        return "CheckStudentsEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
