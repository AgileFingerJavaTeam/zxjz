package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.in.AuthManagementDto;
import com.zxjz.dto.in.MvAuthDto;
import com.zxjz.entity.AuthManagement;
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

    /**
     * 添加弹出框
     * @return
     */
    @RequestMapping(value ="/getTanAuth")
    @ResponseBody
    public ModelAndView getTanAuth(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("auth_management/addAuth");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 添加权限分组名称
     * @param authManagementDto
     * @return
     */
    @RequestMapping(value = "AddAuthManagement",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String AddAuthManagement(AuthManagementDto authManagementDto){
        //参数验空
        try{
            AuthManagementExcution addAuthManagement = authManagementService.addAuthManagement(authManagementDto);
            return BaseUIResult.returnJsonMSG(1,addAuthManagement,"添加成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthManagementExcution authManagementExcution = new AuthManagementExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonMSG(0,authManagementExcution,"添加失败！");
        }

    }

    /**
     * 获取菜单名称
     * @param
     * @return
     */
    @RequestMapping(value = "getMenuName",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getMenuName(){
        //参数验空
        try{
            AuthManagementExcution getMenuName = authManagementService.getMenuName();
            return BaseUIResult.returnJson(getMenuName);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthManagementExcution authManagementExcution = new AuthManagementExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJson(authManagementExcution);
        }

    }

    /**
     * 显示权限编辑页面
     * @return
     */
    @RequestMapping(value ="/getEditMvAuth")
    public ModelAndView getEditMvAuth(MvAuthDto mvAuthDto){
        ModelAndView mv = new ModelAndView();
        try {
            AuthManagementExcution editMvAuth = authManagementService.editMvAuth(mvAuthDto);
            mv.addObject("data", editMvAuth.getData());
            mv.setViewName("auth_management/editAuth");
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 编辑权限数据
     * @param
     * @return
     */
    @RequestMapping(value = "editEditAuth",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editEditAuth(MvAuthDto mvAuthDto){
        //参数验空
        try{
            AuthManagementExcution editEditAuth = authManagementService.editEditAuth(mvAuthDto);
            return BaseUIResult.returnJsonMSG(1,editEditAuth,"修改成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthManagementExcution authManagementExcution = new AuthManagementExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonMSG(0,authManagementExcution,"修改失败！");
        }

    }

    /**
     * 显示删除权限页面
     * @return
     */
    @RequestMapping(value ="/delAuth")
    public ModelAndView delAuth(MvAuthDto mvAuthDto){
        ModelAndView mv = new ModelAndView();
        try {
            AuthManagementExcution findAuthInfo = authManagementService.findAuthInfo(mvAuthDto);
            mv.addObject("data", findAuthInfo);
            mv.setViewName("auth_management/delAuth");
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 删除权限分组
     * @param mvAuthDto
     * @return
     */
    @RequestMapping(value = "deleteParameter",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String deleteParameter(MvAuthDto mvAuthDto){
        //参数验空
        try{
            AuthManagementExcution deleteParameter = authManagementService.deleteParameter(mvAuthDto);
            return BaseUIResult.returnJsonMSG(1,deleteParameter,"删除成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthManagementExcution authManagementExcution = new AuthManagementExcution(e.getMessage(), IndustryClassificationEnum.DELETE_ERROR);
            return BaseUIResult.returnJsonMSG(0,authManagementExcution,"删除失败！");
        }

    }
}
