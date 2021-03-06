package com.zxjz.enums;





public enum CheckStudentsEnum {
    CHECK_SUCCESS(1),//审核成功
    CHECK_FAIL(-1),//审核失败
    FIND_STUDENT_SUCCESS(1),//查询当前审核学生信息成功
    FIND_STUDENT_FAIL(-3),//查询当前审核学生信息失败
    FIND_STUDENTS_LIST_SUCCESS(1),//查询学生审核列表成功
    FIND_STUDENTS_LIST_FAIL(-2);//查询学生审核列表失败

    private int code;


    CheckStudentsEnum(int code) {
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
        return "CheckStudentsEnum{" +
                "code=" + code +
                '}';
    }
}
