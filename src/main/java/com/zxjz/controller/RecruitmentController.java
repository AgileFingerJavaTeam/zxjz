package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.dto.in.PaypsdDto;
import com.zxjz.dto.in.RecruitmentDto;
import com.zxjz.enums.RecruitmentEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Administrator on 2017/9/29 0029.
 */
@Controller
@RequestMapping("/recruitmentmsgApi")
public class RecruitmentController extends BaseController {
    @Autowired
    private RecruitmentService recruitmentService;




    @RequestMapping(value = "/recruitment",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult recruitment(@Validated @RequestBody PaypsdDto paypsdDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.tradingRecord(paypsdDto);
            return new BaseAPIResult(1,recruitmentExcution);
        } catch (QueryInnerErrorException q){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }

    @RequestMapping(value = "/checkbill",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult checkbill(@Validated @RequestBody CheckBillDto checkBillDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.checkBill(checkBillDto);
            return new BaseAPIResult(1,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution =new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }



    @RequestMapping(value = "/setpaypsd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult setpaypsd(@Validated @RequestBody PaypsdDto paypsdDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.setpaypsd(paypsdDto);
            return new BaseAPIResult(1,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution =new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }


    @RequestMapping(value = "/PostJob",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult PostJob(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postjob(recruitmentDto);
            return new BaseAPIResult(1,recruitmentExcution);
        } catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution =new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }


    @RequestMapping(value = "/PostJobcopy",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult PostJobcopy(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postjobcopy(recruitmentDto);
            return new BaseAPIResult(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }


    @RequestMapping(value = "/editDraft",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult editPostjobCopy(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.editpostjobcopy(recruitmentDto);
            return new BaseAPIResult(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }


    @RequestMapping(value = "/editJob",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult editJob(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.editJob(recruitmentDto);
            return new BaseAPIResult(1,recruitmentExcution);
        } catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }


    @RequestMapping(value = "/postFailure",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult postfailure(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postfailure(recruitmentDto);
            return new BaseAPIResult(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseAPIResult(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,recruitmentExcution);
        }
    }

}
