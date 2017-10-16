package com.zxjz.dao;

import com.zxjz.entity.MerchantsUpgrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantsUpgadeDao {
    /**
     * 申请VIP商户：通过ID添加一条商户申请信息
     * @param user_id
     * @return
     */
    public int addADataById(@Param("user_id") int user_id);

    public MerchantsUpgrade findUserById(@Param("user_id") int user_id);

    /**
     * 查询申请VIP商户信息
     * @param srt_approval_status1
     * @param srt_search_content1
     * @param offset
     * @param rows
     * @return
     */
    public List<MerchantsUpgrade> findApplyVipList(@Param("srt_approval_status1")String srt_approval_status1, @Param("srt_search_content1")String srt_search_content1, @Param("offset")int offset, @Param("rows")int rows);

    /**
     * 查询申请VIP商户总数
     * @return
     */
    public int findApplyVipCount();

    /**
     * 查询受理员工
     * @param user_id
     * @return
     */
    public String   findAcceptEmployer(@Param("user_id")int user_id);

    /**
     * 查询操作员工
     * @param user_id
     * @return
     */
    public String  findOperatingEmployer(@Param("user_id")int user_id);

    /**
     * 查询申请VIP商户信息
     * @param id
     * @return
     */
    public MerchantsUpgrade findEmInfo (@Param("id")int id);

    /**
     * 确认审核
     * @param employees_name
     * @param id
     * @param user_id
     * @return
     */
    public int conrifmCheck(@Param("employees_name")int employees_name,@Param("id")int id,@Param("user_id")int user_id);

    /**
     * 查询员工列表
     * @return
     */
    public List<MerchantsUpgrade> findEmployerList();
}

