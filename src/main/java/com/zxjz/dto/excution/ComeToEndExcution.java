package com.zxjz.dto.excution;

import com.zxjz.enums.UpdatePauseEnum;

public class ComeToEndExcution {
    private int updateComeToEnd;
    private int code;
    private String codeInfo;

    public ComeToEndExcution(int updateComeToEnd, UpdatePauseEnum updatePauseEnum) {
        this.updateComeToEnd = updateComeToEnd;
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public ComeToEndExcution(UpdatePauseEnum updatePauseEnum) {
        this.code = updatePauseEnum.getCode();
        this.codeInfo = updatePauseEnum.getCodeInfo();
    }

    public int getUpdateComeToEnd() {
        return updateComeToEnd;
    }

    public void setUpdateComeToEnd(int updateComeToEnd) {
        this.updateComeToEnd = updateComeToEnd;
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
        return "ComeToEndExcution{" +
                "updateComeToEnd=" + updateComeToEnd +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
