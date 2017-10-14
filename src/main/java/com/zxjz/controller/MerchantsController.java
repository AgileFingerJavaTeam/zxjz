package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.MerchantsAffirmStudentBreakPromiseExcution;
import com.zxjz.dto.excution.MerchantsChangeHeadExcution;
import com.zxjz.dto.excution.MerchantsInfoExcution;
import com.zxjz.dto.excution.MerchantsUpgradeExcution;
import com.zxjz.dto.in.MerchantsAffirmStudentBreakPromiseDto;
import com.zxjz.dto.in.MerchantsChangeHeadDto;
import com.zxjz.dto.in.MerchantsInfoDto;
import com.zxjz.dto.in.MerchantsUpgradeDto;
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

import java.util.List;

@Controller
@RequestMapping(value = "/employer")
public class MerchantsController extends BaseController{

    @Autowired
    private MerchantsInfoService merchantsInfoService;


    /**
     * 升级账户
     * @param merchantsUpgradeDto
     * @return
     */
    @RequestMapping(value = "/Premium",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantsUpgradeExcution> Premium(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto){
        //参数验空
        try{
            MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.upgradeAccount(merchantsUpgradeDto);
            return new BaseResult<MerchantsUpgradeExcution>(1,merchantsUpgradeExcution);
        } catch (RepeatApplyException e){
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_REPEAT);
            return new BaseResult<MerchantsUpgradeExcution>(0,merchantsUpgradeExcution);
        } catch (ApplyFailException e) {
            MerchantsUpgradeExcution merchantsUpgradeExcution = new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_ERROR);
            return new BaseResult<MerchantsUpgradeExcution>(0, merchantsUpgradeExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<MerchantsUpgradeExcution>(0,e.getMessage());
        }

    }

    /**
     * 变更负责人
     * @param merchantsChangeHeadDto
     * @return
     */
    @RequestMapping(value = "/changeHead",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantsChangeHeadExcution> changeHead (@RequestBody MerchantsChangeHeadDto merchantsChangeHeadDto){
        //参数验空
        try {
            MerchantsChangeHeadExcution merchantsChangeHeadExcution = merchantsInfoService.changeHead(merchantsChangeHeadDto);
            return  new BaseResult<MerchantsChangeHeadExcution>(1,merchantsChangeHeadExcution);
        }catch (UpdateDatabaseException e){
            MerchantsChangeHeadExcution merchantsChangeHeadExcution = new MerchantsChangeHeadExcution(MerchantsChangeHeadEnum.CHANGE_FAIL);
            return new BaseResult<MerchantsChangeHeadExcution>(0,merchantsChangeHeadExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<MerchantsChangeHeadExcution>(0,e.getMessage());
        }
    }

    /**
     * 获取商家个人信息
     * @param merchantsInfoDto
     * @return
     */
    @RequestMapping(value = "/getEmpolyerInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantsInfoExcution> findEmpolyerInfoById (@RequestBody MerchantsInfoDto merchantsInfoDto) {
        //参数验空
        try {
            MerchantsInfoExcution merchantsInfoExcution = merchantsInfoService.findEmpolyerInfoById(merchantsInfoDto);
            return new BaseResult<MerchantsInfoExcution>(1, merchantsInfoExcution);
        } catch (FindDatabaseException e) {
            MerchantsInfoExcution merchantsInfoExcution = new MerchantsInfoExcution(MerchantsInfoEnum.INQUIRE_ERROR);
            return new BaseResult<MerchantsInfoExcution>(0,merchantsInfoExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantsInfoExcution>(0, e.getMessage());
        }
    }

    /**
     * 确认员工爽约
     * @param merchantsAffirmStudentBreakPromiseDto
     * @return
     */
    @RequestMapping(value = "/affirmStuBaa",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantsAffirmStudentBreakPromiseExcution> affirmStuBaa(@RequestBody MerchantsAffirmStudentBreakPromiseDto merchantsAffirmStudentBreakPromiseDto){
        //参数验空
        try {
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = merchantsInfoService.confirmStudentMiss(merchantsAffirmStudentBreakPromiseDto);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(1,merchantsAffirmStudentBreakPromiseExcution);
        }catch (UpdateInnerErrorException e){
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.AFFIRM_STUDENT_BREAK_PROMISE_FAIL);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(0,merchantsAffirmStudentBreakPromiseExcution);
        }catch (QueryInnerErrorException e){
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.FIND_DOUBLEID_FAIL);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(0,merchantsAffirmStudentBreakPromiseExcution);
        }catch (UpdateDatabaseException e){
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.OVER_WORK_FAIL);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(0,merchantsAffirmStudentBreakPromiseExcution);
        }catch (UpdateStuMissException e){
            MerchantsAffirmStudentBreakPromiseExcution merchantsAffirmStudentBreakPromiseExcution = new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.UPDATE_STUDENT_MISS_NUMBER_FAIL);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(0,merchantsAffirmStudentBreakPromiseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<MerchantsAffirmStudentBreakPromiseExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示商户申请VIP页面
     * @return
     */
    @RequestMapping(value = "/showApplyVipPage",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showApplyVipPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("applyVIP/showApplyVipPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询申请VIP商户信息
     * @param merchantsUpgradeDto
     * @return
     */
    @RequestMapping(value = "/GetApplyVipInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantsUpgradeExcution> findApplyVipShopInfo (@RequestBody MerchantsUpgradeDto merchantsUpgradeDto){
        try {
           MerchantsUpgradeExcution merchantsUpgradeExcution = merchantsInfoService.findApplyVipShopList(merchantsUpgradeDto);
            return new BaseResult<MerchantsUpgradeExcution>(1,merchantsUpgradeExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<MerchantsUpgradeExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示审核页面
     * @param merchantsUpgradeDto
     * @return
     */
    @RequestMapping(value = "/showAuditPage",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showAuditPage(@RequestBody MerchantsUpgradeDto merchantsUpgradeDto){
        ModelAndView mv = new ModelAndView();
        try {
            MerchantsUpgradeExcution applyInfo = merchantsInfoService.showAuditPage(merchantsUpgradeDto);
            mv.addObject("data1", applyInfo);
            mv.setViewName("applyVIP/AuditPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

}
