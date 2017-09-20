package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.UserInfoExcution;
import com.zxjz.dto.in.UserInfoDto;
import com.zxjz.enums.UserInfoEnum;
import com.zxjz.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController extends BaseController{


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "login",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UserInfoExcution> login(@RequestBody UserInfoDto userInfoDto){
        //参数验空
        try{
            UserInfoExcution userInfoExcution = userInfoService.login(userInfoDto);
            return new BaseResult<UserInfoExcution>(1,userInfoExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            UserInfoExcution userInfoExcution = new UserInfoExcution(0, UserInfoEnum.INNER_ERROR);
            return new BaseResult<UserInfoExcution>(0,userInfoExcution);
        }

    }

}
