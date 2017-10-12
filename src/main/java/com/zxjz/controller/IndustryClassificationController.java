package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.service.BillListService;
import com.zxjz.service.IndustryClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/IndustryManage")
public class IndustryClassificationController extends BaseController{
    @Autowired
    private IndustryClassificationService industryClassificationService;

    @RequestMapping(value = "showIndustryPage",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showIndustryPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("carousel/showIndustryPage");  //jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }
}
