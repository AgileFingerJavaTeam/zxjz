package com.zxjz.dao;

import com.zxjz.entity.MerchantsMoneyBasic;
import com.zxjz.entity.Settlement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface SettlementDao {
    /**
     * 显示数据
     * @param rows
     * @param offset
     * @return
     */
    public List<Settlement> findListSettlement(@Param("rows")int rows,@Param("offset")int offset);
    /**
     * 显示总数
     */
    public int findSettlementCount(@Param("search")String search);
    /**
     * 显示总数商户名称表
     */
    public int findSettlementCount2(@Param("search")String search);
    /**
     * 模糊查询
     * @param rows
     * @param offset
     * @param search
     * @return
     */
    public List<Settlement> findSearch(@Param("rows")int rows,@Param("offset") int offset,@Param("search")String search);

    /**
     *查看
     * @param id
     * @param ob
     * @param uid
     * @return
     */
    public Settlement getSettlementData(@Param("id")int id,@Param("ob")int ob,@Param("uid")int uid);

    /**
     * 添加窗口查流水号+1
     * @param id
     * @return
     */
    public Map findMaxNumber(int id);

    /**
     * 插入到平台结算记录表
     * @param user_id
     * @param withdrawal_serial_number
     * @param classification_of_settlement_expenses
     * @param settlement_amount
     * @param instructions
     * @param employees_id
     * @return
     */
    public int insertPlatformBalanceSheet(@Param("user_id")int user_id,@Param("withdrawal_serial_number")int withdrawal_serial_number,@Param("classification_of_settlement_expenses")int classification_of_settlement_expenses,@Param("settlement_amount")double settlement_amount,@Param("instructions")String instructions,@Param("employees_id")int employees_id);

    /**
     * 查找商户资金信息表
     * @param user_id
     * @return
     */
    public Settlement findIsEverUserId(@Param("user_id")int user_id);
    /**
     * 查找商户资金信息表
     * @param user_id
     * @return
     */
    public Settlement findIsEverUserId2(@Param("user_id")int user_id);
    /**
     * 查找商户资金信息表
     * @param user_id
     * @return
     */
    public Settlement findIsEverUserId3(@Param("user_id")int user_id);

    /**
     * 添加方法 流水账表
     * @param user_id
     * @param classification_of_settlement_expenses
     * @param settlement_amount
     * @param user_id
     * @param withdrawal_serial_number
     * @return
     */
    public int insertRunningAccount(@Param("user_id")int user_id,@Param("classification_of_settlement_expenses")int classification_of_settlement_expenses, @Param("settlement_amount")double settlement_amount,@Param("withdrawal_serial_number")int withdrawal_serial_number);

    /**
     * 添加方法 流水账表
     * @param user_id
     * @param current
     * @param classification_of_settlement_expenses
     * @param settlement_amount
     * @param withdrawal_serial_number
     * @return
     */
    public int insertRunningAccount2(@Param("user_id")int user_id,@Param("current")int current,@Param("classification_of_settlement_expenses")int classification_of_settlement_expenses,@Param("settlement_amount")double settlement_amount,@Param("withdrawal_serial_number")int withdrawal_serial_number);

    /**
     * 查商户资金信息表账户余额
     * @param user_id
     * @return
     */
    public MerchantsMoneyBasic findMoneyTable(int user_id);

    /**
     * 商户资金余额大于收费金额的时候
     * @param user_id
     * @param balanced
     * @return
     */
    public int updateMoney(@Param("user_id")int user_id,@Param("balanced")double balanced);

    /**
     * 商户资金余额没有收费金额大的时候
     * @param user_id
     * @param creditd
     * @return
     */
    public int updateMoney2(@Param("user_id")int user_id,@Param("creditd")double creditd);

    /**
     * 查欠款记录需要的值
     * @param user_id
     * @return
     */
    public Settlement findSerial(int user_id);

    /**
     * 添加欠款记录
     * @param user_id
     * @param settlement_time
     * @param withdrawal_serial_number
     * @param setll
     * @param Arrears
     * @return
     */
    public int saveDebt(@Param("user_id")int user_id,@Param("settlement_time")String settlement_time,@Param("withdrawal_serial_number")int withdrawal_serial_number,@Param("setll")double setll,@Param("Arrears")double Arrears);

    /**
     * 添加欠款记录
     * @param user_id
     * @param settlement_time
     * @param withdrawal_serial_number
     * @param setll
     * @param balance
     * @param Arrears
     * @return
     */
    public int saveDebt2(@Param("user_id")int user_id,@Param("settlement_time")String settlement_time,@Param("withdrawal_serial_number")int withdrawal_serial_number,@Param("setll")double setll,@Param("balance")double balance,@Param("Arrears")double Arrears);

    /**
     * 添加欠款记录
     * @param user_id
     * @param ser
     * @param settlement_time
     * @param withdrawal_serial_number
     * @param setll
     * @param Arrears
     * @return
     */
    public int saveDebt3(@Param("user_id")int user_id,@Param("ser")int ser,@Param("settlement_time")String settlement_time,@Param("withdrawal_serial_number")int withdrawal_serial_number,@Param("setll")double setll,@Param("Arrears")double Arrears);

    /**
     * 添加欠款记录
     * @param user_id
     * @param ser
     * @param settlement_time
     * @param withdrawal_serial_number
     * @param setll
     * @param balance
     * @param Arrears
     * @return
     */
    public int saveDebt4(@Param("user_id")int user_id,@Param("ser")int ser,@Param("settlement_time")String settlement_time,@Param("withdrawal_serial_number")int withdrawal_serial_number,@Param("setll")double setll,@Param("balance")double balance,@Param("Arrears")double Arrears);

    /**
     * 查询商户名称
     * @param rows
     * @param offset
     * @param q
     * @return
     */
    public List<Settlement> findMerchantsName (@Param("rows")int rows,@Param("offset") int offset,@Param("q")String q);
}
