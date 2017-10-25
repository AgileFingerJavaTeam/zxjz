package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AddMerchantExcution;
import com.zxjz.dto.in.AddMerchantDto;
import com.zxjz.enums.AddMerchantEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.AddMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/AddMerchant")
public class AddMerchantController extends BaseController{
    @Autowired
    private AddMerchantService addMerchantService;

    /**
     * 显示新增商户页面
     * @return
     */
    @RequestMapping(value = "/showAddMerchantPage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showAddMerchantPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("addMerchant/addMerchantPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询商户列表
     * @return
     */
    @RequestMapping(value = "/findAcceptedMerchantsList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findAcceptedMerchantsList(AddMerchantDto addMerchantDto){
        try {
            AddMerchantExcution addMerchantExcution = addMerchantService.findMerchantList(addMerchantDto);
            return BaseUIResult.returnJsonEasyUI(addMerchantExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            AddMerchantExcution addMerchantExcution = new AddMerchantExcution(AddMerchantEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(addMerchantExcution);
        }
    }
    /**
     * 显示新增商户对话框
     * @return
     */
    @RequestMapping(value = "/showAddMerchantDialog")
    public ModelAndView showAddMerchantDialog(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("addMerchant/addMerchantDialog");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 新增商户
     * @param addMerchantDto
     * @return
     */
    @RequestMapping(value = "/insertMerchant",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String insertMerchant(AddMerchantDto addMerchantDto){
        try {
            AddMerchantExcution addMerchantExcution = addMerchantService.insertMerchant(addMerchantDto);
            return BaseUIResult.returnJsonMSG(1,addMerchantExcution,"新增成功");
        }catch (InsertInnerErrorException e){
            AddMerchantExcution addMerchantExcution = new AddMerchantExcution(AddMerchantEnum.INERT_FAIL);
            return BaseUIResult.returnJsonMSG(0,addMerchantExcution,"新增失败");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            AddMerchantExcution addMerchantExcution = new AddMerchantExcution(AddMerchantEnum.INERT_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,addMerchantExcution,"新增失败");
        }
    }
    /**
     * 显示编辑商户对话框
     * @param addMerchantDto
     * @return
     */
    @RequestMapping(value = "/showEditMerchantDialog",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showEditMerchantDialog(AddMerchantDto addMerchantDto){
        ModelAndView mv = new ModelAndView();
        try {
            AddMerchantExcution addMerchantExcution = addMerchantService.findMerchantInfo(addMerchantDto);
            mv.addObject("data",addMerchantExcution);
            mv.setViewName("addMerchant/editMerchantDialog");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 编辑商户
     * @param addMerchantDto
     * @return
     */
    @RequestMapping(value = "/editMerchant",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editMerchant(AddMerchantDto addMerchantDto){
        try {
            AddMerchantExcution addMerchantExcution = addMerchantService.editMerchant(addMerchantDto);
            return BaseUIResult.returnJsonMSG(1,addMerchantExcution,"编辑成功");
        }catch (UpdateInnerErrorException e){
            AddMerchantExcution addMerchantExcution = new AddMerchantExcution(AddMerchantEnum.EDIT_FAIL);
            return BaseUIResult.returnJsonMSG(0,addMerchantExcution,"编辑失败");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            AddMerchantExcution addMerchantExcution = new AddMerchantExcution(AddMerchantEnum.EDIT_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,addMerchantExcution,"编辑失败");
        }
    }
}
