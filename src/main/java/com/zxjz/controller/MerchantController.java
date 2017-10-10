package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.MerchantExcution;
import com.zxjz.dto.in.MerchantDto;
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
    public BaseResult<MerchantExcution> findMerchant(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseResult<MerchantExcution>(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/postGeneralParticu",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantExcution> findGuaRec(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseResult<MerchantExcution>(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/postMerchantinfor",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<MerchantExcution> findMerchantInfor(@RequestBody MerchantDto merchantDto) {
        //参数验空
        try {
            MerchantExcution merchantExcution = merchantService.merchant(merchantDto);
            return new BaseResult<MerchantExcution>(1,merchantExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<MerchantExcution>(0,e.getMessage());
        }
    }
}
