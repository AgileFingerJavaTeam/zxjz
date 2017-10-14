package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.PendingTreatmentExcution;
import com.zxjz.dto.in.PendingTreatmentDto;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.PendingTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/GetInterface")
public class PendingTreatmentController extends BaseController {
    @Autowired
    private PendingTreatmentService pendingTreatmentService;

    @RequestMapping(value = "postGetInterface",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult postGetInterface(PendingTreatmentDto pendingTreatmentDto){
        //参数验空
        try {
            PendingTreatmentExcution pendingTreatmentExcution = pendingTreatmentService.findPendingTreatment(pendingTreatmentDto);
            return new BaseAPIResult(1,pendingTreatmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            PendingTreatmentExcution pendingTreatmentExcution = new PendingTreatmentExcution(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,pendingTreatmentExcution);
        }
    }
}
