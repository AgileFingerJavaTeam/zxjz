package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.MerchantExcution;
import com.zxjz.dto.in.MerchantDto;
import com.zxjz.enums.MerchantEnum;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
@Controller
@RequestMapping("/recruitmentInfo")
public class MerchantController extends BaseController {
    @Autowired
      private MerchantService merchantService;

    @RequestMapping(value = "/postBoutiqueDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findMerchant(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseAPIResult(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantExcution merchantExcution = new MerchantExcution(MerchantEnum.FIND_ERROR, e.getMessage());
            return new BaseAPIResult(0,merchantExcution);
        }
    }

    @RequestMapping(value = "/postGeneralParticu",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findGuaRec(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseAPIResult(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantExcution merchantExcution = new MerchantExcution(MerchantEnum.FIND_ERROR, e.getMessage());
            return new BaseAPIResult(0,merchantExcution);
        }
    }

    @RequestMapping(value = "/postMerchantinfor",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findMerchantInfor(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseAPIResult(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantExcution merchantExcution = new MerchantExcution(MerchantEnum.FIND_ERROR, e.getMessage());
            return new BaseAPIResult(0,merchantExcution);
        }
    }
}
