package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.ConfirmRejectionExcution;
import com.zxjz.dto.in.ConfirmRejectionDto;
import com.zxjz.enums.ConfirmRejectionEnum;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.ConfirmRejectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ConfirmRejection")
public class ConfirmRejectionController extends BaseController{
    @Autowired
    private ConfirmRejectionService confirmRejectionService;

    @RequestMapping(value = "postDetailsPage",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult postDetailsPage(ConfirmRejectionDto confirmRejectionDto){
        //参数验空
        try {
            ConfirmRejectionExcution confirmRejectionExcution = confirmRejectionService.updateConReject(confirmRejectionDto);
            return new BaseAPIResult(1,confirmRejectionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ConfirmRejectionExcution confirmRejectionExcution = new ConfirmRejectionExcution(ConfirmRejectionEnum.HIRED_ERROR, e.getMessage());
            return new BaseAPIResult(0,confirmRejectionExcution);
        }
    }
}
