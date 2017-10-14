package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.dto.excution.CodeExcution;
import com.zxjz.dto.excution.UpdatePwdExcution;
import com.zxjz.dto.excution.UserCountExcution;
import com.zxjz.dto.in.CodeDto;
import com.zxjz.dto.in.UpdateByIdDto;
import com.zxjz.dto.in.UpdatePwdDto;
import com.zxjz.dto.in.UserCountDto;
import com.zxjz.enums.RegistrationEnum;
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
    public BaseAPIResult loginPwd(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByPhoneAndPwd = userCountService.findUserByPhoneAndPwd(userCountDto);
            return new BaseAPIResult(1,findUserByPhoneAndPwd);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage(), RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult loginWechat(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByWechatID = userCountService.findUserByWechatID(userCountDto);
            return new BaseAPIResult(1,findUserByWechatID);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage(), RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult loginQQ(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution findUserByQQID = userCountService.findUserByQQID(userCountDto);
            return new BaseAPIResult(1,findUserByQQID);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage(), RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult sendSMS(CodeDto codeDto){
        //参数验空
        try {
            CodeExcution findVerifyCode = userCountService.findVerifyCode(codeDto);
            return new BaseAPIResult(1,findVerifyCode);
        } catch (Exception e) {
            CodeExcution codeExcution = new CodeExcution(RegistrationEnum.FIND_ERROR,e.getMessage());
            return new BaseAPIResult(0,codeExcution);
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
    public BaseAPIResult loginVerifyCode(@RequestBody CodeDto codeDto){
        //参数验空
        try {
            UserCountExcution findUserByPhone = userCountService.findUserByPhone(codeDto);
            return new BaseAPIResult(1,findUserByPhone);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult judgeVerifyCode(@RequestBody CodeDto codeDto){
        //参数验空
        try {
            UserCountExcution getUserByPhone = userCountService.getUserByPhone(codeDto);
            return new BaseAPIResult(1,getUserByPhone);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult register(@RequestBody UserCountDto userCountDto){
        //参数验空
        try {
            UserCountExcution insertUserCount = userCountService.insertUserCount(userCountDto);
            return new BaseAPIResult(1,insertUserCount);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult backPwd(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UpdatePwdExcution updataPwdByPhone = userCountService.updataPwdByPhone(updatePwdDto);
            return new BaseAPIResult(1,updataPwdByPhone);
        } catch (Exception e) {
            UpdatePwdExcution updatePwdExcution = new UpdatePwdExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,updatePwdExcution);
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
    public BaseAPIResult setPwd(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution findUserById = userCountService.findUserById(updatePwdDto);
            return new BaseAPIResult(1,findUserById);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult getData(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution postUserById = userCountService.postUserById(updatePwdDto);
            return new BaseAPIResult(1,postUserById);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult getStuForMerchant(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution getUserById = userCountService.postUserById(updatePwdDto);
            return new BaseAPIResult(1,getUserById);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult saveInfo(@RequestBody UpdateByIdDto updateByIdDto){
        //参数验空
        try {
            UserCountExcution updateById = userCountService.updateById(updateByIdDto);
            return new BaseAPIResult(1,updateById);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
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
    public BaseAPIResult findInfoById(@RequestBody UpdatePwdDto updatePwdDto){
        //参数验空
        try {
            UserCountExcution saveUserById = userCountService.saveUserById(updatePwdDto);
            return new BaseAPIResult(1,saveUserById);
        } catch (Exception e) {
            UserCountExcution userCountExcution = new UserCountExcution(e.getMessage() ,RegistrationEnum.FIND_ERROR);
            return new BaseAPIResult(0,userCountExcution);
        }
    }
}
