package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.RechargeExcution;
import com.zxjz.dto.in.RechargeDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.entity.RechargeInfo;
import com.zxjz.enums.RechargeEnum;
import com.zxjz.enums.RecruitmentEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Recharge")
public class RechargeController extends BaseController {
    @Autowired
    private RechargeService rechargeService;

    /**
     * 商户充值列表页面
     */
    @RequestMapping(value = "/rechargeListPage")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("recharge/rechargePage");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询充值列表
     */
    @RequestMapping(value = "/getRechargeList", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult getRechargeList(@RequestBody RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.findRechargeList(rechargeDto);
            return new BaseAPIResult(1, rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return new BaseAPIResult(0, rechargeExcution);
        }
    }

    /**
     * 新增充值页面
     *
     * @return
     */
    @RequestMapping(value = "/addCharge")
    public ModelAndView addCharge() {
        ModelAndView mv = new ModelAndView();
        HttpSession session = this.getRequest().getSession();
        try {
            LandFallInfo landfall = (LandFallInfo) session.getAttribute("user");
            int employid = landfall.getEmployees_id();
            String employname = landfall.getEmployees_name();
            mv.addObject("data", employid);
            mv.addObject("datas", employname);
            mv.setViewName("recharge/addCharge");
        } catch (Exception e) {
              RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 详情信息页面
     *
     * @return
     */
    @RequestMapping(value = "/findRechargePage")
    public ModelAndView findRechargePage(@RequestBody RechargeDto rechargeDto) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = this.getRequest().getSession();
        try {
            RechargeExcution rechargeExcution = rechargeService.findRechargePage(rechargeDto);
            LandFallInfo landfall = (LandFallInfo) session.getAttribute("user");
            int employid = landfall.getEmployees_id();
            String employname = landfall.getEmployees_name();
            mv.addObject("id", employid);
            mv.addObject("name", employname);
            mv.addObject("data", rechargeExcution.getData());
            mv.setViewName("recharge/findrecharge");
        } catch (Exception e) {
             RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询商户名称
     *
     * @return
     */
    @RequestMapping(value = "/getMerchantsName", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult checkauth(@RequestBody RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.checkauth(rechargeDto);
            return new BaseAPIResult(1, rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return new BaseAPIResult(0, rechargeExcution);
        }
    }

    /**
     * 查询充值方式
     *
     * @return
     */
    @RequestMapping(value = "/getChargeMethod", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult getChargeMethod(RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.findRechargeList(rechargeDto);
            return new BaseAPIResult(1, rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
             RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return new BaseAPIResult(0, rechargeExcution);
        }
    }

    /**
     * 查询流水号
     *
     * @return
     */
    @RequestMapping(value = "/getNum", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult getNum(RechargeDto rechargeDto) {
        try {
            RechargeExcution rechargeExcution = rechargeService.getNum(rechargeDto);
            return new BaseAPIResult(1, rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return new BaseAPIResult(0, rechargeExcution);
        }
    }


    @RequestMapping(value = "/subform", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult saveSubForm(RechargeDto rechargeDto) {
        try {
            RechargeExcution rechargeExcution = rechargeService.saveSubForm(rechargeDto);
            return new BaseAPIResult(1, rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return new BaseAPIResult(0, rechargeExcution);
        }
    }
}
