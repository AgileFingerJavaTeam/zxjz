package com.zxjz.dao;

import com.zxjz.entity.CreditAndPayment;
import com.zxjz.entity.CurrentAccountInfo;
import com.zxjz.entity.MerchantFundsReceivableInfo;
import com.zxjz.entity.RechargeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface RechargeDao {
    /*查询充值信息列表*/
    public List<RechargeInfo> findRechargeList(@Param("bxw_search_content")String bxw_search_content,
                                               @Param("sort")String sort,
                                               @Param("order")String order,
                                               @Param("page")int page,
                                               @Param("rows")int rows);
    /*查询充值信息列表数量*/
    public int total(String bxw_search_content);
    /*详情信息页面*/
    public  RechargeInfo findRechargePage(@Param("user_id") int user_id,@Param("recharge_sequence_number") int recharge_sequence_number);
    /*获取商户名称*/
    public List<RechargeInfo> findMerchantsName(@Param("q") String q,@Param("offset") int offset,@Param("rows") int rows);
    /*获取商户数量*/
    public int count(String q);
    /*查询充值方式*/
    public List<RechargeInfo> findRechargeMethod();
    /*获取充值表id*/
    public  RechargeInfo findUserId(int merchants_id);
    /*查询流水号*/
    public int findNum(int merchants_id);
    /*新增流水号*/
    public int updateNum(int merchants_id);
    /*充值记录表插入数据*/
    public  int insertRecharge(@Param("user_id")int user_id,@Param("recharge_sequence_number")int recharge_sequence_number,@Param("recharge_time")String recharge_time,@Param("recharge_mode")int recharge_mode,@Param("amount_of_recharge")double amount_of_recharge,@Param("payment_platform_flow_number")int payment_platform_flow_number,@Param("declare")String declare,@Param("operating_staff_id")int operating_staff_id);
    /*查询流水user_id的集合*/
    public  List<CurrentAccountInfo> findForList(int user_id);
    /*插入流水账记录，序号为1*/
    public  int insertAccount(@Param("user_id")int user_id,@Param("recharge_sequence_number")int recharge_sequence_number);
    /*查询未回收的应收款*/
    public List<MerchantFundsReceivableInfo> findRList(int  user_id);
    /*修改应收款*/
    public  int updateReceivable(@Param("user_id")int user_id,@Param("serial_number")int serial_number);
    /*修改应收款的部分信息*/
    public  int  updateReceivablePart(@Param("user_id")int user_id,@Param("serial_number")int serial_number,@Param("actual_amount")double actual_amount,@Param("amount_of_recharge")double amount_of_recharge);
    /*查询商户资金基本信息*/
    public  CreditAndPayment findCredit(int user_id);
    /*修改账户余额*/
    public  int updateCredit(@Param("user_id")int user_id,@Param("amount_of_recharge")double amount_of_recharge);
    /*修改授信余额等信息*/
    public  int upcreditbalance(@Param("user_id")int user_id,@Param("amount_of_recharge")double amount_of_recharge);
    /*添加到流水账，序号不为1*/
    public  int insertAccounts(@Param("user_id")int user_id,@Param("recharge_sequence_number")int recharge_sequence_number);


}
