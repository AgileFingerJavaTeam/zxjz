package com.zxjz.dto.excution;

import com.zxjz.base.BaseException;
import com.zxjz.base.BaseExcution;
import com.zxjz.entity.StuWallletBase;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.UserInfoEnum;

public class StuWalletExcution  {
    private StuWallletBase stuWallletBase;
    private int code;
    private String codeInfo;

    public StuWalletExcution( StuWalletEnum stuWalletEnum) {
        this.code=stuWalletEnum.getCode();
        this.codeInfo=stuWalletEnum.getCodeInfo();
    }
    public StuWalletExcution( StuWalletEnum stuWalletEnum,StuWallletBase stuWallletBase) {
        this.code=stuWalletEnum.getCode();
        this.codeInfo=stuWalletEnum.getCodeInfo();
        this.stuWallletBase=stuWallletBase;
    }

    public StuWallletBase getStuWallletBase() {
        return stuWallletBase;
    }

    public void setStuWallletBase(StuWallletBase stuWallletBase) {
        this.stuWallletBase = stuWallletBase;
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
        return "StuWalletExcution{" +
                "stuWallletBase=" + stuWallletBase +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
