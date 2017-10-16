package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;

import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.excution.CreditAndPaymentExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.dto.in.CreditAndPaymentDto;
import com.zxjz.enums.CreditEnum;
import com.zxjz.service.CheckBillService;
import com.zxjz.service.CreditAndPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/money")
public class CreditController extends BaseController {
    @Autowired
    private CreditAndPaymentService creditAndPaymentService;

    /*
	 * 显示页面
	 * */
    @RequestMapping(value = "/creditPage")
    public ModelAndView creditPage(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("credit/credit");
        return mv;
    }
   @RequestMapping(value = "/getcreditList",
           method = RequestMethod.POST,
           produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getcreditList(CreditAndPaymentDto creditAndPaymentDto){
        try {
            CreditAndPaymentExcution creditAndPaymentExcution = creditAndPaymentService.findList(creditAndPaymentDto);
            return BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CreditAndPaymentExcution creditAndPaymentExcution =new CreditAndPaymentExcution(CreditEnum.FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }
   }
    @RequestMapping(value = "/editcredit",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView editcredit(CreditAndPaymentDto creditAndPaymentDto) {
        ModelAndView mv = new ModelAndView();
        try{
            CreditAndPaymentExcution creditAndPaymentExcution=creditAndPaymentService.updateCredit(creditAndPaymentDto);
            mv.addObject("data", creditAndPaymentExcution.getData());
            mv.setViewName("credit/editcredit");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CreditAndPaymentExcution creditAndPaymentExcution =new CreditAndPaymentExcution(CreditEnum.FAIL,e.getMessage());


        }
        return mv;
    }


    @RequestMapping(value = "/payment",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView payment(CreditAndPaymentDto creditAndPaymentDto) {
        ModelAndView mv = new ModelAndView();
        try{
            CreditAndPaymentExcution creditAndPaymentExcution=creditAndPaymentService.updateCredit(creditAndPaymentDto);
            mv.addObject("data", creditAndPaymentExcution.getData());
            mv.setViewName("credit/payment");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CreditAndPaymentExcution creditAndPaymentExcution =new CreditAndPaymentExcution(CreditEnum.FAIL,e.getMessage());
        }
        return mv;
    }


    @RequestMapping(value = "/subcredit",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String subedit(CreditAndPaymentDto creditAndPaymentDto){
        try {
            CreditAndPaymentExcution creditAndPaymentExcution = creditAndPaymentService.subCredit(creditAndPaymentDto);
            return BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CreditAndPaymentExcution creditAndPaymentExcution =new CreditAndPaymentExcution(CreditEnum.FAIL,e.getMessage());

            return BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }
    }

    @RequestMapping(value = "/subpayment",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String subpayment(CreditAndPaymentDto creditAndPaymentDto){
        try {
            CreditAndPaymentExcution creditAndPaymentExcution = creditAndPaymentService.subPayment(creditAndPaymentDto);
            return BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CreditAndPaymentExcution creditAndPaymentExcution =new CreditAndPaymentExcution(CreditEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(creditAndPaymentExcution);
        }
    }
}
