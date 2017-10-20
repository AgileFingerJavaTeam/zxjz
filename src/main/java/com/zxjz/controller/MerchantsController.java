/*
package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.MerchantsAffirmStudentBreakPromiseExcution;
import com.zxjz.dto.excution.MerchantsChangeHeadExcution;
import com.zxjz.dto.excution.MerchantsInfoExcution;
import com.zxjz.dto.excution.MerchantsUpgradeExcution;
import com.zxjz.dto.in.MerchantsAffirmStudentBreakPromiseDto;
import com.zxjz.dto.in.MerchantsChangeHeadDto;
import com.zxjz.dto.in.MerchantsInfoDto;
import com.zxjz.dto.in.MerchantsUpgradeDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.MerchantsAffirmStudentBreakPromiseEnum;
import com.zxjz.enums.MerchantsChangeHeadEnum;
import com.zxjz.enums.MerchantsInfoEnum;
import com.zxjz.enums.MerchantsUpgradeEnum;
import com.zxjz.exception.*;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.MerchantsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/employer")
public class MerchantsController extends BaseController {

    @Autowired
    private MerchantsInfoService merchantsInfoService;


    */
/**
     * 升级账户
     *
     * @param merchantsUpgradeDto
     * @return
     *//*

    @RequestMapping(value = "/Premium",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult Premium(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto) {
        //参数验空
        try {
            MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.upgradeAccount(merchantsUpgradeDto);
            return new BaseAPIResult(1, merchantsUpgradeExcution);
        } catch (RepeatApplyException e) {
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_REPEAT);
            return new BaseAPIResult(0, merchantsUpgradeExcution);
        } catch (ApplyFailException e) {
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_ERROR);
            return new BaseAPIResult(0, merchantsUpgradeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_ERROR, e.getMessage());
            return new BaseAPIResult(0, merchantsUpgradeExcution);
        }

    }

    */
/**
     * 变更负责人
     *
     * @param merchantsChangeHeadDto
     * @return
     *//*

    @RequestMapping(value = "/changeHead",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult changeHead(@RequestBody MerchantsChangeHeadDto merchantsChangeHeadDto) {
        //参数验空
        try {
            MerchantsChangeHeadExcution merchantsChangeHeadExcution = merchantsInfoService.changeHead(merchantsChangeHeadDto);
            return new BaseAPIResult(1, merchantsChangeHeadExcution);
        } catch (UpdateDatabaseException e) {
            MerchantsChangeHeadExcution merchantsChangeHeadExcution = new MerchantsChangeHeadExcution(MerchantsChangeHeadEnum.CHANGE_FAIL);
            return new BaseAPIResult(0, merchantsChangeHeadExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsChangeHeadExcution merchantsChangeHeadExcution = new MerchantsChangeHeadExcution(MerchantsChangeHeadEnum.CHANGE_FAIL, e.getMessage());
            return new BaseAPIResult(0, merchantsChangeHeadExcution);
        }
    }

    */
/**
     * 获取商家个人信息
     *
     * @param merchantsInfoDto
     * @return
     *//*

    @RequestMapping(value = "/getEmpolyerInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findEmpolyerInfoById(@RequestBody MerchantsInfoDto merchantsInfoDto) {
        //参数验空
        try {
            MerchantsInfoExcution merchantsInfoExcution = merchantsInfoService.findEmpolyerInfoById(merchantsInfoDto);
            return new BaseAPIResult(1, merchantsInfoExcution);
        } catch (FindDatabaseException e) {
            MerchantsInfoExcution merchantsInfoExcution = new MerchantsInfoExcution(MerchantsInfoEnum.INQUIRE_ERROR);
            return new BaseAPIResult(0, merchantsInfoExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsInfoExcution merchantsInfoExcution = new MerchantsInfoExcution(MerchantsInfoEnum.INQUIRE_ERROR, e.getMessage());
            return new BaseAPIResult(0, merchantsInfoExcution);
        }
    }

    */
