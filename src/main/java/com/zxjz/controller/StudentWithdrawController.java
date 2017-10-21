package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.StudentWithdrawExcution;
import com.zxjz.dto.in.StudentWithdrawDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.StudentWithdrawEnum;
import com.zxjz.service.StudentWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/StudentWithdraw")
public class StudentWithdrawController extends BaseController{
    @Autowired
    private StudentWithdrawService studentWithdrawService;

    /**
     * 显示学生提现页面
     * @return
     */
    @RequestMapping(value = "showStudentWithdrawPage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showStudentWithdrawPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("studentWithdraw/studentWithdrawPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询学生提现列表
     * @param studentWithdrawDto
     * @return
     */
    @RequestMapping(value = "findStudentWithdrawList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findStudentWithdrawList(StudentWithdrawDto studentWithdrawDto){
        try {
            StudentWithdrawExcution studentWithdrawExcution = studentWithdrawService.findStudentWithdrawList(studentWithdrawDto);
            return BaseUIResult.returnJsonEasyUI(studentWithdrawExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            StudentWithdrawExcution studentWithdrawExcution = new StudentWithdrawExcution(StudentWithdrawEnum.FIND_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(studentWithdrawExcution);
        }
    }

    /**
     * 显示处理学生提现页面
     * @param studentWithdrawDto
     * @return
     */
    @RequestMapping(value = "showAcceptStudentWithdrawPage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showAcceptStudentWithdrawPage(StudentWithdrawDto studentWithdrawDto){
        ModelAndView mv = new ModelAndView();
        try {
            StudentWithdrawExcution studentWithdrawExcution = studentWithdrawService.findAcceptStudentWithdrawInfo(studentWithdrawDto);
            mv.addObject("data",studentWithdrawExcution);
            mv.setViewName("studentWithdraw/acceptStudentWithdrawPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 处理学生提现信息
     * @param studentWithdrawDto
     * @return
     */
    @RequestMapping(value = "disposeStudentWithdrawInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String disposeStudentWithdrawInfo(StudentWithdrawDto studentWithdrawDto){
        HttpSession session = this.getRequest().getSession();
        LandFallInfo user = (LandFallInfo) session.getAttribute("user");
        int staff_id = user.getEmployeesId();
        studentWithdrawDto.setStaff_id(staff_id);
        try {
            StudentWithdrawExcution studentWithdrawExcution = studentWithdrawService.updateStudentWithdrawStatus(studentWithdrawDto);
            return BaseUIResult.returnJsonMSG(1,studentWithdrawExcution,"处理成功");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            StudentWithdrawExcution studentWithdrawExcution = new StudentWithdrawExcution(StudentWithdrawEnum.UPDATA_STUDENT_WITHDRAW_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(studentWithdrawExcution);
        }
    }
}
