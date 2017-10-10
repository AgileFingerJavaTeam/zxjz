package com.zxjz.dto.excution;

import com.zxjz.entity.StuEvaDetails;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.enums.UpdatePauseEnum;

public class UpdatePauseExcution {
    private int updatePause;
    private int code;
    private String codeInfo;

    public UpdatePauseExcution(int updatePause, UpdatePauseEnum updatePauseEnum) {
        this.updatePause = updatePause;
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public UpdatePauseExcution(UpdatePauseEnum updatePauseEnum) {
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public int getUpdatePause() {
        return updatePause;
    }

    public void setUpdatePause(int updatePause) {
        this.updatePause = updatePause;
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
        return "UpdatePauseExcution{" +
                "updatePause=" + updatePause +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
