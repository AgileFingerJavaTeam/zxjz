package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.HomepageGuaranteeExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.HomepageGuaranteeDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.HomepageGuaranteeService;
import com.zxjz.service.SecurityPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Controller
public class HomepageGuaranteeController extends BaseController {
    @Autowired
    private SecurityPositionService securityPositionService;
    @Autowired
    private HomepageGuaranteeService homepageGuaranteeService;
    /*
     * 显示页面
     */
    @RequestMapping(value = "/showPage")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("homepageGuarantee/homepage_guarantee");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /*
     * 显示页面数据
     */
    @RequestMapping(value = "/getSecurityPositionList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SecurityPositionExcution> getSecurityPositionList(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList(securityPositionDto);
            return new BaseResult<SecurityPositionExcution>(1, securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0, e.getMessage());
        }
    }

    /**
     * 改变首页担保状态
     * @return
     */
    @RequestMapping(value ="/upOrDownHomepageGuarantee", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseResult<HomepageGuaranteeExcution> upOrDownHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto){
        //参数验空
        try {
            HomepageGuaranteeExcution homepageGuaranteeExcution = homepageGuaranteeService.updateOrDownHomepageGuarantee(homepageGuaranteeDto);
            return new BaseResult<HomepageGuaranteeExcution>(1, homepageGuaranteeExcution);
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<HomepageGuaranteeExcution>(0, e.getMessage());
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<HomepageGuaranteeExcution>(0, e.getMessage());
        }
    }

    /**
     * 改变首页担保状态
     * @return
     */
    @RequestMapping(value ="/downHomepageGuarantee", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseResult<HomepageGuaranteeExcution> downHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto){
        //参数验空
        try {
            HomepageGuaranteeExcution homepageGuaranteeExcution = homepageGuaranteeService.updatedownHomepageGuarantee(homepageGuaranteeDto);
            return new BaseResult<HomepageGuaranteeExcution>(1, homepageGuaranteeExcution);
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<HomepageGuaranteeExcution>(0, e.getMessage());
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<HomepageGuaranteeExcution>(0, e.getMessage());
        }
    }

}
