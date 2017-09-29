package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.MerchantStatusExcution;
import com.zxjz.dto.in.MerchantStatusDto;
import com.zxjz.service.MerchantStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
@Controller
@RequestMapping("/MerchantStatusApi")
public class MerchantStatusController extends BaseController {

    @Autowired
     private MerchantStatusService merchantStatusService;

    @RequestMapping(value = "/MerchantStatus",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantStatusExcution> MerchantStatus (@Validated @RequestBody MerchantStatusDto merchantStatusDto){
        //参数验空
        try {
            MerchantStatusExcution merchantStatusExcution = merchantStatusService.findMerchantStatus(merchantStatusDto);
            return new BaseResult<MerchantStatusExcution>(1,merchantStatusExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantStatusExcution>(0,e.getMessage());
        }
    }

    }

