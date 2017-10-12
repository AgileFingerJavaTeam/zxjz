package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.service.CheckBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/CheckBill")
public class CheckBillController extends BaseController {
    @Autowired
    private CheckBillService checkBillService;

    /**
     * 显示往来对账页面
     * @return
     */
    @RequestMapping(value = "/showBillPage",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showBillPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("checkBill/showBillPage");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }
    @RequestMapping(value = "/findBills",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public
}
