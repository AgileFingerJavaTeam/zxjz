package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.exception.db.InsertInnerErrorException;
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
@RequestMapping("/securityPosition")
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

    /*
     * 显示页面数据2
     */
    @RequestMapping(value = "/getSecurityPositionList2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SecurityPositionExcution> getSecurityPositionList2(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList2(securityPositionDto);
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

    /*
     * 添加框查看 遍历商户名称
     */
    @RequestMapping(value = "/SaddAT",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SecurityPositionExcution> findListMarchantName() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListMarchantName();
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }

    /*
   * 添加框查看 遍历商户名称
   */
    @RequestMapping(value = "/SaddATT",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SecurityPositionExcution> findListStation() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListStation();
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/SaddATT2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SecurityPositionExcution> findListTwoLevelStation(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListTwoLevelStation(securityPositionDto);
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }

    /**
     * 添加
     * @param atSecurityPositionDto
     * @return
     */
    @RequestMapping(value = "/getSecurityPositionAdd",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<AtSecurityPositionExcution> SecurityPositionAdd(@RequestBody AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.insertSecurityPosition(atSecurityPositionDto);
            return new BaseResult<AtSecurityPositionExcution>(1,atSecurityPositionExcution);
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<AtSecurityPositionExcution>(0,e.getMessage());
        }
         catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<AtSecurityPositionExcution>(0,e.getMessage());
        }
    }

    /**
     * 系统参数详情页面
     * @return
     */
    @RequestMapping(value = "/editAT")
    public ModelAndView editAT(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findSecurityPositionHref(securityPositionDto);
            mv.addObject("data", securityPositionExcution.getAtCollection());
            mv.setViewName("guaranteejob/editAT");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑
     * @param atSecurityPositionDto
     * @return
     */
    @RequestMapping(value = "/getSecurityPositionUpdate",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<AtSecurityPositionExcution> getSecurityPositionUpdate(@RequestBody AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.updateSecurityPosition(atSecurityPositionDto);
            return new BaseResult<AtSecurityPositionExcution>(1,atSecurityPositionExcution);
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<AtSecurityPositionExcution>(0,e.getMessage());
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<AtSecurityPositionExcution>(0,e.getMessage());
        }
    }

    /**
     * 地图页面
     * @return
     */
    @RequestMapping(value ="/Map")
    public ModelAndView Map(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("guaranteejob/map");
        return mv;
    }

    /*
	 * 模糊查询
	 */
    @RequestMapping(value = "/search", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseResult<SecurityPositionExcution> search(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findSearch(securityPositionDto);
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }

    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseResult<SecurityPositionExcution> StatusSearch(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch(securityPositionDto);
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }
    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch2", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public BaseResult<SecurityPositionExcution> StatusSearch2(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch2(securityPositionDto);
            return new BaseResult<SecurityPositionExcution>(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<SecurityPositionExcution>(0,e.getMessage());
        }
    }
}
