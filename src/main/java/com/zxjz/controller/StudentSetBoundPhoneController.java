package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.StudentSetBoundPhoneExcution;
import com.zxjz.dto.in.StudentSetBoundPhoneDto;
import com.zxjz.enums.StudentSetBoundPhoneEnum;
import com.zxjz.service.StudentSetBoundPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "userCountInfo")
public class StudentSetBoundPhoneController extends BaseController{
    @Autowired
    private StudentSetBoundPhoneService studentSetBoundPhoneService;
    @RequestMapping(value = "setPhoneNo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StudentSetBoundPhoneExcution> setPhoneNo(@RequestBody StudentSetBoundPhoneDto studentSetBoundPhoneDto){
        //参数验空
        try {
            StudentSetBoundPhoneExcution studentSetBoundPhoneExcution = studentSetBoundPhoneService.setBoundPhone(studentSetBoundPhoneDto);
            return new BaseResult<StudentSetBoundPhoneExcution>(1,studentSetBoundPhoneExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            StudentSetBoundPhoneExcution studentSetBoundPhoneExcution = new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.BIND_FAIL);
            return new BaseResult<StudentSetBoundPhoneExcution>(0,studentSetBoundPhoneExcution);
        }
    }
}
