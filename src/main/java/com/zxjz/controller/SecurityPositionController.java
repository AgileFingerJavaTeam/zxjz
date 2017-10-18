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
     * @param atSecurityPositionDto
     * @return
     */
    @RequestMapping(value = "/getSecurityPositionUpdate",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getSecurityPositionUpdate( AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.updateSecurityPosition(atSecurityPositionDto);
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
