package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.excution.PendingTreatmentExcution;
import com.zxjz.dto.in.BillListDto;
import com.zxjz.dto.in.PendingTreatmentDto;
import com.zxjz.service.BillListService;
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
    public BaseResult<PendingTreatmentExcution> postGetInterface(PendingTreatmentDto pendingTreatmentDto){
        //参数验空
        try {
            PendingTreatmentExcution pendingTreatmentExcution = pendingTreatmentService.findPendingTreatment(pendingTreatmentDto);
            return new BaseResult<PendingTreatmentExcution>(1,pendingTreatmentExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<PendingTreatmentExcution>(0,e.getMessage());
        }
    }
}
