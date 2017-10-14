package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.RecruitApprovalDto;
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

@Controller
@RequestMapping("/approval")
public class RecruitApprovalController extends BaseController{
    @Autowired
    private RecruitApprovalService recruitApprovalService;
    @RequestMapping(value = "/getinfoList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitApprovalExcution> findApprovalList(@Validated @RequestBody RecruitApprovalDto recruitApprovalDto){
        ModelAndView mv = new ModelAndView();
        try{
            RecruitApprovalExcution recruitApprovalExcution=recruitApprovalService.findApprovalList(recruitApprovalDto);
            RecruitApprovalExcution total=recruitApprovalService.findTotal(recruitApprovalDto);

        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitApprovalExcution>(0,e.getMessage());
        }
        return null;
    }

}
