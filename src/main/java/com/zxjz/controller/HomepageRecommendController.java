package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.HomepageRecommendExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.HomepageRecommendDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.enums.HomepageRecommendEnum;
import com.zxjz.enums.SecurityPositionEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.HomepageRecommendService;
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
@RequestMapping("/homepageRecommend")
public class HomepageRecommendController extends BaseController {
    @Autowired
    private SecurityPositionService securityPositionService;
    @Autowired
    private HomepageRecommendService homepageRecommendService;

    /*
     * 显示页面
     */
    @RequestMapping(value = "/showPage")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("homepageRecommend/homepage_recommend");
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
    public BaseAPIResult getSecurityPositionList(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList(securityPositionDto);
            return new BaseAPIResult(1, securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0, securityPositionExcution);
        }
    }

    /**
     * 显示改变首页推荐状态页面
     *
     * @return
     */
    @RequestMapping(value = "/showWeatherHomepageRecommend",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDelVIPMerchant(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPosition(securityPositionDto);
            mv.addObject("data", securityPositionExcution.getData());
            mv.setViewName("homepageRecommend/up_and_down");
        }
        catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 显示关闭首页担保状态页面
     *
     * @return
     */
    @RequestMapping(value = "/showDowmHomepageRecommend",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDowmHomepageRecommend(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPosition(securityPositionDto);
            mv.addObject("data", securityPositionExcution.getData());
            mv.setViewName("homepageRecommend/down");
        }
        catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 改变首页担保状态
     * @return
     */
    @RequestMapping(value ="/upOrDownHomepageRecommend", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult upOrDownHomepageRecommend(@RequestBody HomepageRecommendDto homepageRecommendDto){
        //参数验空
        try {
            HomepageRecommendExcution homepageRecommendExcution = homepageRecommendService.updateOrHomepageRecommend(homepageRecommendDto);
            return new BaseAPIResult(1, homepageRecommendExcution);
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HomepageRecommendExcution homepageRecommendExcution = new HomepageRecommendExcution(HomepageRecommendEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,homepageRecommendExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            HomepageRecommendExcution homepageRecommendExcution = new HomepageRecommendExcution(HomepageRecommendEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,homepageRecommendExcution);
        }
    }
    /**
     * 关闭首页担保状态
     * @return
     */
    @RequestMapping(value ="/downHomepageRecommend", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseAPIResult downHomepageRecommend(@RequestBody HomepageRecommendDto homepageRecommendDto){
        //参数验空
        try {
            HomepageRecommendExcution homepageRecommendExcution = homepageRecommendService.updateCloseHomepageRecommend(homepageRecommendDto);
            return new BaseAPIResult(1, homepageRecommendExcution);
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HomepageRecommendExcution homepageRecommendExcution = new HomepageRecommendExcution(HomepageRecommendEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,homepageRecommendExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            HomepageRecommendExcution homepageRecommendExcution = new HomepageRecommendExcution(HomepageRecommendEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,homepageRecommendExcution);
        }
    }
}
