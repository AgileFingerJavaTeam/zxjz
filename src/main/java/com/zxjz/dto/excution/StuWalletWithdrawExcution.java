package com.zxjz.dto.excution;

import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.WalletIncomeEnum;
import com.zxjz.enums.WalletWithdrawEnum;

import java.util.ArrayList;

public class StuWalletWithdrawExcution {
   private WalletIncomeInfo  walletIncomeInfo;
   private int code;
   private String codeInfo;

    public StuWalletWithdrawExcution(WalletWithdrawEnum walletWithdrawEnum) {
       this.code =walletWithdrawEnum.getCode();
       this.codeInfo =walletWithdrawEnum.getCodeInfo();
    }

    public WalletIncomeInfo getWalletIncomeInfo() {
        return walletIncomeInfo;
    }

    public void setWalletIncomeInfo(WalletIncomeInfo walletIncomeInfo) {
        this.walletIncomeInfo = walletIncomeInfo;
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
        return "StuWalletWithdrawExcution{" +
                "walletIncomeInfo=" + walletIncomeInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
