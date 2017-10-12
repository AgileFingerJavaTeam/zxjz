package com.zxjz.dao;

import com.zxjz.entity.MerchantsBillsInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CheckBillDao {
    /**
     * 查询账单信息
     * @param user_id
     * @return
     */
   public List<MerchantsBillsInfo> findBillsInfo (@Param("user_id") int user_id);

    /**
     * 获取商户账单条数
     * @param q
     * @return
     */
   public int findMerBillsCount (@Param("q")String q);

    /**
     * 查询搜索时商户名称
     * @param q
     * @param offset
     * @param rows
     * @return
     */
   public  List<MerchantsBillsInfo> findMerchantName(@Param("q")String q,@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 查询搜索时商户数量
     * @param q
     * @return
     */
   public int findMerCount(@Param("q")String q);
}
