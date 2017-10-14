package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
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
    public BaseAPIResult setPhoneNo(@RequestBody StudentSetBoundPhoneDto studentSetBoundPhoneDto){
        System.out.println("----------------");
        //参数验空
        try {
            StudentSetBoundPhoneExcution studentSetBoundPhoneExcution = studentSetBoundPhoneService.setBoundPhone(studentSetBoundPhoneDto);
            return new BaseAPIResult(1,studentSetBoundPhoneExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            StudentSetBoundPhoneExcution studentSetBoundPhoneExcution = new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.BOUND_FAIL);
            return new BaseAPIResult(0,studentSetBoundPhoneExcution);
        }
    }
}
