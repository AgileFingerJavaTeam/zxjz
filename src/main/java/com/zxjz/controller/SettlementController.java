package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.SettlementExcution;
import com.zxjz.dto.in.SettlementAddFunctionDto;
import com.zxjz.dto.in.SettlementDto;
import com.zxjz.entity.LandFall;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.SettlementEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Controller
@RequestMapping("/Settlement")
public class SettlementController extends BaseController{
    @Autowired
    private SettlementService settlementService;

    /**
     * 显示页面
     * @return
     */
    @RequestMapping(value = "/SettlementJsp",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("settlementServiceFee/AT_Service"); // jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查数据
     * @param settlementDto
     * @return
     */
    @RequestMapping(value = "/SettlementJspList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String SettlementJspList(SettlementDto settlementDto){
        //参数验空
        try {
            SettlementExcution settlementExcution = settlementService.findListSettlement(settlementDto);
            return BaseUIResult.returnJsonEasyUI(settlementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(settlementExcution);
        }
    }

     /*
	  * 模糊查询
	  */
     @RequestMapping(value = "/search",
             method = RequestMethod.POST,
             produces = {"text/json;charset=UTF-8"})
     @ResponseBody
    public String search(SettlementDto settlementDto){
        //参数验空
        try {
            SettlementExcution settlementExcution = settlementService.findSearch(settlementDto);
            return BaseUIResult.returnJsonEasyUI(settlementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(settlementExcution);
        }
    }

    /**
     * 显示添加页面
     * @return
     */
    @RequestMapping(value = "/add",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView Add(){
        ModelAndView mv = new ModelAndView();
        HttpSession session = this.getRequest().getSession();
        try{
            LandFallInfo land = (LandFallInfo)session.getAttribute("user");
            int id = land.getEmployeesId();
            String name = land.getEmployeesName();
            mv.addObject("id", id);
            mv.addObject("name", name);
            mv.setViewName("settlementServiceFee/AT_Add");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 显示查看页面数据
     * @return
     */
    @RequestMapping(value = "/find",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView FindData(SettlementDto settlementDto){
        ModelAndView mv = new ModelAndView();
      try {
            SettlementExcution settlementExcution = settlementService.getSettlementData(settlementDto);
            mv.addObject("data", settlementExcution.getData());
            mv.setViewName("settlementServiceFee/AT_Find");
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;

    }

    /**
     * AJAX显示
     * @return
     */
    @RequestMapping(value = "/add1",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String add1(SettlementDto settlementDto){
        //参数验空
        try {
            SettlementExcution settlementExcution = settlementService.findMaxNumber(settlementDto);
            return BaseUIResult.returnJson(settlementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJson(settlementExcution);
        }

    }

    /**
     * 添加方法
     * @return
     */
    @RequestMapping(value = "/addFunction",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String addFunction(SettlementAddFunctionDto settlementAddFunctionDto) {
        //参数验空
        try {
            SettlementExcution settlementExcution = settlementService.saveFunction(settlementAddFunctionDto);
            return BaseUIResult.returnJsonMSG(1,settlementExcution,"添加成功");
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,settlementExcution,"添加失败");
        }
        catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,settlementExcution,"添加失败");
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,settlementExcution,"添加失败");
        }
    }
    /**
     * 查询商户名称
     *
     * @return
     */
    @RequestMapping(value = "/getMerchantsName",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getMerchantsName(SettlementDto settlementDto){
        //参数验空
        try {
            SettlementExcution settlementExcution = settlementService.findMerchantsName(settlementDto);
            return BaseUIResult.returnJson(settlementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SettlementExcution settlementExcution = new SettlementExcution(SettlementEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJson(settlementExcution);
        }
    }
}
