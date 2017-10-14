package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CityList")
public class CityController extends BaseController{
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "getCityList",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CityExcution> CityList(){
        //参数验空
        try {
            CityExcution cityExcution = cityService.getCity();
            return new BaseResult<CityExcution>(1,cityExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<CityExcution>(0,e.getMessage());
        }
    }
}
