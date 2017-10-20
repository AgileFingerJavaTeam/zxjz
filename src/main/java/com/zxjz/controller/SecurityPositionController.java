package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.enums.SecurityPositionEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.SecurityPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
          produces = {"text/json;charset=UTF-8"})
  @ResponseBody
  public String getSecurityPositionList(SecurityPositionDto securityPositionDto) {
      //参数验空
      try {
          SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList(securityPositionDto);
          return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
          SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
          return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
      }
  }

    /*
     * 显示页面数据2
     */
    @RequestMapping(value = "/getSecurityPositionList2",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getSecurityPositionList2(SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList(securityPositionDto);
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }
    }

    /**
     * 系统参数详情页面
     * @return
     */
    @RequestMapping(value = "/showSecurity",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showSecurity(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPosition(securityPositionDto);
            Map<String,Object> map = (Map<String,Object>)securityPositionExcution.getData();
            mv.addObject("data",map.get("data"));
            mv.addObject("info",map.get("info"));
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
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findListMarchantName() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListMarchantName();
            return BaseUIResult.returnJson(securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJson(securityPositionExcution);
        }
    }

    /*
   * 添加框查看 遍历商户名称
   */
    @RequestMapping(value = "/SaddATT",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findListStation() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListStation();
            return BaseUIResult.returnJson(securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJson(securityPositionExcution);
        }
    }

    @RequestMapping(value = "/SaddATT2",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findListTwoLevelStation(SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListTwoLevelStation(securityPositionDto);
            return BaseUIResult.returnJson(securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJson(securityPositionExcution);
        }
    }

    /**
     * 添加
     * @param atSecurityPositionDto
     * @return
     */
    @RequestMapping(value = "/getSecurityPositionAdd",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String SecurityPositionAdd(AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.insertSecurityPosition(atSecurityPositionDto);
            return BaseUIResult.returnJsonMSG(1,atSecurityPositionExcution,"添加成功");
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,atSecurityPositionExcution,"添加失败");
        }
         catch (Exception e) {
            logger.error(e.getMessage(), e);
             AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
             return BaseUIResult.returnJsonMSG(0,atSecurityPositionExcution,"添加失败");
        }
    }

    /**
     * 系统参数详情页面
     * @return
     */
    @RequestMapping(value = "/editAT",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView editAT(SecurityPositionDto securityPositionDto) {
        ModelAndView mv = new ModelAndView();
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findSecurityPositionHref(securityPositionDto);
            mv.addObject("data", securityPositionExcution.getData());
            mv.setViewName("guaranteejob/editAT");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑
     * @param
     * @return
     */
    @RequestMapping(value = "/getSecurityPositionUpdate",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getSecurityPositionUpdate(@RequestParam(value = "recruiting_id", required = true) Integer recruiting_id,
                                            @RequestParam(value = "post_name", required = false) String post_name,
                                            @RequestParam(value = "post_classification", required = true) Integer post_classification,
                                            @RequestParam(value = "work_date", required = true) String work_date,
                                            @RequestParam(value = "work_time", required = true) String work_time,
                                            @RequestParam(value = "work_location", required = true) String work_location,
                                            @RequestParam(value = "position_longitude", required = true) String position_longitude,
                                            @RequestParam(value = "position_latitude", required = true) String position_latitude,
                                            @RequestParam(value = "work_content", required = true) String work_content,
                                            @RequestParam(value = "salary_treatment", required = true) double salary_treatment,
                                            @RequestParam(value = "commission", required = true) double commission,
                                            @RequestParam(value = "benefits", required = true) double benefits,
                                            @RequestParam(value = "gender_requirements", required = true) String gender_requirements,
                                            @RequestParam(value = "other_requirements", required = true) String other_requirements,
                                            @RequestParam(value = "recruitment", required = true) int recruitment,
                                            @RequestParam(value = "hiring_expiration_date", required = true) String hiring_expiration_date,
                                            @RequestParam(value = "main_title", required = true) String main_title,
                                            @RequestParam(value = "subtitle", required = true) String subtitle,
                                            @RequestParam(value = "short_description", required = true) String short_description,
                                            @RequestParam(value = "page_url", required = false) MultipartFile page_url,
                                            @RequestParam(value = "first_page_carousel_url", required = false) MultipartFile first_page_carousel_url,
                                            @RequestParam(value = "main_page_url", required = false) MultipartFile main_page_url,
                                            @RequestParam(value = "details_page_introduction", required = true) String details_page_introduction,
                                            @RequestParam(value = "releases_user_id", required = true) Integer releases_user_id,
                                            @RequestParam(value = "up_down_frame", required = true) String up_down_frame
    ) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.updateSecurityPosition(recruiting_id,
            post_name,post_classification,work_date,work_time,work_location,position_longitude,position_latitude,work_content,salary_treatment,commission,benefits,
            gender_requirements,other_requirements,recruitment,hiring_expiration_date,main_title,subtitle,short_description,page_url,first_page_carousel_url,
            main_page_url,details_page_introduction,releases_user_id,up_down_frame);
            return BaseUIResult.returnJsonMSG(1,atSecurityPositionExcution,"修改成功");
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,atSecurityPositionExcution,"修改失败");
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,atSecurityPositionExcution,"修改失败");
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
    @RequestMapping(value = "/search",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String search(SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findSearch(securityPositionDto);
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }
    }

    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String StatusSearch(SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch(securityPositionDto);
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }
    }
    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch2",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String StatusSearch2(SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch(securityPositionDto);
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(securityPositionExcution);
        }
    }
}
