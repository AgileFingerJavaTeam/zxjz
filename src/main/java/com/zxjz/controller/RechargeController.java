package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String getRechargeList(RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.findRechargeList(rechargeDto);
            return BaseUIResult.returnJsonEasyUI(rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonEasyUI(rechargeExcution);
        }
    }

    /**
     * 新增充值页面
     *
     * @return
     */
    @RequestMapping(value = "/addCharge",
    method = RequestMethod.GET,
    produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView addCharge() {
        ModelAndView mv = new ModelAndView();
        HttpSession session = this.getRequest().getSession();
        try {
            LandFallInfo landfall = (LandFallInfo) session.getAttribute("user");
            int employid = landfall.getEmployeesId();
            String employname = landfall.getEmployeesName();
            mv.addObject("id", employid);
            mv.addObject("name", employname);
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
    @RequestMapping(value = "/findRechargePage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView findRechargePage( RechargeDto rechargeDto) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = this.getRequest().getSession();
        try {
            RechargeExcution rechargeExcution = rechargeService.findRechargePage(rechargeDto);
           /* LandFallInfo landfall = (LandFallInfo) session.getAttribute("user");
            int employid = landfall.getEmployeesId();
            String employname = landfall.getEmployeesName();
            mv.addObject("id", employid);
            mv.addObject("name", employname);*/
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
    @RequestMapping(value = "/getMerchantsName", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String checkauth(RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.checkauth(rechargeDto);
            return BaseUIResult.returnJsonEasyUI(rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonEasyUI(rechargeExcution);
        }
    }

    /**
     * 查询充值方式
     *
     * @return
     */
    @RequestMapping(value = "/getChargeMethod",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getRechargeMethod(RechargeDto rechargeDto) {
        //参数验空
        try {
            RechargeExcution rechargeExcution = rechargeService.getChargeMethod(rechargeDto);
            return BaseUIResult.returnJson(rechargeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJson(rechargeExcution);
        }
    }
        /**
         * 查询流水号
         *
         * @return
         */

        @RequestMapping(value = "/getNum",
                method = RequestMethod.POST,
                produces = {"text/json;charset=UTF-8"})
        @ResponseBody
        public String getNum (RechargeDto rechargeDto){
            try {
                RechargeExcution rechargeExcution = rechargeService.getNum(rechargeDto);
                return BaseUIResult.returnJson(rechargeExcution);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
                return BaseUIResult.returnJson(rechargeExcution);
            }
        }


    @RequestMapping(value = "/subform",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
        public String saveSubForm (RechargeDto rechargeDto){
            try {
                RechargeExcution rechargeExcution = rechargeService.saveSubForm(rechargeDto);
                return BaseUIResult.returnJsonMSG(1,rechargeExcution,"成功");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                RechargeExcution rechargeExcution = new RechargeExcution(RechargeEnum.FAIL, e.getMessage());
                return BaseUIResult.returnJsonMSG(0,rechargeExcution,"失败");
            }
        }
}
