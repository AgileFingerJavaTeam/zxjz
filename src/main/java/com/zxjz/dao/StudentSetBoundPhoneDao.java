package com.zxjz.dao;

import com.zxjz.entity.UserCountInfo;
import org.apache.ibatis.annotations.Param;

public interface StudentSetBoundPhoneDao {
    /**
     * 第一次绑定手机号
     * @param user_id
     * @param phone_password
     * @param phone
     * @return
     */
    public int AddBoundPhoneById(@Param("user_id") int user_id, @Param("phone_password") String phone_password, @Param("phone") String phone, @Param("verify_code") String verify_code, @Param("code") int code);

    /**
     * 修改手机号时验证旧手机号
     * @param user_id
     * @return
     */
    public UserCountInfo findOldPhoneAndPasswordById(@Param("user_id") int user_id);

    /**
     * 修改绑定手机号
     * @return
     */
    public int recomposeBoundPhone(@Param("user_id") int user_id, @Param("phone") String phone);

    /**
     * 修改手机号时查询输入的手机号是否已被绑定
     * @param phone
     * @return
     */
    public UserCountInfo findUserByPhone(@Param("phone") String phone);

    /**
     * 校验验证码
     * @param phone
     * @return
     */
    public String findVerifyCode(@Param("phone") String phone);
}
