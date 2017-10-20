package com.zxjz.service;

import com.zxjz.dto.excution.CarouselManageExcution;
import com.zxjz.dto.in.CarouselManageDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public interface CarouselManageService {

     public CarouselManageExcution getCarouselList(CarouselManageDto carouselManageDto);

     /**
      * 添加
      * @param carousel_code
      * @param carousel_name
      * @param carousel_figure_type
      * @param image
      * @param start_date
      * @param end_date
      * @param target_id
      * @param target_parameter
      * @param target_url
      * @param target_type
      * @param is_good_position
      * @param state
      * @return
      */
     public CarouselManageExcution insertCarouse( @RequestParam(value = "carousel_code", required = true) String carousel_code,
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
                                                   @RequestParam(value = "state", required = true) String state);


     public CarouselManageExcution findTitle();


     public CarouselManageExcution findCarouseObject(CarouselManageDto carouselManageDto);

     public CarouselManageExcution updateCarouse(@RequestParam(value = "carousel_code", required = true) String carousel_code,
                                                  @RequestParam(value = "carousel_name", required = true) String carousel_name,
                                                  @RequestParam(value = "carousel_figure_id", required = true) String carousel_figure_id,
                                                  @RequestParam(value = "image", required = false) MultipartFile image,
                                                  @RequestParam(value = "start_date", required = true) String start_date,
                                                  @RequestParam(value = "end_date", required = true) String end_date,
                                                  @RequestParam(value = "target_id", required = false) Integer target_id,
                                                  @RequestParam(value = "target_parameter", required = false) String target_parameter,
                                                  @RequestParam(value = "target_url", required = false) String target_url,
                                                  @RequestParam(value = "target_type", required = true) String target_type,
                                                  @RequestParam(value = "is_good_position", required = true) String is_good_position);

     public CarouselManageExcution updateChangeCarouse(@RequestParam(value = "state", required = true) String state,@RequestParam(value = "carousel_figure_id", required = true) int carousel_figure_id);

     public CarouselManageExcution deleteCarouse(CarouselManageDto carouselManageDto);
}
