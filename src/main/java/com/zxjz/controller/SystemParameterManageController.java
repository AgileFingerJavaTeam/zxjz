package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.SystemParameterExcution;
import com.zxjz.dto.in.FindParemeterDto;
import com.zxjz.dto.in.SystemParameterDto;
import com.zxjz.enums.SystemParameterEnum;
import com.zxjz.exception.db.DeleteInnerErrorException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;





@Controller
@RequestMapping(value = "System")
public class SystemParameterManageController extends BaseController {
    @Autowired
    private SystemParameterService systemParameterService;
    /**
     * 显示系统参数设置页面
     * @return
     */
    @RequestMapping(value = "/showParameterPage",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showParameterManagePage(){
      ModelAndView mv = new ModelAndView();
      try {
          mv.setViewName("system/showParameterPage");
      }catch (Exception e){
          logger.error(e.toString(),e);
      }
        return mv;
    }

    /**
     * 查询系统参数
     * @param findParemeterDto
     * @return
     */
    @RequestMapping(value = "/parameter",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getParameterList(FindParemeterDto findParemeterDto){
        try {
            SystemParameterExcution SystemParameter = systemParameterService.findParameterList(findParemeterDto);
          return BaseUIResult.returnJsonEasyUI(SystemParameter);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SystemParameterExcution SystemParameter = new SystemParameterExcution(SystemParameterEnum.QUERY_FAIL);
            return  BaseUIResult.returnJsonEasyUI(SystemParameter);
        }
    }

    /**
     * 显示添加系统参数页面
     * @return
     */
    @RequestMapping(value = "/addPS",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showAddPS(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("system/addPS");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 添加一条系统参数
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/insertParameter",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String insertParameter(SystemParameterDto systemParameterDto){
        try {
            SystemParameterExcution systemParameterExcution = systemParameterService.addSystemParameter(systemParameterDto);
            return  BaseUIResult.returnJsonMSG(1,systemParameterExcution,"新增成功");
        }catch (InsertInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.ADD_FAIL);
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"新增失败");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.ADD_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"新增失败");
        }
    }
    /**
     * 显示编辑系统参数页面
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/editPS",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showEditPS(SystemParameterDto systemParameterDto){
        ModelAndView mv = new ModelAndView();
        try {
            SystemParameterExcution systemParameterInfo = systemParameterService.findParameterInfoById(systemParameterDto);
            mv.addObject("data", systemParameterInfo);
            mv.setViewName("system/editPS");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 编辑系统参数
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "srt_editParameter",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editParameter(SystemParameterDto systemParameterDto){
        try{
            SystemParameterExcution systemParameterExcution = systemParameterService.updateSystemParameter(systemParameterDto);
            return  BaseUIResult.returnJsonMSG(1,systemParameterExcution,"编辑成功");
        }catch (UpdateInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.EDIT_FAIL);
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"编辑失败");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.EDIT_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"编辑失败");
        }
    }

    /**
     * 显示删除系统参数页面
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/delPS",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDelPS(SystemParameterDto systemParameterDto){
        ModelAndView mv = new ModelAndView();
        try {
            SystemParameterExcution systemParameterInfo = systemParameterService.findParameterInfoById(systemParameterDto);
            mv.addObject("data",systemParameterInfo);
            mv.setViewName("system/delPS");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 删除系统参数
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/srt_deleteParameter",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String delSystemParameter (SystemParameterDto systemParameterDto){
        try {
            SystemParameterExcution systemParameterExcution = systemParameterService.delSystemParameter(systemParameterDto);
            return  BaseUIResult.returnJsonMSG(1,systemParameterExcution,"删除成功");
        }catch (DeleteInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.DEL_FAIL);
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"删除失败");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.DEL_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonMSG(0,systemParameterExcution,"删除失败");
        }
    }

}
