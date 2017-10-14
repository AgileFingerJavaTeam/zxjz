package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.JobDetailsExcution;
import com.zxjz.dto.excution.MerchantCommentExcution;
import com.zxjz.dto.excution.SystemParameterExcution;
import com.zxjz.dto.in.SystemParameterDto;
import com.zxjz.enums.JobDetailsEnum;
import com.zxjz.enums.MerchantCommentEnum;
import com.zxjz.enums.SystemParameterEnum;
import com.zxjz.exception.FindDatabaseException;
import com.zxjz.exception.FindJobException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "SystemApi")
public class SystemParameterController extends BaseController {
    @Autowired
    private SystemParameterService systemParameterService;

    /**
     * 是否需要更新
     * @param
     * @return
     */
    @RequestMapping(value = "/isUpdateAPP",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
//    ----------是否需要更新APP
    public BaseResult<SystemParameterExcution> isUpdateAPP(){
        //参数验空
        try {
            SystemParameterExcution systemParameterExcution = systemParameterService.isUpdateAPP();
            return new BaseResult<SystemParameterExcution>(1,systemParameterExcution);
        }catch (QueryInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.QUERY_FAIL);
            return new BaseResult<SystemParameterExcution>(0, systemParameterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<SystemParameterExcution>(0,e.getMessage());
        }
    }

    /**
     * 商家对学生发表评价
     * @param systemParameterDto
     * @return
     */

    @RequestMapping(value = "/evaluate",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantCommentExcution> evaluate(@RequestBody SystemParameterDto systemParameterDto){
        //参数验空
        try {
            MerchantCommentExcution merchantCommentExcution = systemParameterService.evaluateStudent(systemParameterDto);
            BaseResult<MerchantCommentExcution> ret = new BaseResult<MerchantCommentExcution>(1,merchantCommentExcution);
            return new BaseResult<MerchantCommentExcution>(1,merchantCommentExcution);
        }catch (InsertInnerErrorException e){
            MerchantCommentExcution merchantCommentExcution = new MerchantCommentExcution(MerchantCommentEnum.ADD_EVALUATE_FORETABLE_FAIL);
            return new BaseResult<MerchantCommentExcution>(0,merchantCommentExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<MerchantCommentExcution>(0,e.getMessage());
        }
    }

    /**
     * 查询职位详情
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/JobDetails",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
// ---------查询职位详情
    public BaseResult<JobDetailsExcution> JobDetails(SystemParameterDto systemParameterDto){
        //参数验空
        try {
            JobDetailsExcution jobDetailsExcution = systemParameterService.jobDetails(systemParameterDto);
            return new BaseResult<JobDetailsExcution>(1,jobDetailsExcution);
        }catch (QueryInnerErrorException e){
            JobDetailsExcution jobDetailsExcution = new JobDetailsExcution(JobDetailsEnum.QUERY_STATUS_FAIL);
            return new BaseResult<JobDetailsExcution>(0,jobDetailsExcution);
        }catch (FindDatabaseException e){
            JobDetailsExcution jobDetailsExcution = new JobDetailsExcution(JobDetailsEnum.QUERY_PASSEDJOB_FAIL);
            return new BaseResult<JobDetailsExcution>(0,jobDetailsExcution);
        }catch (FindJobException e){
            JobDetailsExcution jobDetailsExcution = new JobDetailsExcution(JobDetailsEnum.QUERY_OTHERJOB_FAIL);
            return new BaseResult<JobDetailsExcution>(0,jobDetailsExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
      //      JobDetailsExcution jobDetailsExcution = new JobDetailsExcution(JobDetailsEnum.UNKNOW_ERROR);
            return new BaseResult<JobDetailsExcution>(0,e.getMessage());
        }
    }
}
