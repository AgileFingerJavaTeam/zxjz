package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AtMarchantFindExcution;
import com.zxjz.dto.in.AtMarchantFindDto;
import com.zxjz.enums.AtMarchantFindEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.AtMarchantFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Controller
@RequestMapping("/MarchantFind")
public class AtMarchantFindController extends BaseController{
     @Autowired
     private AtMarchantFindService atMarchantFindService;
    /**
     * 显示页面
     * @return
     */
    @RequestMapping(value ="/showMarchantFind")
    public ModelAndView showLandFall(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("marchantFind/at_main_marchantFind");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /*
    * 显示页面数据
    */
    @RequestMapping(value = "/getMarchantList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getSecurityPositionList(AtMarchantFindDto atMarchantFindDto) {
        //参数验空
        try {
            AtMarchantFindExcution atMarchantFindExcution = atMarchantFindService.getMarchantList(atMarchantFindDto);
            return BaseUIResult.returnJsonEasyUI(atMarchantFindExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            AtMarchantFindExcution atMarchantFindExcution = new AtMarchantFindExcution(AtMarchantFindEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(atMarchantFindExcution);
        }
    }


    /**
     * 显示修改页面
     * @return
     */
    @RequestMapping(value = "/showUpdate",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showUpdate(AtMarchantFindDto atMarchantFindDto){
        ModelAndView mv = new ModelAndView();
        try{
            AtMarchantFindExcution atMarchantFindExcution = atMarchantFindService.getMarchantIsLook(atMarchantFindDto);
            mv.addObject("data",atMarchantFindExcution.getData());
            mv.setViewName("marchantFind/at_update");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /*
     * 更改
     */
    @RequestMapping(value = "/editMarchant",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editMarchant(AtMarchantFindDto atMarchantFindDto) {
        //参数验空
        try {
            AtMarchantFindExcution atMarchantFindExcution = atMarchantFindService.editMarchant(atMarchantFindDto);
            return BaseUIResult.returnJsonMSG(1,atMarchantFindExcution,"更改成功");
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            AtMarchantFindExcution atMarchantFindExcution = new AtMarchantFindExcution(AtMarchantFindEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,atMarchantFindExcution,"更改失败");
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            AtMarchantFindExcution atMarchantFindExcution = new AtMarchantFindExcution(AtMarchantFindEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,atMarchantFindExcution,"更改失败");
        }
    }


    /*
   * 显示页面数据
   */
    @RequestMapping(value = "/getMarchantListTimeSearch",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getMarchantListTimeSearch(AtMarchantFindDto atMarchantFindDto) {
        //参数验空
        try {
            AtMarchantFindExcution atMarchantFindExcution = atMarchantFindService.getMarchantListTimeSearch(atMarchantFindDto);
            return BaseUIResult.returnJsonEasyUI(atMarchantFindExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            AtMarchantFindExcution atMarchantFindExcution = new AtMarchantFindExcution(AtMarchantFindEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(atMarchantFindExcution);
        }
    }
}
