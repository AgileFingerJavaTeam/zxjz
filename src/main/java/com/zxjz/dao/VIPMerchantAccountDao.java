package com.zxjz.dao;

import com.zxjz.entity.FindMerchantName;
import com.zxjz.entity.VIPMerchantAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VIPMerchantAccountDao {
    /**
     * 显示明星雇主账号信息
     * @param hzn_vipMersearch_content
     * @param sort
     * @param order
     * @param offset
     * @param rows
     * @return
     */
    public List<VIPMerchantAccount> findVIPMerchantList(@Param("hzn_vipMersearch_content") String hzn_vipMersearch_content,
                                                               @Param("sort") String sort,
                                                               @Param("order") String order,
                                                               @Param("offset") int offset,
                                                               @Param("rows") int rows);

    /**
     * 获取企业账号信息数量
     * @param hzn_vipMersearch_content
     * @return
     */
    public int total(@Param("hzn_vipMersearch_content") String hzn_vipMersearch_content);

    /**
     * 添加VIP商家账号
     * @param user_id
     * @return
     */
    public int addVIPMerchantAccount(@Param("user_id") int user_id,
                                      @Param("vip_start") String vip_start,
                                      @Param("vip_end") String vip_end);

    /**
     * 模糊搜索商家名称
     * @return
     */
    public List<FindMerchantName> findMerchantName();

    /**
     * 显示编辑VIP商家账号
     * @param id
     * @return
     */
    public VIPMerchantAccount findVIPMerchantObject(@Param("id") int id);

    /**
     * 编辑VIP商家账号
     * @param user_id
     * @return
     */
    public int editVIPMerchant(@Param("user_id") int user_id,
                                @Param("vip_start") String vip_start,
                                @Param("vip_end") String vip_end);

    /**
     * 删除VIP商业账号
     * @param user_id
     * @return
     */
    public int deleteVIPMerchant(@Param("user_id") int user_id);
}
