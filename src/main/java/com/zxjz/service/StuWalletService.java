package com.zxjz.service;

import com.zxjz.dto.excution.StuWalletExcution;
import com.zxjz.dto.excution.StuWalletIncomeExcution;
import com.zxjz.dto.excution.StuWalletWithdrawExcution;
import com.zxjz.dto.in.StuWalletDto;
import com.zxjz.dto.in.StuWalletIncomeDto;
import com.zxjz.dto.in.StuWalletWithdrawDto;

public interface StuWalletService {

    /*
    * 查询学生钱包余额
    *
    * */
    public StuWalletExcution walletbalance(StuWalletDto stuWalletDto);

    /*
   * 查询学生钱包流水
   *
   * */
    public StuWalletIncomeExcution income(StuWalletIncomeDto stuWalletIncomeDto);

    /*
   * 申请提现
   *
   * */
    public StuWalletWithdrawExcution withdraw(StuWalletWithdrawDto stuWalletWithdrawDto);

}
