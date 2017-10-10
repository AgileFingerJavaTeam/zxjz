package com.zxjz.dto.excution;

import com.zxjz.enums.UpdatePauseEnum;

public class UpdateIsOverExcution {
    private int updateIsOver;
    private int code;
    private String codeInfo;

    public UpdateIsOverExcution(int updateIsOver, UpdatePauseEnum updatePauseEnum) {
        this.updateIsOver = updateIsOver;
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public UpdateIsOverExcution(UpdatePauseEnum updatePauseEnum) {
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public int getUpdateIsOver() {
        return updateIsOver;
    }

    public void setUpdateIsOver(int updateIsOver) {
        this.updateIsOver = updateIsOver;
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
        return "UpdateIsOverExcution{" +
                "updateIsOver=" + updateIsOver +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
