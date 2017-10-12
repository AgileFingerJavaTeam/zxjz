package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
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
    public BaseResult<RecruitmentExcution> recruitment(@Validated @RequestBody PaypsdDto paypsdDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.tradingRecord(paypsdDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        } catch (QueryInnerErrorException q){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/checkbill",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> checkbill(@Validated @RequestBody CheckBillDto checkBillDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.checkBill(checkBillDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }



    @RequestMapping(value = "/setpaypsd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> setpaypsd(@Validated @RequestBody PaypsdDto paypsdDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.setpaypsd(paypsdDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/PostJob",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> PostJob(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postjob(recruitmentDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        } catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/PostJobcopy",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> PostJobcopy(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postjobcopy(recruitmentDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/editDraft",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> editPostjobCopy(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.editpostjobcopy(recruitmentDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/editJob",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> editJob(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.editJob(recruitmentDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        } catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/postFailure",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<RecruitmentExcution> postfailure(@Validated @RequestBody RecruitmentDto recruitmentDto){
        //参数验空
        try {
            RecruitmentExcution recruitmentExcution = recruitmentService.postfailure(recruitmentDto);
            return new BaseResult<RecruitmentExcution>(1,recruitmentExcution);
        }  catch (InsertInnerErrorException i){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        } catch (UpdateInnerErrorException u){
            RecruitmentExcution recruitmentExcution = new RecruitmentExcution(RecruitmentEnum.FAIL);
            return new BaseResult<RecruitmentExcution>(0,recruitmentExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<RecruitmentExcution>(0,e.getMessage());
        }
    }

}
