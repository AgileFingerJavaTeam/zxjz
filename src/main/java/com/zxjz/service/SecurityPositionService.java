package com.zxjz.service;

import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;

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
     * @param atSecurityPositionDto
     * @return
     */
    public AtSecurityPositionExcution updateSecurityPosition(AtSecurityPositionDto atSecurityPositionDto);

    /**
     * 模糊查询
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution findSearch(SecurityPositionDto securityPositionDto);

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
