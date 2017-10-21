package com.zxjz.dao;

import com.zxjz.entity.AuthManagement;
import com.zxjz.entity.AuthMenu;
import com.zxjz.entity.MenuName;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * @param map
     * @return
     */
    public int addAuthManagement(Map map);

    /**
     * 添加菜单名称
     * @return
     */
    public int addAuthMenu(@Param("permission_grouping_id") int permission_grouping_id,@Param("k") int k);

    /**
     * 查询菜单名称
     * @return
     */
    public List<MenuName> getMenuName();

    /**
     * 显示权限编辑页面
     * @param permission_grouping_id
     * @return
     */
    public List<AuthManagement> editMvAuth(@Param("permission_grouping_id") int permission_grouping_id);

    /**
     * 编辑权限分组
     * 删除原有数据
     * @param permission_grouping_id_s
     * @return
     */
    public int deletePermission(@Param("permission_grouping_id_s") int permission_grouping_id_s);

    /**
     * 查询要删除的数据
     * @param permission_grouping_id
     * @return
     */
    public AuthManagement findAuthInfo(@Param("permission_grouping_id") int permission_grouping_id);

    /**
     * 删除权限分组
     * @param permission_grouping_id
     * @return
     */
    public int deleteParameter(@Param("permission_grouping_id") int permission_grouping_id);

}
