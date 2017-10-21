package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.MarchantArrearExcution;
import com.zxjz.dto.in.MarchantArrearDto;
import com.zxjz.enums.MarchantArrearEnum;
import com.zxjz.service.MarchantArrearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
@Controller
@RequestMapping("/MarchantArrear")
public class MarchantArrearController extends BaseController{

    @Autowired
    private MarchantArrearService marchantArrearService;

    @RequestMapping(value = "/showMarchant")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            MarchantArrearExcution marchantArrearExcution1 = marchantArrearService.findCountQ();
            MarchantArrearExcution marchantArrearExcution2 = marchantArrearService.findMoneyQ();
            MarchantArrearExcution marchantArrearExcution3 = marchantArrearService.findVipCount();
            MarchantArrearExcution marchantArrearExcution4 = marchantArrearService.findVipCountMoney();
            mv.addObject("count",marchantArrearExcution1.getData());
            mv.addObject("money",marchantArrearExcution2.getData());
            mv.addObject("vip",marchantArrearExcution3.getData());
            mv.addObject("vipMoney",marchantArrearExcution4.getData());
            mv.setViewName("marchantArrear/show_Marchant"); // jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }


    @RequestMapping(value = "/getMarchantList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getMarchantList(MarchantArrearDto marchantArrearDto) {
        //参数验空
        try {
            MarchantArrearExcution marchantArrearExcution = marchantArrearService.findMarchantArrear(marchantArrearDto);
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MarchantArrearExcution marchantArrearExcution = new MarchantArrearExcution(MarchantArrearEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        }
    }

    @RequestMapping(value = "/getMarchantListSearch",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getMarchantListSearch(MarchantArrearDto marchantArrearDto) {
        //参数验空
        try {
            MarchantArrearExcution marchantArrearExcution = marchantArrearService.getMarchantListSearch(marchantArrearDto);
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MarchantArrearExcution marchantArrearExcution = new MarchantArrearExcution(MarchantArrearEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        }
    }

    @RequestMapping(value = "/showSecurity",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showSecurity(MarchantArrearDto marchantArrearDto) {
        ModelAndView mv = new ModelAndView();
        try {
            MarchantArrearExcution marchantArrearExcution = marchantArrearService.findSecurity(marchantArrearDto);
            mv.addObject("data",marchantArrearExcution.getData());
            mv.setViewName("marchantArrear/showSecurity"); // jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }


    @RequestMapping(value = "/getReceivablesList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getReceivablesList(MarchantArrearDto marchantArrearDto) {
        //参数验空
        try {
            MarchantArrearExcution marchantArrearExcution = marchantArrearService.getReceivables(marchantArrearDto);
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MarchantArrearExcution marchantArrearExcution = new MarchantArrearExcution(MarchantArrearEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        }
    }

    @RequestMapping(value = "/getReceivablesListSearch",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getReceivablesListSearch(MarchantArrearDto marchantArrearDto) {
        //参数验空
        try {
            MarchantArrearExcution marchantArrearExcution = marchantArrearService.getReceivablesListSearch(marchantArrearDto);
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MarchantArrearExcution marchantArrearExcution = new MarchantArrearExcution(MarchantArrearEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(marchantArrearExcution);
        }
    }

}
