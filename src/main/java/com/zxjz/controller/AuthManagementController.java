package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.excution.IndustryClassificationExcution;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.service.AuthManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/AuthManagement")
public class AuthManagementController extends BaseController{

    @Autowired
    private AuthManagementService authManagementService;

    /**
     * 显示角色管理页面
     * @return
     */
    @RequestMapping(value ="/showAuthManagement")
    public ModelAndView showAuthManagement(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("auth_management/showAuth");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    @SuppressWarnings("all")
    @RequestMapping(value = "getAuthManagement",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getAuthManagement(){
        //参数验空
        try{
            AuthManagementExcution getAuthManagement = authManagementService.getAuthManagement();
            return BaseUIResult.returnJsonEasyUI(getAuthManagement);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthManagementExcution authManagementExcution = new AuthManagementExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonEasyUI(authManagementExcution);
        }

    }
}
