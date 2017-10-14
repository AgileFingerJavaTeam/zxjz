package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.WalletIncomeEnum;
import com.zxjz.enums.WalletWithdrawEnum;

import java.util.ArrayList;

public class StuWalletWithdrawExcution extends BaseAPIExcution{


    public StuWalletWithdrawExcution(WalletWithdrawEnum walletWithdrawEnum) {
       this.code =walletWithdrawEnum.getCode();

    }

    public StuWalletWithdrawExcution(WalletWithdrawEnum walletWithdrawEnum ,Object data) {
        this.code =walletWithdrawEnum.getCode();
        this.data=data;
    }


}
