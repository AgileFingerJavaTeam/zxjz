package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.in.StuJobDto;
import com.zxjz.enums.StuJobEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.StuJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("myjobApi")
public class StuJobController extends BaseController {
    @Autowired
    private StuJobService stuJobService;

    @RequestMapping(value = "myjob",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult stujob(@RequestBody StuJobDto stuJobDto){
        try{
            StuJobExcution stuJobExcution = stuJobService.stuJob(stuJobDto);
            return new BaseAPIResult(1,stuJobExcution);
        }catch (QueryInnerErrorException q){
            StuJobExcution stuJobExcution = new StuJobExcution(StuJobEnum.FAIL);
            return new BaseAPIResult(0,stuJobExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            StuJobExcution stuJobExcution = new StuJobExcution(StuJobEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,stuJobExcution);
        }
    }


    @RequestMapping(value = "myjoblist",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult stujoblist(@RequestBody StuJobDto stuJobDto){
        try{
            StuJobExcution stuJobExcution = stuJobService.stuJobList(stuJobDto);
            return new BaseAPIResult(1,stuJobExcution);
        }catch (QueryInnerErrorException q){
            StuJobExcution stuJobExcution = new StuJobExcution(StuJobEnum.FAIL);
            return new BaseAPIResult(0,stuJobExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            StuJobExcution stuJobExcution = new StuJobExcution(StuJobEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,stuJobExcution);
        }
    }
}
