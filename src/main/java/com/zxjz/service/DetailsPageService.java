package com.zxjz.service;

import com.zxjz.dto.excution.DetailsPageExcution;
import com.zxjz.dto.in.DetailsPageDto;

public interface DetailsPageService {
    /**
     * 学生详情页
     * @param
     * @return
     */
    public DetailsPageExcution getDetailsPage(DetailsPageDto detailsPageDto);
}
