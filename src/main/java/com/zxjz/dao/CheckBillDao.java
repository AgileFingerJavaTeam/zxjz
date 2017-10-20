package com.zxjz.dao;

import com.zxjz.entity.*;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CheckBillDao {
    /**
     * 查询账单信息
     * @param merId
     * @return
     */
   public List<MerchantsBillsInfo> findBillsInfo (@Param("merId") int merId);

    /**
     * 获取商户账单条数
     * @param
     * @return
     */
   public int findMerBillsCount (@Param("merId")int merId,@Param("q")String q);

    /**
     * 查询搜索时商户名称
     * @param q
     * @param offset
     * @param rows
     * @return
     */
   public  List<MerchantsBillsInfo> findMerchantName(@Param("q")String q,@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 查询查找时商户数量
     * @param q
     * @return
     */
   public int findMerCount(@Param("q")String q);

    /**
     * 查询商家充值信息
     */
   public RechargeInfo findPayInfoById(@Param("user_id")int user_id,@Param("references_the_internal_serial_number1")int references_the_internal_serial_number1);

    /**
     * 查询商家提现信息
     * @return
     */
   public MerchantWithdrawInfo findWithdrawInfoById(@Param("user_id")int user_id,@Param("references_the_internal_serial_number1")int references_the_internal_serial_number1);

    /**
     * 查询招聘ID
     * @param work_id
     * @return
     */
   public  Object findRecruitIdByUserId(@Param("work_id")int work_id);

    /**
     * 查询工作名称
     */
   public  String findPostNameByRecruitId(@Param("recruiting_id")int recruiting_id);

    /**
     * 查询商家支付工资信息
     * @param work_id
     * @param references_the_internal_serial_number1
     * @return
     */
   public MerchantPayforStudent findSalaryById(@Param("work_id")int work_id,@Param("references_the_internal_serial_number1")int references_the_internal_serial_number1);

    /**
     * 查询商家支付给平台信息
     * @param user_id
     * @param references_the_internal_serial_number1
     * @return
     */
   public MerchantPayforTerrace findCostInfoById(@Param("user_id")int user_id,@Param("references_the_internal_serial_number1")int references_the_internal_serial_number1);

    /**
     * 查询商家代付工资给学生信息
     * @param user_id
     * @param references_the_internal_serial_number1
     * @return
     */
   public  TerracePayforStudent findPaymentInfoById(@Param("user_id")int user_id,@Param("references_the_internal_serial_number1")int references_the_internal_serial_number1);
}