/**
     * 确认员工爽约
     *
     * @param merchantsAffirmStudentBreakPromiseDto
     * @return
     *//*

    @RequestMapping(value = "/affirmStuBaa",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult affirmStuBaa(@RequestBody MerchantsAffirmStudentBreakPromiseDto merchantsAffirmStudentBreakPromiseDto) {
        //参数验空
        try {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = merchantsInfoService.confirmStudentMiss(merchantsAffirmStudentBreakPromiseDto);
            return new BaseAPIResult(1, merchantsAffirmStudentBreakPromiseExcution);
        } catch (UpdateInnerErrorException e) {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.AFFIRM_STUDENT_BREAK_PROMISE_FAIL);
            return new BaseAPIResult(0, merchantsAffirmStudentBreakPromiseExcution);
        } catch (QueryInnerErrorException e) {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.FIND_DOUBLEID_FAIL);
            return new BaseAPIResult(0, merchantsAffirmStudentBreakPromiseExcution);
        } catch (UpdateDatabaseException e) {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.OVER_WORK_FAIL);
            return new BaseAPIResult(0, merchantsAffirmStudentBreakPromiseExcution);
        } catch (UpdateStuMissException e) {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.UPDATE_STUDENT_MISS_NUMBER_FAIL);
            return new BaseAPIResult(0, merchantsAffirmStudentBreakPromiseExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.UPDATE_STUDENT_MISS_NUMBER_FAIL, e.getMessage());
            return new BaseAPIResult(0, merchantsAffirmStudentBreakPromiseExcution);
        }
    }

    */
/**
     * 显示商户申请VIP页面
     *
     * @return
     *//*

    @RequestMapping(value = "/showApplyVipPage",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showApplyVipPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("applyVIP/showApplyVipPage");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    */
/**
     * 查询申请VIP商户信息
     *
     * @param merchantsUpgradeDto
     * @return
     *//*

    @RequestMapping(value = "/GetApplyVipInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findApplyVipShopInfo(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto) {
        try {
            MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.findApplyVipShopList(merchantsUpgradeDto);
            return  BaseUIResult.returnJsonEasyUI( merchantsUpgradeExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.FIND_FAIL, e.getMessage());
            return  BaseUIResult.returnJsonEasyUI( merchantsUpgradeExcution);
        }
    }

    */
/**
     * 显示审核页面
     *
     * @param merchantsUpgradeDto
     * @return
     *//*

    @RequestMapping(value = "/showAuditPage",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showAuditPage(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto) {
        ModelAndView mv = new ModelAndView();
        try {
            MerchantsUpgradeExcution applyInfo = merchantsInfoService.showAuditPage(merchantsUpgradeDto);
            mv.addObject("data1", applyInfo);
            mv.setViewName("applyVIP/AuditPage");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    */
/**
     * 审核
     * @param merchantsUpgradeDto
     * @return
     *//*

    @RequestMapping(value = "/audit",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String check(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto) {
        try {
            HttpSession session = this.getRequest().getSession();
            LandFallInfo user = (LandFallInfo) session.getAttribute("user");


            int id = user.getEmployees_id();
            merchantsUpgradeDto.setId(id);

            MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.confirmCheck(merchantsUpgradeDto);
            return  BaseUIResult.returnJsonEasyUI(merchantsUpgradeExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.CONFIRM_CHECK_FAIL, e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(merchantsUpgradeExcution);
        }
    }

    */
/**
     * 查询员工列表
     * @param
     * @return
     *//*

    @RequestMapping(value = "/getAccEm",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findCheckEmployer(){
        try {
            MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.findCheckEmployer();
            return new BaseAPIResult(1,merchantsUpgradeExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.FIND_CHECK_EMPLOYER_FAIL);
            return new BaseAPIResult(0,merchantsUpgradeExcution);
        }
    }
}
*/
