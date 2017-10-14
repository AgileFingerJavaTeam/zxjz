package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.in.BillListDto;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.BillListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Bills")
public class BillListController extends BaseController{
    @Autowired
    private BillListService billListService;

    @RequestMapping(value = "getBills",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getBills(BillListDto billListDto){
        //参数验空
        try {
            BillListExcution billListExcution = billListService.getBillList(billListDto);
            return new BaseAPIResult(1,billListExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            BillListExcution billListExcution = new BillListExcution(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,billListExcution);
        }
    }
}
