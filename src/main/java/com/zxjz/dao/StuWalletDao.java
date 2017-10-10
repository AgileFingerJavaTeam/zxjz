package com.zxjz.dao;

import com.zxjz.entity.StuWallletBase;
import com.zxjz.entity.WalletIncomeInfo;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;

import java.util.List;

public interface StuWalletDao {

//查询钱包余额
    public StuWallletBase findBalance(int userid);
//查询钱包流水
    public List<WalletIncomeInfo> findListIncome(@Param("userid") int userid, @Param("start") String start, @Param("end") String end);

    public WalletIncomeInfo findPriceTypeIncome(@Param("userid") int userid, @Param("accountnember") int accountnember);

    public  WalletIncomeInfo findOtherTypeIncome(@Param("userid") int userid, @Param("accountnember") int accountnember);
//申请提现
    public List<WalletIncomeInfo> findRunningId(int userid);
    public int addApplyWithdraw(@Param("userid") int userid, @Param("money") double money);
    public List<WalletIncomeInfo> findId(int userid);
    public int addWithdraw(@Param("userid") int userid, @Param("money") double money);
    public int updateWalletBalance(@Param("userid") int userid, @Param("money") double money);
    public int addApplyWithdrawFirst(@Param("userid") int userid, @Param("money") double money);
    public int addWithdrawFirst(@Param("userid") int userid, @Param("money") double money);


}
