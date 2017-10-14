package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.MerchantAccountExcution;
import com.zxjz.dto.excution.MerchantApprovalStatusExcution;
import com.zxjz.dto.excution.UpdatePwdByPhoneExcution;
import com.zxjz.dto.in.*;
import com.zxjz.service.MerchantAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/merchantCountInfo")
public class MerchantAccountController extends BaseController{
    @Autowired
    private MerchantAccountService merchantAccountService;

    /**
     * 密码登陆
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "loginPwd",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> getBills(MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findMerchantAccount = merchantAccountService.findMerchantAccountinfo(merchantAccountDto);
            return new BaseResult<MerchantAccountExcution>(1,findMerchantAccount);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 验证码登录
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "loginVerifyCode",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> loginVerifyCode(MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByPhone = merchantAccountService.findUserByPhone(merchantAccountDto);
            return new BaseResult<MerchantAccountExcution>(1,findUserByPhone);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 微信登陆
     * @param userByWechatIDDto
     * @return
     */
    @RequestMapping(value = "loginWechat",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> loginWechat(UserByWechatIDDto userByWechatIDDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByWechatID = merchantAccountService.findUserByWechatID(userByWechatIDDto);
            return new BaseResult<MerchantAccountExcution>(1,findUserByWechatID);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * QQ登陆
     * @param userByQQIDDto
     * @return
     */
    @RequestMapping(value = "loginQQ",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> loginQQ(UserByQQIDDto userByQQIDDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByQQID = merchantAccountService.findUserByQQID(userByQQIDDto);
            return new BaseResult<MerchantAccountExcution>(1,findUserByQQID);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 注册
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "register",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> register(MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findRegistration = merchantAccountService.findRegistration(merchantAccountDto);
            return new BaseResult<MerchantAccountExcution>(1,findRegistration);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 找回密码
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "backPwd",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UpdatePwdByPhoneExcution> backPwd(MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            UpdatePwdByPhoneExcution updatePwdByPhone = merchantAccountService.updatePwdByPhone(merchantAccountDto);
            return new BaseResult<UpdatePwdByPhoneExcution>(1,updatePwdByPhone);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdatePwdByPhoneExcution>(0,e.getMessage());
        }
    }

    /**
     * 设置密码
     * @param userByIdDto
     * @return
     */
    @RequestMapping(value = "setPwd",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> setPwd(UserByIdDto userByIdDto){
        //参数验空
        try {
            MerchantAccountExcution findUserById = merchantAccountService.findUserById(userByIdDto);
            return new BaseResult<MerchantAccountExcution>(1,findUserById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 根据ID查询商家信息
     * @param userByIdDto
     * @return
     */
    @RequestMapping(value = "findInfoById",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> findInfoById(UserByIdDto userByIdDto){
        //参数验空
        try {
            MerchantAccountExcution getUserById = merchantAccountService.getUserById(userByIdDto);
            return new BaseResult<MerchantAccountExcution>(1,getUserById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }

    /**
     * 查询商家审核状态
     * @param merchantApprovalStatusDto
     * @return
     */
    @RequestMapping(value = "checkApprovalStatus",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantApprovalStatusExcution> checkApprovalStatus(MerchantApprovalStatusDto merchantApprovalStatusDto){
        //参数验空
        try {
            MerchantApprovalStatusExcution findApprovalStatusById = merchantAccountService.findApprovalStatusById(merchantApprovalStatusDto);
            return new BaseResult<MerchantApprovalStatusExcution>(1,findApprovalStatusById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantApprovalStatusExcution>(0,e.getMessage());
        }
    }

    /**
     * 提交审核
     * @param approvalStatusByIdDto
     * @return
     */
    @RequestMapping(value = "submitApproval",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantAccountExcution> checkApprovalStatus(ApprovalStatusByIdDto approvalStatusByIdDto){
        //参数验空
        try {
            MerchantAccountExcution findApprovalStatusById = merchantAccountService.findApprovalStatusById(approvalStatusByIdDto);
            return new BaseResult<MerchantAccountExcution>(1,findApprovalStatusById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantAccountExcution>(0,e.getMessage());
        }
    }
}
