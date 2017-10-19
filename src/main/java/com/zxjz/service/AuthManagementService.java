package com.zxjz.service;

import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.in.AuthManagementDto;

public interface AuthManagementService {
    /**
     *  查询员工权限管理界面
     * @param
     * @return
     */
    public AuthManagementExcution getAuthManagement();

    /**
     * 添加权限分组名称
     * @return
     */
    public AuthManagementExcution addAuthManagement(AuthManagementDto authManagementDto);
}
