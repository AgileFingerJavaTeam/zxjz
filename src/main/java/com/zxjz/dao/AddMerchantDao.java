package com.zxjz.dao;

import com.zxjz.entity.AddMerchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMerchantDao {
    /**
     * 查询商户列表
     * @return
     */
    public List<AddMerchant> findMerchantList(@Param("rows")int rows,@Param("offset")int offset,@Param("search_content")String search_content);

    /**
     * 查询商户列表条数
     * @return
     */
    public int findMerchantCount(@Param("search_content")String search_content);
    /**
     * 查询当前选择的商户信息
     * @param merchantId
     * @return
     */
    public AddMerchant findMerchantInfo(@Param("merchantId")int merchantId);

    /**
     * 新增商户
     * @param merchantPhoneNum
     * @return
     */
    public int insertMerchantIntoTableUserCount(@Param("merchantPhoneNum")String merchantPhoneNum);
//    public int findMerchantId(@Param("merchantPhoneNum")String merchantPhoneNum);
//    public int insertMerchantIntoTableMerchantAccount(@Param("merchantId")int merchantId,@Param("merchantPhoneNum")String merchantPhoneNum);

    /**
     * 编辑商户
     * @param merchantId
     * @param merchantPhoneNum
     * @return
     */
    public int editMerchant(@Param("merchantId")int merchantId,@Param("merchantPhoneNum")String merchantPhoneNum);



}
