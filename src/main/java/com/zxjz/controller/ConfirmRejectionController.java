package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.excution.ConfirmRejectionExcution;
import com.zxjz.dto.in.BillListDto;
import com.zxjz.dto.in.ConfirmRejectionDto;
import com.zxjz.service.BillListService;
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
    public BaseResult<ConfirmRejectionExcution> postDetailsPage(ConfirmRejectionDto confirmRejectionDto){
        //参数验空
        try {
            ConfirmRejectionExcution confirmRejectionExcution = confirmRejectionService.updateConReject(confirmRejectionDto);
            return new BaseResult<ConfirmRejectionExcution>(1,confirmRejectionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<ConfirmRejectionExcution>(0,e.getMessage());
        }
    }
}
