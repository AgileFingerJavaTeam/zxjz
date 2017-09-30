package com.zxjz.dto.excution;

import com.zxjz.entity.QuickSignUp;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class QuickSignUpExcution {
     private QuickSignUp quickSignUp;
     private int code;
     private String codeInfo;

    public QuickSignUpExcution(EnrollJobStatusEnum enrollJobStatusEnum,QuickSignUp quickSignUp) {
        this.quickSignUp = quickSignUp;
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
    }

    public QuickSignUp getQuickSignUp() {
        return quickSignUp;
    }

    public void setQuickSignUp(QuickSignUp quickSignUp) {
        this.quickSignUp = quickSignUp;
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
        return "QuickSignUpExcution{" +
                "quickSignUp=" + quickSignUp +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
