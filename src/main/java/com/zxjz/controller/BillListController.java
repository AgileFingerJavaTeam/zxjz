package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.in.BillListDto;
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
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<BillListExcution> getBills(BillListDto billListDto){
        //参数验空
        try {
            BillListExcution billListExcution = billListService.getBillList(billListDto);
            return new BaseResult<BillListExcution>(1,billListExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<BillListExcution>(0,e.getMessage());
        }
    }
}
