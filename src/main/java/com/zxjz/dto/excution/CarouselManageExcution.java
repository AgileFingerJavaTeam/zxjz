package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CarouselManageEnum;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class CarouselManageExcution extends BaseAPIExcution{

    public CarouselManageExcution(CarouselManageEnum carouselManageEnum , Object data) {
         this.code = carouselManageEnum.getCode();
         this.data = data;
    }
}
