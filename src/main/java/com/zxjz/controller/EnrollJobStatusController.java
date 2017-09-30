package com.zxjz.controller;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseException;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.EnrollJobStatusExcution;
import com.zxjz.dto.excution.QuickSignUpExcution;
import com.zxjz.dto.excution.UpdateJobStatusExcution;
import com.zxjz.dto.excution.WhetherAdmissionExcution;
import com.zxjz.dto.in.EnrollJobStatusDto;
import com.zxjz.dto.in.QuickSignUpDto;
import com.zxjz.dto.in.UpdateJobStatusDto;
import com.zxjz.dto.in.WhetherAdmissionDto;
import com.zxjz.enums.EnrollJobStatusEnum;
import com.zxjz.exception.EnrollJobStatusException;
import com.zxjz.exception.WhetherAdmissionException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.EnrollJobStatusService;
import com.zxjz.service.WhetherAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
@Controller
@RequestMapping("/EnrollApi")
public class EnrollJobStatusController extends BaseController {
    @Autowired
    private EnrollJobStatusService enrollJobStatusService;
    @Autowired
    private WhetherAdmissionService whetherAdmissionService;

    @RequestMapping(value = "/EnrollJobStatus",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<EnrollJobStatusExcution> FindEnrollJobStatus(@RequestBody EnrollJobStatusDto enrollJobStatusDto) {
        //参数验空
        try {
            EnrollJobStatusExcution enrollJobStatusExcution = enrollJobStatusService.findEnrollJobStatus(enrollJobStatusDto);
            return new BaseResult<EnrollJobStatusExcution>(1,enrollJobStatusExcution);
        }catch (QueryInnerErrorException e) {
             EnrollJobStatusExcution enrollJobStatusExcution = new EnrollJobStatusExcution(EnrollJobStatusEnum.FIND_ENROLLJOBSTATUS_FAIL);
            return new BaseResult<EnrollJobStatusExcution>(0,enrollJobStatusExcution);
        }
         catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<EnrollJobStatusExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/UpdateSelectStatus",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<UpdateJobStatusExcution> UpdateSelectStatus(@RequestBody UpdateJobStatusDto updateJobStatusDto) {
        //参数验空
        try {
            UpdateJobStatusExcution updateJobStatusExcution = enrollJobStatusService.updateJobStatus(updateJobStatusDto);
            return new BaseResult<UpdateJobStatusExcution>(1,updateJobStatusExcution);
        }catch (EnrollJobStatusException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdateJobStatusExcution>(0,e.getMessage());
        }
        catch (QueryInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdateJobStatusExcution>(0,e.getMessage());
        }
        catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdateJobStatusExcution>(0,e.getMessage());
        }
        catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdateJobStatusExcution>(0,e.getMessage());
        }
        catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<UpdateJobStatusExcution>(0,e.getMessage());
        }
    }



    @RequestMapping(value = "/getEnrollInformation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<QuickSignUpExcution> QuickSignUp(@RequestBody QuickSignUpDto quickSignUpDto) {
        //参数验空
        try {
            QuickSignUpExcution quickSignUpExcution = enrollJobStatusService.quickSignUp(quickSignUpDto);
            return new BaseResult<QuickSignUpExcution>(1,quickSignUpExcution);
        }catch (EnrollJobStatusException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<QuickSignUpExcution>(0,e.getMessage());
        }
         catch (QueryInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<QuickSignUpExcution>(0,e.getMessage());
        }
         catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<QuickSignUpExcution>(0,e.getMessage());
        }
        catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<QuickSignUpExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/Admission",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<WhetherAdmissionExcution> Admission(@RequestBody WhetherAdmissionDto whetherAdmissionDto) {
        //参数验空
        try {
            WhetherAdmissionExcution whetherAdmissionExcution = whetherAdmissionService.whetherAdmission(whetherAdmissionDto);
            return new BaseResult<WhetherAdmissionExcution>(1,whetherAdmissionExcution);
        }catch (WhetherAdmissionException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<WhetherAdmissionExcution>(0,e.getMessage());
        }
        catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<WhetherAdmissionExcution>(0,e.getMessage());
        }
        catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<WhetherAdmissionExcution>(0,e.getMessage());
        }
    }
}
