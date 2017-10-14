package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.JobListExcution;
import com.zxjz.dto.excution.StationListExcution;
import com.zxjz.dto.in.JobListDto;
import com.zxjz.service.StationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationListExcution> getListStation(){
        //参数验空
        try{
            StationListExcution stationListExcution = stationListService.getStationList();
            return new BaseResult<StationListExcution>(1,stationListExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StationListExcution>(0,e.getMessage());
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
    public BaseResult<JobListExcution> getListStation(JobListDto jobListDto){
        //参数验空
        try{
            JobListExcution jobListExcution = stationListService.getJobList(jobListDto);
            return new BaseResult<JobListExcution>(1,jobListExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<JobListExcution>(0,e.getMessage());
        }

    }
}
