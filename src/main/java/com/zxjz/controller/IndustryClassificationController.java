package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.IndustryClassificationExcution;
import com.zxjz.dto.excution.KeywordSearchExcution;
import com.zxjz.dto.in.IndustryClassificationDto;
import com.zxjz.dto.in.KeywordSearchDto;
import com.zxjz.entity.IndustryCategory;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.BillListService;
import com.zxjz.service.IndustryClassificationService;
import com.zxjz.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/IndustryManage")
public class IndustryClassificationController extends BaseController{

    @Autowired
    private IndustryClassificationService industryClassificationService;

    /**
     * 显示页面
     * @return
     */
    @RequestMapping(value = "showIndustryPage",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showIndustryPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("carousel/showIndustryPage");  //jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询参数信息s
     * @param industryClassificationDto
     * @return
     */
    @RequestMapping(value = "getIndustryList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getKeyWord(@RequestBody IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution findListIndustryClassification = industryClassificationService.findListIndustryClassification();
            return new BaseAPIResult(1,findListIndustryClassification);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return new BaseAPIResult(0,industryClassificationExcution);
        }

    }

    /**
     * 显示添加页面
     * @return
     */
    @RequestMapping(value ="/addInfo")//数据传输功能地址
    public ModelAndView addInfo(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("carousel/addIndustry");   //JSP路径页面
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 添加行业
     * @param industryClassificationDto
     * @return
     */
    @RequestMapping(value = "addIndustry",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult addIndustry(@RequestBody IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution insertIndustry = industryClassificationService.insertIndustry(industryClassificationDto);
            return new BaseAPIResult(1,insertIndustry);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.RETURN_FAIL);
            return new BaseAPIResult(0,industryClassificationExcution);
        }

    }

    /**
     * 显示修改页面
     * @return
     */
    @RequestMapping(value ="/showeditInfo")//数据传输功能地址
    @ResponseBody
    public ModelAndView showeditInfo(@RequestBody IndustryClassificationDto industryClassificationDto){
        ModelAndView mv = new ModelAndView();
        try{
            IndustryClassificationExcution findIndustryCategory = industryClassificationService.findIndustryCategory(industryClassificationDto);
            mv.addObject("data",findIndustryCategory);
            mv.setViewName("carousel/editIndustry");   //JSP路径页面
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 修改行业
     * @param industryClassificationDto
     * @return
     */
    @RequestMapping(value = "editIndustry",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult editIndustry(@RequestBody IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution findIndustryCategory = industryClassificationService.findIndustryCategory(industryClassificationDto);
            return new BaseAPIResult(1,findIndustryCategory);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return new BaseAPIResult(0,industryClassificationExcution);
        }

    }

    /**
     * 显示删除系统参数页面
     * @return
     */
    @RequestMapping(value ="/showDelInfo")
    public ModelAndView showDelInfo(@RequestBody IndustryClassificationDto industryClassificationDto){
        ModelAndView mv = new ModelAndView();
        try{
            IndustryClassificationExcution findIndustryCategory = industryClassificationService.findIndustryCategory(industryClassificationDto);
            mv.addObject("data",findIndustryCategory);
            mv.setViewName("carousel/editIndustry");   //JSP路径页面
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 删除系统参数
     * @param industryClassificationDto
     * @return
     */
    @RequestMapping(value = "delIndustry",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult delIndustry(@RequestBody IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution updateIndustry = industryClassificationService.updateIndustry(industryClassificationDto);
            return new BaseAPIResult(1,updateIndustry);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.UPDATE_FAIL);
            return new BaseAPIResult(0,industryClassificationExcution);
        }

    }
}
