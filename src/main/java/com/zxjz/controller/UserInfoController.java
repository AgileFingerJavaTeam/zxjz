package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.UserInfoExcution;
import com.zxjz.dto.in.UserInfoDto;
import com.zxjz.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value = "/show" , method = RequestMethod.GET)
    public String list(Model model){
        //获取想要在页面输出的对象
        //输出
//        model.addAttribute("list",);
        //list.jsp + model = ModelAndView
        return "login/login";//WEB-INF/jsp/list.jsp
    }



    @RequestMapping(value = "/login",
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
            return new BaseResult<UserInfoExcution>(0,e.getMessage());
        }
    }

}
