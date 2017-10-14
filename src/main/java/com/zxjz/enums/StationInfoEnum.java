package com.zxjz.enums;

public enum StationInfoEnum {
    FIND_SUCCESS(1),//查询成功
    FIND_PARENT_JOB_FAIL(-7),//查询父类岗位信息失败
    FIND_FAIL(-1),//查询失败
    EDIT_PARENT_JOB_SUCCESS(1),//编辑父类职位成功
    EDIT_PARENT_JOB_FAIL(-2),//编辑父类职位失败
    EDIT_CHILD_JOB_SUCCESS(1),//编辑子类职位成功
    EDIT_CHILD_JOB_FAIL(-3),//编辑子类职位失败
    DELETE_PARENT_JOB_SUCCESS(1),//删除父类职位成功
    DELETE_PARENT_JOB_FAIL(-4),//删除父类职位成功
    DELETE_CHILD_JOB_SUCCESS(1),//删除子类职位成功
    DELETE_CHILD_JOB_FAIL(-5),//删除子类职位成功
    ADD_SUCCESS(1),//新增成功
    ADD_PARENT_JOB_FAIL(-6),//新增父类岗位类型失败
    FIND_CHILD_COUNT_FAIL(-8),//查询子类条数失败
    FIND_CHILD_INFO_SUCCESS(1),//查询子类岗位信息成功
    FIND_CHILD_INFO_FAIL(-9),//查询子类岗位信息失败
    ADD_CHILD_JOB_FAIL(-10);//新增子类岗位信息失败


    private int code;

    StationInfoEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
