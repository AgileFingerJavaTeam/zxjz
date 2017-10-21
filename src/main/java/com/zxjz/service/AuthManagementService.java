package com.zxjz.service;

import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.in.AuthManagementDto;
import com.zxjz.dto.in.MvAuthDto;

public interface AuthManagementService {
    /**
     *  查询员工权限管理界面
     * @param
     * @return
     */
    public AuthManagementExcution getAuthManagement();

    /**
     * 添加权限分组名称和菜单名称
     * @return
     */
    public AuthManagementExcution addAuthManagement(AuthManagementDto authManagementDto);

    /**
     * 查询菜单名称
     * @return
     */
    public AuthManagementExcution getMenuName();

    /**
     * 显示编辑页面
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution editMvAuth(MvAuthDto mvAuthDto);

    /**
     * 编辑权限
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution editEditAuth(MvAuthDto mvAuthDto);

    /**
     * 查询要删除的数据
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution findAuthInfo(MvAuthDto mvAuthDto);

    /**
     * 删除权限数据
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution deleteParameter(MvAuthDto mvAuthDto);
}
