package com.zxjz.dao;

import com.zxjz.entity.BoundPhoneInfo;
import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.entity.UserCountInfo;
import org.apache.ibatis.annotations.Param;

public interface UserCountInfoDao {
    /**
     * 密码登陆
     * @param phone
     * @param password
     * @return
     */
    public UserCountInfo getUserCountInfo(@Param("phone") String phone,
                                          @Param("password") String password);

    /**
     * 微信登陆
     * @param wechat_id
     * @return
     */
    public UserCountInfo getUserByWechatID(@Param("wechat_id") String wechat_id);

    /**
     * 微信注册
     * @param wechat_id
     * @param headimgurl
     * @return
     */
    public boolean insertUserCountByWechat(@Param("wechat_id") String wechat_id,
                                        @Param("headimgurl") String headimgurl);

    /**
     * QQ登陆
     * @param qq_id
     * @return
     */
    public UserCountInfo findUserByQQID(@Param("qq_id") String qq_id);

    /**
     * QQ注册
     * @param qq_id
     * @param headimgurl
     * @return
     */
    public boolean insertUserCountByQQ(@Param("wechat_id") String qq_id,
                                           @Param("headimgurl") String headimgurl);

    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    public String findVerifyCode(@Param("phone") String phone);

    /**
     * 更新验证码
     * @param phone
     * @return
     */
    public int updateVerifyCode(@Param("phone") String phone);

    /**
     * 插入验证码
     * @param phone
     * @param verify_code
     * @return
     */
    public int insertVerifyCode(@Param("phone") String phone,
                                @Param("verify_code") String verify_code);

    /**
     * 验证码登陆
     * @param phone
     * @return
     */
    public UserCountInfo findUserByPhone(@Param("phone") String phone);

    /**
     * 注册 验证验证码↑
     */

    /**
     * 注册
     * @param phone
     * @param password
     * @return
     */
    public boolean insertUserCount(@Param("phone") String phone,
                                    @Param("password") String password);

    /**
     * 找回密码
     * @param newPwd
     * @param phone
     * @return
     */
    public int updataPwdByPhone(@Param("newPwd") String newPwd,
                                @Param("phone") String phone);

    /**
     * 设置密码
     * @param user_id
     * @return
     */
    public UserCountInfo findUserById(@Param("user_id") int user_id);

    /**
     * 用户ID修改密码
     * @param newPwd
     * @param user_id
     * @return
     */
    public int updatePwdById(@Param("newPwd") String newPwd,
                             @Param("user_id") int user_id);

    /**
     * 保存个人基本信息
     * @param name
     * @param phone
     * @param head_pic
     * @param sex
     * @param birthday
     * @param email
     * @param school
     * @param enrollment_year
     * @param college
     * @param system
     * @param sch_class
     * @param major
     * @param qqNum
     * @param weixinNum
     * @param stu_number
     * @param height
     * @param weight
     * @param blood
     * @param constellation
     * @param selfdescription
     * @return
     */
    public boolean updateById(@Param("user_id") int user_id,
                              @Param("name") String name,
                              @Param("phone") String phone,
                              @Param("head_pic") String head_pic,
                              @Param("sex") String sex,
                              @Param("birthday") String birthday,
                              @Param("email") String email,
                              @Param("school") String school,
                              @Param("enrollment_year") String enrollment_year,
                              @Param("college") String college,
                              @Param("system") String system,
                              @Param("sch_class") String sch_class,
                              @Param("major") String major,
                              @Param("qqNum") String qqNum,
                              @Param("weixinNum") String weixinNum,
                              @Param("stu_number") String stu_number,
                              @Param("height") String height,
                              @Param("weight") String weight,
                              @Param("blood") String blood,
                              @Param("constellation") String constellation,
                              @Param("selfdescription") String selfdescription);

}
