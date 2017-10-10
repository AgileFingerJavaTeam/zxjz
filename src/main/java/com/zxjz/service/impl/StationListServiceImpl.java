package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StationListDao;
import com.zxjz.dto.excution.JobListExcution;
import com.zxjz.dto.excution.StationListExcution;
import com.zxjz.dto.in.JobListDto;
import com.zxjz.entity.JobList;
import com.zxjz.entity.StationList;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.StationListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StationListServiceImpl implements StationListService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StationListDao stationListDao;



    public StationListExcution getStationList() {
        try{
            List<StationList> getStationList = stationListDao.getStationList();
            for (int i = 0; i < getStationList.size(); i++){
                int stationId = getStationList.get(i).getStationId();
                List<StationList> getChildrenStationList = stationListDao.getchildrenStationList(stationId);
                if (getChildrenStationList != null){
                    getStationList.get(i).setChildren(getChildrenStationList);
                }
            }
            return new StationListExcution(getStationList, StuPersonalEnum.FIND_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    public JobListExcution getJobList(JobListDto jobListDto) {
        int getSelectType = jobListDto.getSelectType();
        String getStarJob = jobListDto.getStarJob();
        String getCityType = jobListDto.getCityType();
        String getJobType = jobListDto.getJobType();
        String getOrderType = jobListDto.getOrderType();
        String getPaymentType = jobListDto.getPaymentType();
        String getSex = jobListDto.getSex();
        String sexStr = "";
        if (jobListDto.getSex().equals("1")){
            sexStr = "男";
        }else if (jobListDto.getSex().equals("2")){
            sexStr = "女";
        }
        String paymentTypeStr = "";
        if (jobListDto.getPaymentType().equals("0")){
            paymentTypeStr ="日结";
        }else if (jobListDto.getPaymentType().equals("1")){
            paymentTypeStr ="周结";
        }else if (jobListDto.getPaymentType().equals("2")) {
            paymentTypeStr ="月结";
        }else{
            paymentTypeStr ="完工结算";
        }
        try{
            List<JobList> list = stationListDao.getJobList(getSelectType,getSex,sexStr,
                    getStarJob,getCityType,getJobType,getPaymentType,paymentTypeStr,getOrderType);
            return new JobListExcution(list, StuPersonalEnum.FIND_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
