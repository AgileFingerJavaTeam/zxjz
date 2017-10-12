package com.zxjz.dao;

import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.entity.MerchantApprovalStatusInfo;
import org.apache.ibatis.annotations.Param;

public interface MerchantAccountDao {
    /**
     * 手机密码登陆接口
     * @param phone
     * @param password
     * @return
     */
    public MerchantAccountInfo getMerchantAccountInfo(@Param("phone") String phone,
                                                      @Param("password") String password);

    /**
     * 验证码登陆
     * @param phone
     * @return
     */
    public MerchantAccountInfo getUserByPhone(@Param("phone") String phone);

    /**
     * 查询验证码
     * @param phone
     * @return
     */
    public String getVerifyCode(@Param("phone") String phone);

    /**
     * 通过微信ID查询信息
     * @param wechat_id
     * @return
     */
    public MerchantAccountInfo getUserByWechatID(@Param("wechat_id") String wechat_id);

    /**
     * 通过微信ID插入信息
     * @param wechat_id
     * @param headimgurl
     * @return
     */
    public boolean insertUserCountByWechat(@Param("wechat_id") String wechat_id,
                                            @Param("headimgurl") String headimgurl);

    /**
     * 通过QQ登陆
     * @param qq_id
     * @return
     */
    public MerchantAccountInfo getUserByQQID(@Param("qq_id") String qq_id);

    /**
     * 通过QQ账号插入信息
     * @param qq_id
     * @param headimgurl
     * @return
     */
    public boolean insertUserCountByQQ(@Param("qq_id") String qq_id,
                                       @Param("headimgurl") String headimgurl);

    /**
     * 注册接口
     * 查询验证码(↑)
     * @param phone
     * @return
     */
    public MerchantAccountInfo getRegistration(@Param("phone") String phone);

    /**
     * 注册插入信息
     * @param qq_id
     * @param headimgurl
     * @return
     */
    public boolean insertUserCount(@Param("qq_id") String qq_id,
                                       @Param("headimgurl") String headimgurl);

    /**
     * 根据手机号找回密码
     * @param phone
     * @return
     */
    public int updataPwdByPhone(@Param("phone") String phone);

    /**
     * 设置密码
     * @param user_id
     * @return
     */
    public MerchantAccountInfo getUserById(@Param("user_id") int user_id);

    /**
     * 修改密码
     * @return
     */
    public int updatePwdById(@Param("user_id") int user_id);

    /**
     * 查询商家审核状态
     * @return
     */
    public MerchantApprovalStatusInfo getApprovalStatusById(@Param("user_id") int user_id);

    /**
     * 提交审核
     * @param user_id
     * @param logo_url
     * @param company_name
     * @param industry_involved
     * @param company_address
     * @param longitude
     * @param latitude
     * @param head
     * @param job
     * @param phone
     * @param url
     * @return
     */
    public int insertApprovalInfo(@Param("user_id") int user_id,
                                  @Param("logo_url") String logo_url,
                                  @Param("company_name") String company_name,
                                  @Param("industry_involved") String industry_involved,
                                  @Param("company_address") String company_address,
                                  @Param("longitude") String longitude,
                                  @Param("latitude") String latitude,
                                  @Param("head") String head,
                                  @Param("job") String job,
                                  @Param("phone") String phone,
                                  @Param("url") String url);
}
