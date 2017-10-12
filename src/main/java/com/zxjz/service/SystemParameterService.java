package com.zxjz.service;

import com.zxjz.dto.excution.JobDetailsExcution;
import com.zxjz.dto.excution.MerchantCommentExcution;
import com.zxjz.dto.excution.SystemParameterExcution;
import com.zxjz.dto.in.FindParemeterDto;
import com.zxjz.dto.in.SystemParameterDto;

public interface SystemParameterService {
    /**
     * 是否更新APP
     * @param
     * @return
     */
    public SystemParameterExcution isUpdateAPP();

    /**
     * 发表评价
     * @param systemParameterDto
     * @return
     */
    public MerchantCommentExcution evaluateStudent(SystemParameterDto systemParameterDto);

    /**
     * 查询职位详情
     * @param systemParameterDto
     * @return
     */
    public JobDetailsExcution jobDetails(SystemParameterDto systemParameterDto);

    /**
     * 查询系统参数
     * @param findParemeterDto
     * @return
     */
    public  SystemParameterExcution findParameterList(FindParemeterDto findParemeterDto);

    /**
     * 新增一条系统参数
     * @param systemParameterDto
     * @return
     */
    public  SystemParameterExcution addSystemParameter(SystemParameterDto systemParameterDto);

    /**
     * 显示编辑系统参数页面
     * @param systemParameterDto
     * @return
     */
    public  SystemParameterExcution findParameterInfoById(SystemParameterDto systemParameterDto);

    /**
     * 编辑一条系统参数
     * @param systemParameterDto
     * @return
     */
    public  SystemParameterExcution updateSystemParameter(SystemParameterDto systemParameterDto);

    /**
     * 删除一条系统参数
     * @param systemParameterDto
     * @return
     */
    public  SystemParameterExcution delSystemParameter(SystemParameterDto systemParameterDto);
}
