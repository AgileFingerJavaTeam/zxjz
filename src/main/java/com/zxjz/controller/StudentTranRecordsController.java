package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.StudentTranRecordsExcution;
import com.zxjz.dto.in.StudentTranRecordsDto;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.StudentTranRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StudentTranRecords")
public class StudentTranRecordsController extends BaseController{
    @Autowired
    private StudentTranRecordsService studentTranRecordsService;

    @RequestMapping(value = "postStudentTranRecords",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult postStudentTranRecords(@RequestBody StudentTranRecordsDto studentTranRecordsDto){
        //参数验空
        try {
            StudentTranRecordsExcution studentTranRecordsExcution = studentTranRecordsService.getStudentTranRecords(studentTranRecordsDto);
            return new BaseAPIResult(1,studentTranRecordsExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            StudentTranRecordsExcution studentTranRecordsExcution = new StudentTranRecordsExcution(e.getMessage(), CityEnum.FIND_ERROR);
            return new BaseAPIResult(0,studentTranRecordsExcution);
        }
    }
}
