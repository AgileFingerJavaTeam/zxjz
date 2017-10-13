package com.zxjz.controller;

import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.CodeExcution;
import com.zxjz.dto.excution.UpdatePwdExcution;
import com.zxjz.dto.excution.UserCountExcution;
import com.zxjz.dto.in.CodeDto;
import com.zxjz.dto.in.UpdateByIdDto;
import com.zxjz.dto.in.UpdatePwdDto;
import com.zxjz.dto.in.UserCountDto;
import com.zxjz.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userCountInfo")
public class UserCountController {
    @Autowired
    private UserCountService userCountService;

    /**
     * 密码登陆
     * @param userCountDto
     * @return
     */
    @RequestMapping(value = "loginPwd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> loginPwd(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByPhoneAndPwd = userCountService.findUserByPhoneAndPwd(userCountDto);
            return new BaseResult<UserCountExcution>(1,findUserByPhoneAndPwd);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 微信登陆
     * @param userCountDto
     * @return
     */
    @RequestMapping(value = "loginWechat",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> loginWechat(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByWechatID = userCountService.findUserByWechatID(userCountDto);
            return new BaseResult<UserCountExcution>(1,findUserByWechatID);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 登陆
     * @param userCountDto
     * @return
     */
    @RequestMapping(value = "loginQQ",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> loginQQ(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByQQID = userCountService.findUserByQQID(userCountDto);
            return new BaseResult<UserCountExcution>(1,findUserByQQID);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 发送验证码
     * @param codeDto
     * @return
     */
    @RequestMapping(value = "sendSMS",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CodeExcution> sendSMS(CodeDto codeDto){
        //参数验空
        try {
            CodeExcution findVerifyCode = userCountService.findVerifyCode(codeDto);
            return new BaseResult<CodeExcution>(1,findVerifyCode);
        } catch (Exception e) {
            return new BaseResult<CodeExcution>(0,e.getMessage());
        }
    }

    /**
     * 验证码登陆
     * @param codeDto
     * @return
     */
    @RequestMapping(value = "loginVerifyCode",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> loginVerifyCode(@RequestBody CodeDto codeDto){
        //参数验空
        try {
            UserCountExcution findUserByPhone = userCountService.findUserByPhone(codeDto);
            return new BaseResult<UserCountExcution>(1,findUserByPhone);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 注册 验证验证码
     * @param codeDto
     * @return
     */
    @RequestMapping(value = "judgeVerifyCode",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> judgeVerifyCode(@RequestBody CodeDto codeDto){
        //参数验空
        try {
            UserCountExcution getUserByPhone = userCountService.getUserByPhone(codeDto);
            return new BaseResult<UserCountExcution>(1,getUserByPhone);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 注册
     * @param userCountDto
     * @return
     */
    @RequestMapping(value = "register",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> register(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution insertUserCount = userCountService.insertUserCount(userCountDto);
            return new BaseResult<UserCountExcution>(1,insertUserCount);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 找回密码
     * @param updatePwdDto
     * @return
     */
    @RequestMapping(value = "backPwd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UpdatePwdExcution> backPwd(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UpdatePwdExcution updataPwdByPhone = userCountService.updataPwdByPhone(updatePwdDto);
            return new BaseResult<UpdatePwdExcution>(1,updataPwdByPhone);
        } catch (Exception e) {
            return new BaseResult<UpdatePwdExcution>(0,e.getMessage());
        }
    }

    /**
     * 设置密码
     * @param updatePwdDto
     * @return
     */
    @RequestMapping(value = "setPwd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> setPwd(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution findUserById = userCountService.findUserById(updatePwdDto);
            return new BaseResult<UserCountExcution>(1,findUserById);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 获取个人信息
     * @param updatePwdDto
     * @return
     */
    @RequestMapping(value = "getData",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> getData(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution postUserById = userCountService.postUserById(updatePwdDto);
            return new BaseResult<UserCountExcution>(1,postUserById);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 获取个人信息(贾)
     * @param updatePwdDto
     * @return
     */
    @RequestMapping(value = "getStuForMerchant",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> getStuForMerchant(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution getUserById = userCountService.postUserById(updatePwdDto);
            return new BaseResult<UserCountExcution>(1,getUserById);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 保存个人基本信息
     * @param updateByIdDto
     * @return
     */
    @RequestMapping(value = "saveInfo",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> saveInfo(@RequestBody UpdateByIdDto updateByIdDto){
        //参数验空
        try {
            UserCountExcution updateById = userCountService.updateById(updateByIdDto);
            return new BaseResult<UserCountExcution>(1,updateById);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }

    /**
     * 根据ID查询学生信息
     * @param updatePwdDto
     * @return
     */
    @RequestMapping(value = "findInfoById",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserCountExcution> findInfoById(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution saveUserById = userCountService.saveUserById(updatePwdDto);
            return new BaseResult<UserCountExcution>(1,saveUserById);
        } catch (Exception e) {
            return new BaseResult<UserCountExcution>(0,e.getMessage());
        }
    }
}
