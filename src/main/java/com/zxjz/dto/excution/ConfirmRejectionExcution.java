package com.zxjz.dto.excution;

import com.zxjz.entity.BillList;
import com.zxjz.enums.ConfirmRejectionEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class ConfirmRejectionExcution {
    private int code;
    private String codeInfo;

    public ConfirmRejectionExcution(ConfirmRejectionEnum confirmRejectionEnum) {
        this.code = confirmRejectionEnum.getCode();
        this.codeInfo = confirmRejectionEnum.getCodeInfo();
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
        return "ConfirmRejectionExcution{" +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
