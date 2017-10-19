package com.zxjz.service;

import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public interface SecurityPositionService {
    /**
     * 显示数据
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution getSecurityPositionList(SecurityPositionDto securityPositionDto);
    /**
     * 显示数据 推荐/担保
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution getSecurityPositionList2(SecurityPositionDto securityPositionDto);

    /**
     * 详情list
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution getSecurityPositionSecurity(SecurityPositionDto securityPositionDto);
    /**
     * 详情
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution getSecurityPosition(SecurityPositionDto securityPositionDto);

    /**
     * 遍历商户名
     * @return
     */
    public SecurityPositionExcution findListMarchantName();

    /**
     * 遍历岗位分类
     */
    public SecurityPositionExcution findListStation();

    /**
     * 遍历二级岗位分类
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findListTwoLevelStation(SecurityPositionDto securityPositionDto);

    /**
     * 添加精品职位数据
     * @param atSecurityPositionDto
     * @return
     */
    public AtSecurityPositionExcution insertSecurityPosition(AtSecurityPositionDto atSecurityPositionDto);

    /**
     * 系统参数详情页面
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findSecurityPositionHref(SecurityPositionDto securityPositionDto);
    /**
     * 编辑系统参数页面
     * @param
     * @return
     */
    public AtSecurityPositionExcution updateSecurityPosition(@RequestParam(value = "recruiting_id", required = true) Integer recruiting_id,
                                                             @RequestParam(value = "post_name", required = false) String post_name,
                                                             @RequestParam(value = "post_classification", required = true) Integer post_classification,
                                                             @RequestParam(value = "work_date", required = true) String work_date,
                                                             @RequestParam(value = "work_time", required = true) String work_time,
                                                             @RequestParam(value = "work_location", required = true) String work_location,
                                                             @RequestParam(value = "position_longitude", required = true) String position_longitude,
                                                             @RequestParam(value = "position_latitude", required = true) String position_latitude,
                                                             @RequestParam(value = "work_content", required = true) String work_content,
                                                             @RequestParam(value = "salary_treatment", required = true) double salary_treatment,
                                                             @RequestParam(value = "commission", required = true) double commission,
                                                             @RequestParam(value = "benefits", required = true) double benefits,
                                                             @RequestParam(value = "gender_requirements", required = true) String gender_requirements,
                                                             @RequestParam(value = "other_requirements", required = true) String other_requirements,
                                                             @RequestParam(value = "recruitment", required = true) int recruitment,
                                                             @RequestParam(value = "hiring_expiration_date", required = true) String hiring_expiration_date,
                                                             @RequestParam(value = "main_title", required = true) String main_title,
                                                             @RequestParam(value = "subtitle", required = true) String subtitle,
                                                             @RequestParam(value = "short_description", required = true) String short_description,
                                                             @RequestParam(value = "page_url", required = false) MultipartFile page_url,
                                                             @RequestParam(value = "first_page_carousel_url", required = false) MultipartFile first_page_carousel_url,
                                                             @RequestParam(value = "main_page_url", required = false) MultipartFile main_page_url,
                                                             @RequestParam(value = "details_page_introduction", required = true) String details_page_introduction,
                                                             @RequestParam(value = "releases_user_id", required = true) Integer releases_user_id,
                                                             @RequestParam(value = "up_down_frame", required = true) String up_down_frame
    );

    /**
     * 模糊查询
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findSearch(SecurityPositionDto securityPositionDto);
    /**
     * 是否上推荐/担保模糊查询
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findSearch2(SecurityPositionDto securityPositionDto);
    /**
     * 状态筛选
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findStatusSearch(SecurityPositionDto securityPositionDto);

    /**
     * 是否上首页推荐/担保 状态筛选
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findStatusSearch2(SecurityPositionDto securityPositionDto);
}
