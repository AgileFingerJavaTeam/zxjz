package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.enums.CheckBillEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
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

    /**
     * 查询商户账单信息
     * @param checkBillDto
     * @return
     */
   @RequestMapping(value = "/findBills",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CheckBillExcution> findBills(CheckBillDto checkBillDto){
        try {
            CheckBillExcution checkBillExcution = checkBillService.findBills(checkBillDto);
            return new BaseResult<CheckBillExcution>(1,checkBillExcution);
        }catch (QueryInnerErrorException e){
            CheckBillExcution checkBillExcution = new CheckBillExcution(CheckBillEnum.FIND_BILL_FAIL);
            return new BaseResult<CheckBillExcution>(0,checkBillExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<CheckBillExcution>(0,e.getMessage());
        }
   }

    /**
     * 查询商户名称
     * @param checkBillDto
     * @return
     */
   @RequestMapping(value = "/findMerName",
           method = RequestMethod.POST,
           produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CheckBillExcution> findMerName(CheckBillDto checkBillDto){
        try {
            CheckBillExcution checkBillExcution = checkBillService.findMerName(checkBillDto);
            return new BaseResult<CheckBillExcution>(1,checkBillExcution);
        }catch (QueryInnerErrorException e){
            CheckBillExcution checkBillExcution = new CheckBillExcution(CheckBillEnum.FIND_MERCHANTS_NAME_FAIL);
            return new BaseResult<CheckBillExcution>(0,checkBillExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<CheckBillExcution>(0,e.getMessage());
        }
   }

    /**
     * 显示商户往来账目详情
     * @param checkBillDto
     * @return
     */
   @RequestMapping(value = "/findMerDetails",
           method = RequestMethod.POST,
           produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView findMerDetails(CheckBillDto checkBillDto){
        ModelAndView mv = new ModelAndView();
        String reference_bill_classification = checkBillDto.getReference_bill_classification();
        String merchants_name = checkBillDto.getMerchants_name();
        try {
            if (reference_bill_classification.equals("充值")){
                CheckBillExcution checkBillExcution = checkBillService.findPayInfoById(checkBillDto);
                mv.addObject("payInfo",checkBillExcution);
                mv.setViewName("checkBill/viewRecharge");
            }else if (reference_bill_classification.equals("提现")){
                CheckBillExcution checkBillExcution = checkBillService.findWithdrawInfoById(checkBillDto);
                mv.addObject("withdrawInfo",checkBillExcution);
                mv.setViewName("checkBill/viewWithdraw");
            }else if (reference_bill_classification.equals("收费单")){
                CheckBillExcution checkBillExcution = checkBillService.findCostInfoById(checkBillDto);
                mv.addObject("costInfo",checkBillExcution);
                mv.setViewName("checkBill/viewPayforTerrace");
            }else if (reference_bill_classification.equals("平台代付工资")){
                CheckBillExcution checkBillExcution = checkBillService.findPaymentInfoById(checkBillDto);
                mv.addObject("PaymentInfo",checkBillExcution);
                mv.setViewName("checkBill/viewTerracePayforStudent");
            }
        }catch (QueryInnerErrorException e){
            CheckBillExcution checkBillExcution = new CheckBillExcution(CheckBillEnum.FIND_FAIL);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
   }
}
