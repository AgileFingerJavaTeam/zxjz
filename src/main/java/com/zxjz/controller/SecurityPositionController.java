package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.service.SecurityPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Controller
@RequestMapping("securityPosition")
public class SecurityPositionController extends BaseController{
   @Autowired
   private SecurityPositionService securityPositionService;

    /**
     * 显示页面
     * @return
     */
        @RequestMapping(value = "/SecurityPosition")
        public ModelAndView showCarousePage() {
            ModelAndView mv = new ModelAndView();
            try {
                mv.setViewName("guaranteejob/at_security_position");
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
              return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
          } catch (Exception e) {
              logger.error(e.getMessage(), e);
              return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
          }
      }

    /**
     * 系统参数详情页面
     * @return
     */
    @RequestMapping(value = "/showSecurity")
    public ModelAndView showSecurity(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPosition(securityPositionDto);
            mv.addObject("info",securityPositionExcution.getAtCollection());
            mv.addObject("info1",securityPositionExcution.getMap());
            mv.setViewName("guaranteejob/showSecurity");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 添加系统参数页面
     * @return
     */
    @RequestMapping(value ="/addAT")
    public ModelAndView addAT(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("guaranteejob/addAT");
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }
}
