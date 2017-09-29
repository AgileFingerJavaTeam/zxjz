package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.StudentRegistrationExcution;
import com.zxjz.dto.in.StudentRegistrationDto;
import com.zxjz.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Controller
@RequestMapping("/StudentRegistrationApi")
public class StudentRegistrationController extends BaseController{
    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @RequestMapping(value = "/StudentRegistration",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StudentRegistrationExcution> studentRegistration(@Validated @RequestBody StudentRegistrationDto studentRegistrationDto){
        //参数验空
        try {
            StudentRegistrationExcution studentRegistrationExcution = studentRegistrationService.studentRegistration(studentRegistrationDto);
            return new BaseResult<StudentRegistrationExcution>(1,studentRegistrationExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<StudentRegistrationExcution>(0,e.getMessage());
        }
    }
}
