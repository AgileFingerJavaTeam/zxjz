package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.LoginExcution;
import com.zxjz.dto.in.LoginDto;
import com.zxjz.enums.LoginEnum;
import com.zxjz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/LandFall")
public class LoginController extends BaseController{
    @Autowired
    private LoginService loginService;

    /**
     * 显示登陆页面
     * @return
     */
    @RequestMapping(value ="/showLandFall")
    public ModelAndView showLandFall(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("landfall/showLandfall");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    @RequestMapping(value = "getShowLandFall",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getShowLandFall(LoginDto loginDto){
        //参数验空
        try {
            LoginExcution findAccountInfo = loginService.findAccountInfo(loginDto);
            return BaseUIResult.returnJson(findAccountInfo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            LoginExcution loginExcution = new LoginExcution(e.getMessage(), LoginEnum.LOG_IN_FALL);
            return BaseUIResult.returnJson(loginExcution);
        }
    }
}
