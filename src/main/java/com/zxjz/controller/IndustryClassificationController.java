package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
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
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
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
     * 查询参数信息
     * @param
     * @return
     */
    @RequestMapping(value = "getIndustryList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getKeyWord(){
        //参数验空
        try{
            IndustryClassificationExcution findListIndustryClassification = industryClassificationService.findListIndustryClassification();
            return BaseUIResult.returnJsonEasyUI(findListIndustryClassification);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonEasyUI(industryClassificationExcution);
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
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String addIndustry(IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution insertIndustry = industryClassificationService.insertIndustry(industryClassificationDto);
            return BaseUIResult.returnJsonMSG(1,insertIndustry,"添加成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.RETURN_FAIL);
            return BaseUIResult.returnJsonMSG(0,industryClassificationExcution,"添加失败!");
        }

    }

    /**
     * 显示修改页面
     * @return
     */
    @RequestMapping(value ="/showeditInfo")//数据传输功能地址
    @ResponseBody
    public ModelAndView showeditInfo(IndustryClassificationDto industryClassificationDto){
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
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String editIndustry(IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution editIndustry = industryClassificationService.editIndustry(industryClassificationDto);
            return BaseUIResult.returnJsonMSG(1,editIndustry,"修改成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonMSG(0,industryClassificationExcution,"修改失败！");
        }

    }

    /**
     * 显示删除系统参数页面
     * @return
     */
    @RequestMapping(value ="/showDelInfo")
    public ModelAndView showDelInfo(IndustryClassificationDto industryClassificationDto){
        ModelAndView mv = new ModelAndView();
        try{
            IndustryClassificationExcution findIndustryCategory = industryClassificationService.findIndustryCategory(industryClassificationDto);
            mv.addObject("data",findIndustryCategory);
            mv.setViewName("carousel/delIndustry");   //JSP路径页面
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
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String delIndustry(IndustryClassificationDto industryClassificationDto){
        //参数验空
        try{
            IndustryClassificationExcution updateIndustry = industryClassificationService.updateIndustry(industryClassificationDto);
            return BaseUIResult.returnJsonMSG(1,updateIndustry,"删除成功!");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            IndustryClassificationExcution industryClassificationExcution = new IndustryClassificationExcution(e.getMessage(), IndustryClassificationEnum.UPDATE_FAIL);
            return BaseUIResult.returnJsonMSG(1,industryClassificationExcution,"删除失败!");
        }

    }
}
