package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StuWallletBase;
import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.WalletIncomeEnum;

import java.util.ArrayList;

public class StuWalletIncomeExcution extends BaseAPIExcution{

    public StuWalletIncomeExcution(WalletIncomeEnum walletIncomeEnum) {
       this.code = walletIncomeEnum.getCode();
       ;
    }
    public StuWalletIncomeExcution(WalletIncomeEnum walletIncomeEnum,Object data) {
        this.data = data;
        this.code = walletIncomeEnum.getCode();

    }

}
