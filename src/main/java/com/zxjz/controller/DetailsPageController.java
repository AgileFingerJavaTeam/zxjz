package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.DetailsPageExcution;
import com.zxjz.dto.in.DetailsPageDto;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;
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
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getBills(DetailsPageDto detailsPageDto){
        //参数验空
        try {
            DetailsPageExcution detailsPageExcution = detailsPageService.getDetailsPage(detailsPageDto);
            return new BaseAPIResult(1,detailsPageExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            DetailsPageExcution detailsPageExcution = new DetailsPageExcution(e.getMessage(), CityEnum.FIND_ERROR);
            return new BaseAPIResult(0,detailsPageExcution);
        }
    }
}
