package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.VIPMerchantAccountExcution;
import com.zxjz.dto.in.VIPMerchantAccountDto;
import com.zxjz.enums.VIPMerchantAccountEnum;
import com.zxjz.service.VIPMerchantAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/VIPMerAccount")
public class VIPMerchantAccountController extends BaseController{

    @Autowired
    private VIPMerchantAccountService vipMerchantAccountService;

    /**
     * 显示明星雇主商家页面
     * @return
     */
    @RequestMapping(value ="/showVIPMerAccountPage")
    public ModelAndView showStarMerchantPage(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("VIPMerchantsManage/VIPmerchant_admin");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 显示明星雇主账号信息
     * @param vipMerchantAccountDto
     * @return
     */
    @RequestMapping(value = "VIPMerAccount",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String starMerchantList(VIPMerchantAccountDto vipMerchantAccountDto){
        //参数验空
        try{
            VIPMerchantAccountExcution findListVIPMerchantAccount = vipMerchantAccountService.findListVIPMerchantAccount(vipMerchantAccountDto);
            return BaseUIResult.returnJsonEasyUI(findListVIPMerchantAccount);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            VIPMerchantAccountExcution vipMerchantAccountExcution = new VIPMerchantAccountExcution(e.getMessage(), VIPMerchantAccountEnum.FIND_ERROR);
            return BaseUIResult.returnJsonEasyUI(vipMerchantAccountExcution);
        }

    }

    /**
     * 显示添加VIP商家页面
     * @return
     */
    @RequestMapping(value ="/addVIPMerPage")
    public ModelAndView addVIPMerPage(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("VIPMerchantsManage/addInfo");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 添加VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    @RequestMapping(value = "addVIPMerchantAccount",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String addVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto){
        //参数验空
        try{
            VIPMerchantAccountExcution addVIPMerchantAccount = vipMerchantAccountService.addVIPMerchantAccount(vipMerchantAccountDto);
            return BaseUIResult.returnJsonMSG(1,addVIPMerchantAccount,"添加VIP商家成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            VIPMerchantAccountExcution vipMerchantAccountExcution = new VIPMerchantAccountExcution(e.getMessage(), VIPMerchantAccountEnum.RETURN_FAIL);
            return BaseUIResult.returnJsonMSG(0,vipMerchantAccountExcution,"添加VIP商家失败!");
        }

    }

    /**
     * 模糊查询商家名称
     * @param
     * @return
     */
    @RequestMapping(value = "findMerchantName",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findMerchantName(){
        //参数验空
        try{
            VIPMerchantAccountExcution findMerchantName = vipMerchantAccountService.findMerchantName();
            return BaseUIResult.returnJson(findMerchantName);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            VIPMerchantAccountExcution vipMerchantAccountExcution = new VIPMerchantAccountExcution(e.getMessage(), VIPMerchantAccountEnum.RETURN_FAIL);
            return BaseUIResult.returnJson(vipMerchantAccountExcution);
        }

    }

    /**
     * 显示编辑VIP商家账号
     * @return
     */
    @RequestMapping(value ="/editVIPMerchantPage")
    public ModelAndView editVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto){
        ModelAndView mv = new ModelAndView();
        try {
            VIPMerchantAccountExcution findVIPMerchantObject = vipMerchantAccountService.findVIPMerchantObject(vipMerchantAccountDto);
            mv.addObject("data", findVIPMerchantObject);
            mv.setViewName("VIPMerchantsManage/editInfo");
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 编辑VIP商家信息
     * @param vipMerchantAccountDto
     * @return
     */
    @RequestMapping(value = "editVIPMerchant",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editVIPMerchant(VIPMerchantAccountDto vipMerchantAccountDto){
        //参数验空
        try{
            VIPMerchantAccountExcution updateVIPMerchantObject = vipMerchantAccountService.updateVIPMerchantObject(vipMerchantAccountDto);
            return BaseUIResult.returnJsonMSG(1,updateVIPMerchantObject,"编辑成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            VIPMerchantAccountExcution vipMerchantAccountExcution = new VIPMerchantAccountExcution(e.getMessage(), VIPMerchantAccountEnum.RETURN_FAIL);
            return BaseUIResult.returnJsonMSG(0,vipMerchantAccountExcution,"编辑失败!");
        }

    }

    /**
     * 显示删除VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    @RequestMapping(value ="/showDelVIPMerchant")
    public ModelAndView showDelVIPMerchant(VIPMerchantAccountDto vipMerchantAccountDto){
        ModelAndView mv = new ModelAndView();
        try {
            VIPMerchantAccountExcution showDelVIPMerchant = vipMerchantAccountService.showDelVIPMerchant(vipMerchantAccountDto);
            mv.addObject("data", showDelVIPMerchant);
            mv.setViewName("VIPMerchantsManage/deleteInfo");
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 删除VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    @RequestMapping(value = "deleteVIPMerchant",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String deleteVIPMerchant(VIPMerchantAccountDto vipMerchantAccountDto){
        //参数验空
        try{
            VIPMerchantAccountExcution editVIPMerchantPage = vipMerchantAccountService.editVIPMerchantPage(vipMerchantAccountDto);
            return BaseUIResult.returnJsonMSG(1,editVIPMerchantPage,"删除成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            VIPMerchantAccountExcution vipMerchantAccountExcution = new VIPMerchantAccountExcution(e.getMessage(), VIPMerchantAccountEnum.RETURN_FAIL);
            return BaseUIResult.returnJsonMSG(0,vipMerchantAccountExcution,"删除失败!");
        }

    }
}
