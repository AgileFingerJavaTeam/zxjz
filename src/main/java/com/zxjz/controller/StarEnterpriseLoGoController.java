package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CarouselManageExcution;
import com.zxjz.dto.excution.StarEnterpriseLoGoExcution;
import com.zxjz.dto.in.StarEnterpriseLoGoDto;
import com.zxjz.enums.CarouselManageEnum;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.StarEnterpriseLoGoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/StarEnterpriseLoGo")
public class StarEnterpriseLoGoController extends BaseController{

    @Autowired
    private StarEnterpriseLoGoService starEnterpriseLoGoService;

    /**
     * 显示页面
     * @return
     */
    @RequestMapping(value ="/showStarEnterpriseLoGo")//数据传输功能地址
    @ResponseBody
    public ModelAndView showStarEnterpriseLoGo(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("starEnterpriseLoGo/starEnterpriseLoGo");   //JSP路径页面
        }catch (Exception e){
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 显示页面
     * @param
     * @return
     */
    @RequestMapping(value = "StarEnterpriseLoGoLists",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String StarEnterpriseLoGoList(){
        //参数验空
        try{
            StarEnterpriseLoGoExcution findStarEnterpriseLoGoList = starEnterpriseLoGoService.findStarEnterpriseLoGoList();
            return BaseUIResult.returnJsonEasyUI(findStarEnterpriseLoGoList);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            StarEnterpriseLoGoExcution starEnterpriseLoGoExcution = new StarEnterpriseLoGoExcution(e.getMessage(), IndustryClassificationEnum.RETURN_FAIL);
            return BaseUIResult.returnJsonEasyUI(starEnterpriseLoGoExcution);
        }

    }

    /**
     * 显示编辑企业Logo页面
     *
     * @return
     */
    @RequestMapping(value = "/showUpdateStarLoGo",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView showUpdateStarLoGo(StarEnterpriseLoGoDto starEnterpriseLoGoDto) {
        ModelAndView mv = new ModelAndView();
        StarEnterpriseLoGoExcution findStarEnterpriseLoGo = starEnterpriseLoGoService.findStarEnterpriseLoGo(starEnterpriseLoGoDto);
        try {
            mv.addObject("data", findStarEnterpriseLoGo.getData());
            mv.setViewName("starEnterpriseLoGo/editStarEnterpriseLoGo");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑企业logos
     * @param picture_url
     * @param icon_id
     * @return
     */
    @RequestMapping(value = "/editLogo",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String editLogo(
            @RequestParam(value = "picture_url", required = true) MultipartFile picture_url,
            @RequestParam(value = "icon_id", required = true) int icon_id
    ) { //参数验空
        try {
            StarEnterpriseLoGoExcution updateStarLoGo = starEnterpriseLoGoService.updateStarLoGo(picture_url,icon_id);
            return BaseUIResult.returnJsonMSG(1, updateStarLoGo, "编辑成功");
        } catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "编辑失败");
        }
    }
}
