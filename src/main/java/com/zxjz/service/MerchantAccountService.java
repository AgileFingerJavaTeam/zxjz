package com.zxjz.service;

import com.zxjz.dto.excution.MerchantAccountExcution;
import com.zxjz.dto.excution.MerchantApprovalStatusExcution;
import com.zxjz.dto.excution.UpdatePwdByPhoneExcution;
import com.zxjz.dto.in.*;

public interface MerchantAccountService {
    /**
     * 根据手机号密码登陆接口
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findMerchantAccountinfo(MerchantAccountDto merchantAccountDto);

    /**
     * 根据验证码登陆接口
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findUserByPhone(MerchantAccountDto merchantAccountDto);

    /**
     * 根据微信账号登陆接口
     * @param userByWechatIDDto
     * @return
     */
    public MerchantAccountExcution findUserByWechatID(UserByWechatIDDto userByWechatIDDto);

    /**
     * 根据QQ账号登陆接口
     * @param userByQQIDDto
     * @return
     */
    public MerchantAccountExcution findUserByQQID(UserByQQIDDto userByQQIDDto);

    /**
     *  注册
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findRegistration(MerchantAccountDto merchantAccountDto);

    /**
     * 找回密码
     * @param merchantAccountDto
     * @return
     */
    public UpdatePwdByPhoneExcution updatePwdByPhone(MerchantAccountDto merchantAccountDto);

    /**
     * 设置密码
     * @param userByIdDto
     * @return
     */
    public MerchantAccountExcution findUserById(UserByIdDto userByIdDto);

    /**
     * 根据ID查询商家信息
     * @param userByIdDto
     * @return
     */
    public MerchantAccountExcution getUserById(UserByIdDto userByIdDto);

    /**
     * 查询商家审核状态
     * @return
     */
    public MerchantApprovalStatusExcution findApprovalStatusById(MerchantApprovalStatusDto merchantApprovalStatusDto);

    /**
     * 提交审核
     * @param approvalStatusByIdDto
     * @return
     */
    public MerchantAccountExcution findApprovalStatusById(ApprovalStatusByIdDto approvalStatusByIdDto);

}
