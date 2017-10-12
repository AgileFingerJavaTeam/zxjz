package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.excution.CheckStudentsExcution;
import com.zxjz.dto.in.CheckStudentsDto;
import com.zxjz.entity.CheckStudentsInfo;
import com.zxjz.enums.CheckStudentsEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.CheckStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showStuCertificationPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("stuCertification/stuCertification");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }
    @RequestMapping(value = "/getStudentInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CheckStudentsExcution> findStudentsInfo (CheckStudentsDto checkStudentsDto){
        try {
            CheckStudentsExcution checkStudentsExcution = checkStudentsService.findStudentsInfoList(checkStudentsDto);
            return new BaseResult<CheckStudentsExcution>(1,checkStudentsExcution);
        }catch (QueryInnerErrorException e){
            CheckStudentsExcution checkStudentsExcution = new CheckStudentsExcution(CheckStudentsEnum.FIND_STUDENTS_LIST_FAIL);
            return new BaseResult<CheckStudentsExcution>(0,checkStudentsExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<CheckStudentsExcution>(0,e.getMessage());
        }
    }

}
