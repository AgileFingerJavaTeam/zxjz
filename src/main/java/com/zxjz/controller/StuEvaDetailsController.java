package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.StuEvaDetailsExcution;
import com.zxjz.dto.excution.StuPersonalExcution;
import com.zxjz.dto.in.StuEvaDetailsDto;
import com.zxjz.dto.in.StuPersonalDto;
import com.zxjz.service.StuEvaDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StuEvaDetails")
public class StuEvaDetailsController extends BaseController{
    @Autowired
    private StuEvaDetailsService stuEvaDetailsService;

    /**
     * 获取学生总评价
     * @param stuPersonalDto
     * @return
     */
    @RequestMapping(value = "postStuGenEvaluation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StuPersonalExcution> postStuGenEvaluation(@RequestBody StuPersonalDto stuPersonalDto){
        //参数验空
        try{
            StuPersonalExcution stuPersonalExcution = stuEvaDetailsService.findStuPersonal(stuPersonalDto);
            return new BaseResult<StuPersonalExcution>(1,stuPersonalExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StuPersonalExcution>(0,e.getMessage());
        }

    }

    /**
     * 获取学生评价详情
     * @param stuEvaDetailsDto
     * @return
     */
    @RequestMapping(value = "postStuEvaDetails",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StuEvaDetailsExcution> postStuEvaDetails(@RequestBody StuEvaDetailsDto stuEvaDetailsDto){
        //参数验空
        try{
            StuEvaDetailsExcution stuEvaDetailsExcution = stuEvaDetailsService.findStuEvaDetails(stuEvaDetailsDto);
            return new BaseResult<StuEvaDetailsExcution>(1,stuEvaDetailsExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StuEvaDetailsExcution>(0,e.getMessage());
        }

    }
}
