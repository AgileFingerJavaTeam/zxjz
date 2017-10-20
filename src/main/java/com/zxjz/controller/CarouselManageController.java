package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CarouselManageExcution;
import com.zxjz.dto.in.CarouselManageDto;
import com.zxjz.enums.CarouselManageEnum;
import com.zxjz.exception.db.DeleteInnerErrorException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.CarouselManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
@Controller
@RequestMapping("/CarouselManage")
public class CarouselManageController extends BaseController{

     @Autowired
     private CarouselManageService carouselManageService;

    @RequestMapping(value = "/showCarouselPage")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("carousel/showCarouselPage"); // jsp路径
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询参数信息
     *
     * @return
     */
    @RequestMapping(value = "/getCarouselList",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8") // select
    // 用post，其他sql语句用get
    @ResponseBody
    public String getParameterList(CarouselManageDto carouselManageDto) {
        //参数验空
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.getCarouselList(carouselManageDto);
            return BaseUIResult.returnJsonEasyUI(carouselManageExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(carouselManageExcution);
        }
    }

    /**
     * 显示添加系统参数页面
     *
     * @return
     */
    @RequestMapping(value = "/addInfo") // 数据传输功能地址
    public ModelAndView addInfo() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("carousel/addInfo"); // JSP路径页面
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 首页轮播图添加
     *
     * @return
     */

    @RequestMapping(value = "/addCarousel",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addCarousel(
            @RequestParam(value = "carousel_code", required = true) String carousel_code,
            @RequestParam(value = "carousel_name", required = true) String carousel_name,
            @RequestParam(value = "carousel_figure_type", required = true) String carousel_figure_type,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "start_date", required = true) String start_date,
            @RequestParam(value = "end_date", required = true) String end_date,
            @RequestParam(value = "target_id", required = false) Integer target_id,
            @RequestParam(value = "target_parameter", required = false) String target_parameter,
            @RequestParam(value = "target_url", required = false) String target_url,
            @RequestParam(value = "target_type", required = true) String target_type,
            @RequestParam(value = "is_good_position", required = true) String is_good_position,
            @RequestParam(value = "state", required = true) String state) {
        //参数验空
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.insertCarouse(carousel_code,carousel_name,carousel_figure_type,image,start_date,end_date,target_id,target_parameter,target_url,target_type,is_good_position,state);
            return BaseUIResult.returnJsonMSG(1,carouselManageExcution,"添加成功");
        }catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,carouselManageExcution,"添加失败");
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,carouselManageExcution,"添加失败");
        }
    }

    /**
     * 模糊搜索名称
     *
     * @return
     */
    @RequestMapping(value = "/findTitle",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findTitle() {
        //参数验空
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.findTitle();
            return BaseUIResult.returnJson(carouselManageExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJson(carouselManageExcution);
        }
    }

    /**
     * 显示编辑系统参数页面
     *
     * @return
     */
    @RequestMapping(value = "/editInfo",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView editInfo(CarouselManageDto carouselManageDto) {
        ModelAndView mv = new ModelAndView();
        CarouselManageExcution carouselManageExcution = carouselManageService.findCarouseObject(carouselManageDto);
        try {
            mv.addObject("data", carouselManageExcution.getData());
            mv.setViewName("carousel/editInfo");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 首页轮播图编辑功能
     *
     * @return
     */
    @RequestMapping(value = "/editCarousel",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String editCarousel(
            @RequestParam(value = "carousel_code", required = true) String carousel_code,
            @RequestParam(value = "carousel_name", required = true) String carousel_name,
            @RequestParam(value = "carousel_figure_id", required = true) String carousel_figure_id,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "start_date", required = true) String start_date,
            @RequestParam(value = "end_date", required = true) String end_date,
            @RequestParam(value = "target_id", required = false) Integer target_id,
            @RequestParam(value = "target_parameter", required = false) String target_parameter,
            @RequestParam(value = "target_url", required = false) String target_url,
            @RequestParam(value = "target_type", required = true) String target_type,
            @RequestParam(value = "is_good_position", required = true) String is_good_position
    ) { //参数验空
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.updateCarouse(carousel_code,carousel_name,carousel_figure_id,image,start_date,end_date,target_id,target_parameter,target_url,target_type,is_good_position);
            return BaseUIResult.returnJsonMSG(1, carouselManageExcution, "编辑成功");
        } catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "编辑失败");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "编辑失败");
        }
    }

    /**
     * 显示状态更新页面
     * @return
     */
    @RequestMapping(value = "/changeInfo",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView changeInfo(CarouselManageDto carouselManageDto){
        ModelAndView mv = new ModelAndView();
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.findCarouseObject(carouselManageDto);
            mv.addObject("data",carouselManageExcution.getData());
            mv.setViewName("carousel/changeInfo");   //JSP路径页面
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }

    /**
     * 编辑状态更新
     * @return
     */
    @RequestMapping(value = "/changeCarousel",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String changeCarousel(@RequestParam(value = "state", required = true) String state,@RequestParam(value = "carousel_figure_id", required = true) int carousel_figure_id){
        try{
            CarouselManageExcution carouselManageExcution = carouselManageService.updateChangeCarouse(state,carousel_figure_id);
            return BaseUIResult.returnJsonMSG(1, carouselManageExcution, "编辑成功");
        }catch (UpdateInnerErrorException e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "编辑失败");
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "编辑失败");
        }
    }

    /**
     * 显示删除页面
     * @return
     */
    @RequestMapping(value = "/delInfo",
            method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView delInfo(CarouselManageDto carouselManageDto){
        ModelAndView mv = new ModelAndView();
        try {
            CarouselManageExcution carouselManageExcution = carouselManageService.findCarouseObject(carouselManageDto);
            mv.addObject("data",carouselManageExcution.getData());
            mv.setViewName("carousel/delInfo");   //JSP路径页面
        } catch (Exception e) {
            logger.error(e.toString(),e);
        }
        return mv;
    }


    /**
     * 删除参数
     * @return
     */
    @RequestMapping(value = "/delCarousel",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String delCarousel(CarouselManageDto carouselManageDto){
        try{
         CarouselManageExcution carouselManageExcution = carouselManageService.deleteCarouse(carouselManageDto);
         return BaseUIResult.returnJsonMSG(1,carouselManageExcution,"删除成功");
        }catch (DeleteInnerErrorException e){
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "删除失败");
        }
        catch (Exception e){
            logger.error(e.getMessage(), e);
            CarouselManageExcution carouselManageExcution = new CarouselManageExcution(CarouselManageEnum.ERROR, e.getMessage());
            return BaseUIResult.returnJsonMSG(0, carouselManageExcution, "删除失败");
        }
    }

   /* *//**
     * 模糊查询
     * @return
     *//*
    @RequestMapping(value = "/getCarouselSearch",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getCarouselSearch(CarouselManageDto carouselManageDto){

      return null;
    }*/
}

