package com.zxjz.controller;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.MerchantAccountExcution;
import com.zxjz.dto.excution.MerchantApprovalStatusExcution;
import com.zxjz.dto.excution.UpdatePwdByPhoneExcution;
import com.zxjz.dto.in.*;
import com.zxjz.enums.RegistrationEnum;
import com.zxjz.enums.UpdatePauseEnum;
import com.zxjz.service.MerchantAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getBills(@RequestBody MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findMerchantAccount = merchantAccountService.findMerchantAccountinfo(merchantAccountDto);
            return new BaseAPIResult(1,findMerchantAccount);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution findMerchantAccount = new MerchantAccountExcution(RegistrationEnum.FIND_ERROR,e.getMessage());
            return new BaseAPIResult(0,findMerchantAccount);
        }
    }

    /**
     * 验证码登录
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "loginVerifyCode",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult loginVerifyCode(@RequestBody MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByPhone = merchantAccountService.findUserByPhone(merchantAccountDto);
            return new BaseAPIResult(1,findUserByPhone);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution findUserByPhone = new MerchantAccountExcution(RegistrationEnum.FIND_ERROR,e.getMessage());
            return new BaseAPIResult(0,findUserByPhone);
        }
    }

    /**
     * 微信登陆
     * @param userByWechatIDDto
     * @return
     */
    @RequestMapping(value = "loginWechat",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult loginWechat(@RequestBody UserByWechatIDDto userByWechatIDDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByWechatID = merchantAccountService.findUserByWechatID(userByWechatIDDto);
            return new BaseAPIResult(1,findUserByWechatID);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution findUserByWechatID = new MerchantAccountExcution(RegistrationEnum.FIND_ERROR,e.getMessage());
            return new BaseAPIResult(0,findUserByWechatID);
        }
    }

    /**
     * QQ登陆
     * @param userByQQIDDto
     * @return
     */
    @RequestMapping(value = "loginQQ",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult loginQQ(@RequestBody UserByQQIDDto userByQQIDDto){
        //参数验空
        try {
            MerchantAccountExcution findUserByQQID = merchantAccountService.findUserByQQID(userByQQIDDto);
            return new BaseAPIResult(1,findUserByQQID);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution merchantAccountExcution = new MerchantAccountExcution(RegistrationEnum.FIND_ERROR,e.getMessage());
            return new BaseAPIResult(0,merchantAccountExcution);
        }
    }

    /**
     * 注册
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "register",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult register(@RequestBody MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            MerchantAccountExcution findRegistration = merchantAccountService.findRegistration(merchantAccountDto);
            return new BaseAPIResult(1,findRegistration);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution merchantAccountExcution = new MerchantAccountExcution(RegistrationEnum.REGISTER_FAIL,e.getMessage());
            return new BaseAPIResult(0,merchantAccountExcution);
        }
    }

    /**
     * 找回密码
     * @param merchantAccountDto
     * @return
     */
    @RequestMapping(value = "backPwd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult backPwd(@RequestBody MerchantAccountDto merchantAccountDto){
        //参数验空
        try {
            UpdatePwdByPhoneExcution updatePwdByPhone = merchantAccountService.updatePwdByPhone(merchantAccountDto);
            return new BaseAPIResult(1,updatePwdByPhone);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            UpdatePwdByPhoneExcution updatePwdByPhoneExcution = new UpdatePwdByPhoneExcution(e.getMessage(),RegistrationEnum.MODIFICATION_ERROR);
            return new BaseAPIResult(0,updatePwdByPhoneExcution);
        }
    }

    /**
     * 设置密码
     * @param userByIdDto
     * @return
     */
    @RequestMapping(value = "setPwd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult setPwd(@RequestBody UserByIdDto userByIdDto){
        //参数验空
        try {
            MerchantAccountExcution findUserById = merchantAccountService.findUserById(userByIdDto);
            return new BaseAPIResult(1,findUserById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution merchantAccountExcution = new MerchantAccountExcution(RegistrationEnum.MODIFICATION_ERROR,e.getMessage());
            return new BaseAPIResult(0,merchantAccountExcution);
        }
    }

    /**
     * 根据ID查询商家信息
     * @param userByIdDto
     * @return
     */
    @RequestMapping(value = "findInfoById",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findInfoById(@RequestBody UserByIdDto userByIdDto){
        //参数验空
        try {
            MerchantAccountExcution getUserById = merchantAccountService.getUserById(userByIdDto);
            return new BaseAPIResult(1,getUserById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution merchantAccountExcution = new MerchantAccountExcution(RegistrationEnum.MODIFICATION_ERROR,e.getMessage());
            return new BaseAPIResult(0,merchantAccountExcution);
        }
    }

    /**
     * 查询商家审核状态
     * @param merchantApprovalStatusDto
     * @return
     */
    @RequestMapping(value = "checkApprovalStatus",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult checkApprovalStatus(@RequestBody MerchantApprovalStatusDto merchantApprovalStatusDto){
        //参数验空
        try {
            MerchantApprovalStatusExcution findApprovalStatusById = merchantAccountService.findApprovalStatusById(merchantApprovalStatusDto);
            return new BaseAPIResult(1,findApprovalStatusById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantApprovalStatusExcution merchantApprovalStatusExcution = new MerchantApprovalStatusExcution(RegistrationEnum.MODIFICATION_ERROR,e.getMessage());
            return new BaseAPIResult(0,merchantApprovalStatusExcution);
        }
    }

    /**
     * 提交审核
     * @param approvalStatusByIdDto
     * @return
     */
    @RequestMapping(value = "submitApproval",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult checkApprovalStatus(@RequestBody ApprovalStatusByIdDto approvalStatusByIdDto){
        //参数验空
        try {
            MerchantAccountExcution findApprovalStatusById = merchantAccountService.findApprovalStatusById(approvalStatusByIdDto);
            return new BaseAPIResult(1,findApprovalStatusById);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantAccountExcution merchantAccountExcution = new MerchantAccountExcution(RegistrationEnum.MODIFICATION_ERROR,e.getMessage());
            return new BaseAPIResult(0,merchantAccountExcution);
        }
    }
}
