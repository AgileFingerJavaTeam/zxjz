package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.StuWalletExcution;
import com.zxjz.dto.excution.StuWalletIncomeExcution;
import com.zxjz.dto.excution.StuWalletWithdrawExcution;
import com.zxjz.dto.in.StuWalletDto;
import com.zxjz.dto.in.StuWalletIncomeDto;
import com.zxjz.dto.in.StuWalletWithdrawDto;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.WalletIncomeEnum;
import com.zxjz.enums.WalletWithdrawEnum;
import com.zxjz.exception.InsertInnerErrorException;
import com.zxjz.exception.QueryInnerErrorException;
import com.zxjz.service.StuWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("walletApi")
public class StuWalletController extends BaseController {
    @Autowired
    private StuWalletService stuWalletService;

    @RequestMapping(value = "balance",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StuWalletExcution> walletbalance(@RequestBody StuWalletDto stuWalletDto){
        try{
            StuWalletExcution stuWalletExcution = stuWalletService.walletbalance(stuWalletDto);
            return new BaseResult<StuWalletExcution>(1,stuWalletExcution);
        }catch (QueryInnerErrorException q){
            StuWalletExcution stuWalletExcution = new StuWalletExcution(StuWalletEnum.FAIL);
            return new BaseResult<StuWalletExcution>(0,stuWalletExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StuWalletExcution>(0,e.getMessage());
        }
    }
    @RequestMapping(value = "income",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StuWalletIncomeExcution> income(@RequestBody StuWalletIncomeDto stuWalletIncomeDto){
        try{
            StuWalletIncomeExcution stuWalletIncomeExcution = stuWalletService.income(stuWalletIncomeDto);
            return new BaseResult<StuWalletIncomeExcution>(1,stuWalletIncomeExcution);
        }catch (QueryInnerErrorException q){
            StuWalletIncomeExcution stuWalletIncomeExcution = new StuWalletIncomeExcution(WalletIncomeEnum.FAIL);
            return new BaseResult<StuWalletIncomeExcution>(0,stuWalletIncomeExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StuWalletIncomeExcution>(0,e.getMessage());
        }
    }
    @RequestMapping(value = "withdraw",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StuWalletWithdrawExcution> withdraw(@RequestBody StuWalletWithdrawDto stuWalletWithdrawDto){
        try{
            StuWalletWithdrawExcution stuWalletWithdrawExcution = stuWalletService.withdraw(stuWalletWithdrawDto);
            return new BaseResult<StuWalletWithdrawExcution>(1,stuWalletWithdrawExcution);
        }catch (InsertInnerErrorException i){
            StuWalletWithdrawExcution stuWalletWithdrawExcution = new StuWalletWithdrawExcution(WalletWithdrawEnum.FAIL);
            return new BaseResult<StuWalletWithdrawExcution>(0,stuWalletWithdrawExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<StuWalletWithdrawExcution>(0,e.getMessage()
            );
        }
    }
}
