package com.zxjz.dao;

import com.zxjz.entity.AuthManagement;
import com.zxjz.entity.AuthMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthManagementDao {
    /**
     * 查询角色信息
     * @return
     */
    public List<AuthManagement> getInfoList();

    public List<AuthMenu> getInfoAuthList(@Param("permission_grouping_id") int permission_grouping_id);

    public String getMenuInfo(@Param("menu_id") int menu_id);

    /**
     * 获取参数条数
     * @return
     */
    public int total();

    /**
     * 添加权限分组名称
     * @param permission_grouping_name
     * @return
     */
    public int addAuthManagement(@Param("permission_grouping_name") String permission_grouping_name);

    /**
     * 添加菜单名称
     * @return
     */
    public int addAuthMenu(@Param("permission_grouping_id") int permission_grouping_id);
}
