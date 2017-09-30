package com.zxjz.dto.excution;

import com.zxjz.entity.EnrollJobStatus;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class EnrollJobStatusExcution {
    private EnrollJobStatus enrollJobStatus;
    private int code;
    private String codeInfo;

    public EnrollJobStatusExcution(EnrollJobStatusEnum enrollJobStatusEnum) {
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
    }

    public EnrollJobStatusExcution(EnrollJobStatusEnum enrollJobStatusEnum,EnrollJobStatus enrollJobStatus) {
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
        this.enrollJobStatus = enrollJobStatus;
    }

    public EnrollJobStatus getEnrollJobStatus() {
        return enrollJobStatus;
    }

    public void setEnrollJobStatus(EnrollJobStatus enrollJobStatus) {
        this.enrollJobStatus = enrollJobStatus;
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
        return "EnrollJobStatusExcution{" +
                "enrollJobStatus=" + enrollJobStatus +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
