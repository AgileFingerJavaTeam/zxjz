package com.zxjz.dto.excution;

import com.zxjz.enums.UpdatePauseEnum;

public class UpdateRejectExcution {
    private int updateReject;
    private int code;
    private String codeInfo;

    public UpdateRejectExcution(int updateReject, UpdatePauseEnum updatePauseEnum) {
        this.updateReject = updateReject;
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public UpdateRejectExcution(UpdatePauseEnum updatePauseEnum) {
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public int getUpdateReject() {
        return updateReject;
    }

    public void setUpdateReject(int updateReject) {
        this.updateReject = updateReject;
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
        return "UpdateRejectExcution{" +
                "updateReject=" + updateReject +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
