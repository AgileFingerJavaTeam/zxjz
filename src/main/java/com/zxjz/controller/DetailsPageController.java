package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.excution.DetailsPageExcution;
import com.zxjz.dto.in.BillListDto;
import com.zxjz.dto.in.DetailsPageDto;
import com.zxjz.service.DetailsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/DetailsPage")
public class DetailsPageController extends BaseController{
    @Autowired
    private DetailsPageService detailsPageService;

    @RequestMapping(value = "postDetailsPage",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<DetailsPageExcution> getBills(DetailsPageDto detailsPageDto){
        //参数验空
        try {
            DetailsPageExcution detailsPageExcution = detailsPageService.getDetailsPage(detailsPageDto);
            return new BaseResult<DetailsPageExcution>(1,detailsPageExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<DetailsPageExcution>(0,e.getMessage());
        }
    }
}
