package com.zxjz.dto.excution;

import com.zxjz.entity.StuWallletBase;
import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.WalletIncomeEnum;

import java.util.ArrayList;

public class StuWalletIncomeExcution {
   private WalletIncomeInfo  walletIncomeInfo;
   private ArrayList finalInfoList;
   private int code;
   private String codeInfo;

    public StuWalletIncomeExcution(WalletIncomeEnum walletIncomeEnum) {
       this.code = walletIncomeEnum.getCode();
       this.codeInfo = walletIncomeEnum.getCodeInfo();
    }
    public StuWalletIncomeExcution(WalletIncomeEnum walletIncomeEnum,ArrayList finalInfoList) {
        this.finalInfoList = finalInfoList;
        this.code = walletIncomeEnum.getCode();
        this.codeInfo = walletIncomeEnum.getCodeInfo();
    }

    public WalletIncomeInfo getWalletIncomeInfo() {
        return walletIncomeInfo;
    }

    public void setWalletIncomeInfo(WalletIncomeInfo walletIncomeInfo) {
        this.walletIncomeInfo = walletIncomeInfo;
    }

    public ArrayList getFinalInfoList() {
        return finalInfoList;
    }

    public void setFinalInfoList(ArrayList finalInfoList) {
        this.finalInfoList = finalInfoList;
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
        return "StuWalletIncomeExcution{" +
                "finalInfoList=" + finalInfoList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
