package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.JobListExcution;
import com.zxjz.dto.excution.StationListExcution;
import com.zxjz.dto.in.JobListDto;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.StationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StationList")
public class StationListController extends BaseController{
    @Autowired
    private StationListService stationListService;

    /**
     * 获取职位管理
     * @param
     * @return
     */
    @RequestMapping(value = "getListStation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getListStation(){
        //参数验空
        try{
            StationListExcution stationListExcution = stationListService.getStationList();
            return new BaseAPIResult(1,stationListExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            StationListExcution stationListExcution = new StationListExcution(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,stationListExcution);
        }

    }

    /**
     * 根据条件获取职位列表
     * @param
     * @return
     */
    @RequestMapping(value = "getJoblist",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getListStation(@RequestBody JobListDto jobListDto){
        //参数验空
        try{
            JobListExcution jobListExcution = stationListService.getJobList(jobListDto);
            return new BaseAPIResult(1,jobListExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            JobListExcution jobListExcution = new JobListExcution(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,jobListExcution);
        }

    }
}
