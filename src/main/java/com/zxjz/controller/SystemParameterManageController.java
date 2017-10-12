package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
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
import org.springframework.web.bind.annotation.RequestBody;
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
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
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
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SystemParameterExcution> getParameterList(@RequestBody FindParemeterDto findParemeterDto){
        try {
          SystemParameterExcution SystemParameter = systemParameterService.findParameterList(findParemeterDto);
          return new BaseResult<SystemParameterExcution>(1,SystemParameter);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<SystemParameterExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示添加系统参数页面
     * @return
     */
    @RequestMapping(value = "/addPS",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
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
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SystemParameterExcution> insertParameter(@RequestBody SystemParameterDto systemParameterDto){
        try {
            SystemParameterExcution systemParameterExcution = systemParameterService.addSystemParameter(systemParameterDto);
            return new BaseResult<SystemParameterExcution>(1,systemParameterExcution);
        }catch (InsertInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.ADD_FAIL);
            return new BaseResult<SystemParameterExcution>(0,systemParameterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<SystemParameterExcution>(0,e.getMessage());
        }
    }
    /**
     * 显示编辑系统参数页面
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/editPS",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showEditPS(@RequestBody SystemParameterDto systemParameterDto){
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
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SystemParameterExcution> editParameter(@RequestBody SystemParameterDto systemParameterDto){
        try{
            SystemParameterExcution systemParameterExcution = systemParameterService.updateSystemParameter(systemParameterDto);
            return new BaseResult<SystemParameterExcution>(1,systemParameterExcution);
        }catch (UpdateInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.EDIT_FAIL);
            return new BaseResult<SystemParameterExcution>(0,systemParameterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<SystemParameterExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示删除系统参数页面
     * @param systemParameterDto
     * @return
     */
    @RequestMapping(value = "/delPS",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDelPS(@RequestBody SystemParameterDto systemParameterDto){
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
    @RequestMapping(value = "/srt_deleteParameter",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<SystemParameterExcution> delSystemParameter (@RequestBody SystemParameterDto systemParameterDto){
        try {
            SystemParameterExcution systemParameterExcution = systemParameterService.delSystemParameter(systemParameterDto);
            return new BaseResult<SystemParameterExcution>(1,systemParameterExcution);
        }catch (DeleteInnerErrorException e){
            SystemParameterExcution systemParameterExcution = new SystemParameterExcution(SystemParameterEnum.DEL_FAIL);
            return new BaseResult<SystemParameterExcution>(0,systemParameterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BaseResult<SystemParameterExcution>(0,e.getMessage());
        }
    }

}
