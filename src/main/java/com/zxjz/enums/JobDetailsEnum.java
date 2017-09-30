package com.zxjz.enums;

public enum JobDetailsEnum {
    QUERY_JOBDETAILS_SUCCESS(1,"查询职位详情成功"),
    QUERY_STATUS_FAIL(-1,"查询职位状态失败"),
    QUERY_PASSEDJOB_FAIL(-2,"查询已通过审核职位失败"),
    QUERY_OTHERJOB_FAIL(-3,"查询其他状态职位失败"),
    UNKNOW_ERROR(-4,"未知错误");
    private int code;
    private String codeInfo;

    JobDetailsEnum(int code, String codeInfo) {
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
        return "JobDetailsEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
