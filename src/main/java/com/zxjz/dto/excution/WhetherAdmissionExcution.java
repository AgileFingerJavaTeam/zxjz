package com.zxjz.dto.excution;

import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class WhetherAdmissionExcution {

    private int code;
    private String codeInfo;

    public WhetherAdmissionExcution(EnrollJobStatusEnum enrollJobStatusEnum) {
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
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
        return "WhetherAdmissionExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
