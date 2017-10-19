package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.RecruitApprovalDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.RecruitApprovalEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.CityService;
import com.zxjz.service.RecruitApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/approval")
public class RecruitApprovalController extends BaseController{
    @Autowired
    private RecruitApprovalService recruitApprovalService;
    /**
     * 显示系统参数设置页面
     *
     * @return
     */
    @RequestMapping(value = "/showinfoPage")
    public ModelAndView showParameterPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("approval/RecruitmentInformationApproval");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }


    /**
     * 查询参数信息
     *
     * @return
     */
    @RequestMapping(value = "/getinfoList",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getinfoList(RecruitApprovalDto recruitApprovalDto) {

        try {
            RecruitApprovalExcution recruitApprovalExcution=recruitApprovalService.findApprovalList(recruitApprovalDto);
            return BaseUIResult.returnJsonEasyUI(recruitApprovalExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(recruitApprovalExcution);
        }

    }



    /**
     * 显示审核信息页面
     *
     * @return
     */
    @RequestMapping(value = "/CheckInformation",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView checkInfo(RecruitApprovalDto recruitApprovalDto) {

        ModelAndView mv = new ModelAndView();
        HttpSession session=this.getRequest().getSession();
        try {
            RecruitApprovalExcution info =recruitApprovalService.findApprovalByID(recruitApprovalDto);
            /*LandFallInfo landfall=(LandFallInfo) session.getAttribute("user");
            int employid=landfall.getEmployees_id();
            String employname=  landfall.getEmployees_name();*/
            int employid=2;
            String employname="安童";
            mv.addObject("id",employid);
            mv.addObject("name",employname);
            mv.addObject("data", info);
            mv.setViewName("approval/checkInfo");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
        }
        return mv;
    }

    /**
     * 提交审核结果
     *
     * @return
     */
    @RequestMapping(value = "/subInfo",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subInfo( RecruitApprovalDto recruitApprovalDto) {
        try {

                RecruitApprovalExcution recruitApprovalExcution=recruitApprovalService.updateRefuse(recruitApprovalDto);
                 return BaseUIResult.returnJsonMSG(1,recruitApprovalExcution,"更改成功");
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,recruitApprovalExcution,"添加失败");
        }catch (UpdateDatabaseException e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,recruitApprovalExcution,"更改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,recruitApprovalExcution,"更改失败");
        }
    }

    /**
     * 地图页面
     *
     * @return
     */
    @RequestMapping(value = "/Map")
    public ModelAndView Map() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("approval/map");
        return mv;
    }





}
