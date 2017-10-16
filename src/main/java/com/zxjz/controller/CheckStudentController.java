package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CheckStudentsExcution;
import com.zxjz.dto.in.CheckStudentsDto;
import com.zxjz.enums.CheckStudentsEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.CheckStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/stuCertification")
public class CheckStudentController extends BaseController{
    @Autowired
    private CheckStudentsService checkStudentsService;

    /**
     * 显示审核学生列表页面
     * @return
     */
    @RequestMapping(value = "/showStuCertificationPage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showStuCertificationPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("stuCertification/stuCertification");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询学生审核列表
     * @param checkStudentsDto
     * @return
     */
    @RequestMapping(value = "/getStudentInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findStudentsInfo (CheckStudentsDto checkStudentsDto){
        try {
            CheckStudentsExcution checkStudentsExcution = checkStudentsService.findStudentsInfoList(checkStudentsDto);
            return BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }catch (QueryInnerErrorException e){
            CheckStudentsExcution checkStudentsExcution = new CheckStudentsExcution(CheckStudentsEnum.FIND_STUDENTS_LIST_FAIL);
            return BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            CheckStudentsExcution checkStudentsExcution = new CheckStudentsExcution(CheckStudentsEnum.FIND_STUDENTS_LIST_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }
    }

    /**
     * 显示学生审核详情页面
     * @param checkStudentsDto
     * @return
     */
    @RequestMapping(value = "/showAuditStuPage",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showAuditStuPage(CheckStudentsDto checkStudentsDto){
        ModelAndView mv = new ModelAndView();
        try {
            CheckStudentsExcution checkStudentsExcution = checkStudentsService.findStudentsInfoById(checkStudentsDto);
            mv.addObject("data",checkStudentsExcution);
            mv.setViewName("stuCertification/audit");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 提交审核信息
     * @param checkStudentsDto
     * @return
     */
    @RequestMapping(value = "/substudentinfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String substudentinfo(CheckStudentsDto checkStudentsDto){
        try {
            CheckStudentsExcution checkStudentsExcution = checkStudentsService.submitAudit(checkStudentsDto);
            return  BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }catch (UpdateInnerErrorException e){
            CheckStudentsExcution checkStudentsExcution = new CheckStudentsExcution(CheckStudentsEnum.CHECK_FAIL);
            return  BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            CheckStudentsExcution checkStudentsExcution = new CheckStudentsExcution(CheckStudentsEnum.CHECK_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(checkStudentsExcution);
        }
    }


}
