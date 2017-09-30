package com.zxjz.dto.excution;

import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class UpdateJobStatusExcution {
    private String isBusinessSee;
    private int code;
    private String codeInfo;

    public UpdateJobStatusExcution(EnrollJobStatusEnum enrollJobStatusEnum,String isBusinessSee) {
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
        this.isBusinessSee = isBusinessSee;
    }



    public String getIsBusinessSee() {
        return isBusinessSee;
    }

    public void setIsBusinessSee(String isBusinessSee) {
        this.isBusinessSee = isBusinessSee;
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
        return "UpdateJobStatusExcution{" +
                "isBusinessSee='" + isBusinessSee + '\'' +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
