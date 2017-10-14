package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.enums.SecurityPositionEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.SecurityPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
              produces = {"application/json;charset=UTF-8"})
      @ResponseBody
      public BaseAPIResult getSecurityPositionList(@RequestBody SecurityPositionDto securityPositionDto) {
          //参数验空
          try {
              SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList(securityPositionDto);
              return new BaseAPIResult(1,securityPositionExcution);
          } catch (Exception e) {
              logger.error(e.getMessage(), e);
              SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
              return new BaseAPIResult(0,securityPositionExcution);
          }
      }

    /*
     * 显示页面数据2
     */
    @RequestMapping(value = "/getSecurityPositionList2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getSecurityPositionList2(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.getSecurityPositionList2(securityPositionDto);
            return new BaseAPIResult(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
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
            Map<String,Object> map = (Map<String,Object>)securityPositionExcution.getData();
            mv.addObject("info",map.get("atCollection"));
            mv.addObject("info1",map.get("maps"));
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
    public BaseAPIResult findListMarchantName() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListMarchantName();
            return new BaseAPIResult(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
        }
    }

    /*
   * 添加框查看 遍历商户名称
   */
    @RequestMapping(value = "/SaddATT",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findListStation() {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListStation();
            return new BaseAPIResult(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
        }
    }

    @RequestMapping(value = "/SaddATT2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult findListTwoLevelStation(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findListTwoLevelStation(securityPositionDto);
            return new BaseAPIResult(1,securityPositionExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
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
    public BaseAPIResult SecurityPositionAdd(@RequestBody AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.insertSecurityPosition(atSecurityPositionDto);
            return new BaseAPIResult(1,atSecurityPositionExcution);
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,atSecurityPositionExcution);
        }
         catch (Exception e) {
            logger.error(e.getMessage(), e);
             AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
             return new BaseAPIResult(0,atSecurityPositionExcution);
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
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getSecurityPositionUpdate(@RequestBody AtSecurityPositionDto atSecurityPositionDto) {
        //参数验空
        try {
            AtSecurityPositionExcution atSecurityPositionExcution = securityPositionService.updateSecurityPosition(atSecurityPositionDto);
            return new BaseAPIResult(1,atSecurityPositionExcution);
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.FAIL,e.getMessage());
            return new BaseAPIResult(0,atSecurityPositionExcution);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            AtSecurityPositionExcution atSecurityPositionExcution = new AtSecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,atSecurityPositionExcution);
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
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult search(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findSearch(securityPositionDto);
            return new BaseAPIResult(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
        }
    }

    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult StatusSearch(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch(securityPositionDto);
            return new BaseAPIResult(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
        }
    }
    /*
     * 状态筛选
     */
    @RequestMapping(value = "/StatusSearch2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult StatusSearch2(@RequestBody SecurityPositionDto securityPositionDto) {
        //参数验空
        try {
            SecurityPositionExcution securityPositionExcution = securityPositionService.findStatusSearch2(securityPositionDto);
            return new BaseAPIResult(1,securityPositionExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            SecurityPositionExcution securityPositionExcution = new SecurityPositionExcution(SecurityPositionEnum.INNER_ERROR,e.getMessage());
            return new BaseAPIResult(0,securityPositionExcution);
        }
    }
}
