package com.zxjz.service.impl;

import com.zxjz.dao.AuthManagementDao;
import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.in.AuthManagementDto;
import com.zxjz.dto.in.MvAuthDto;
import com.zxjz.entity.AuthManagement;
import com.zxjz.entity.AuthMenu;
import com.zxjz.entity.MenuName;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.service.AuthManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthManagementServiceImpl implements AuthManagementService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthManagementDao authManagementDao;

    /**
     * 查询角色管理界面
     * @param
     * @return
     */
    public AuthManagementExcution getAuthManagement() {
        List<AuthManagement> getInfoList = authManagementDao.getInfoList();
        List list = new ArrayList();
        for (int i = 0; i < getInfoList.size(); i++){
            Map map = new HashMap();
            AuthManagement info = getInfoList.get(i);
            map.put("permission_grouping_name", info.getPermissionGroupingName());
            map.put("permission_grouping_id", info.getPermissionGroupingId());

            int permission_grouping_id = info.getPermissionGroupingId();
            List<AuthMenu> getInfoAuthList = authManagementDao.getInfoAuthList(permission_grouping_id);
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < getInfoAuthList.size(); j++){
                AuthMenu menu = getInfoAuthList.get(j);
                int menu_id = menu.getMenuId();
                String getMenuInfo = authManagementDao.getMenuInfo(menu_id);
                if (j<getInfoAuthList.size()-1){
                    buffer.append(getMenuInfo);
                    buffer.append(",");
                }else {
                    buffer.append(getMenuInfo);
                }
            }
            map.put("buffer",buffer);
            list.add(map);
        }
        int total = authManagementDao.total();
        Map mapT = new HashMap();
        mapT.put("rows", list);
        mapT.put("total", total);
        return new AuthManagementExcution(mapT,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 添加权限分组名称
     * @param authManagementDto
     * @return
     */
    public AuthManagementExcution addAuthManagement(AuthManagementDto authManagementDto) {
        String permission_grouping_name = authManagementDto.getPermission_grouping_name();
        Map map = new HashMap();
        map.put("permission_grouping_name",permission_grouping_name);
        map.put("permission_grouping_id",0);
        int addAuthManagement = authManagementDao.addAuthManagement(map);
        int permission_grouping_id = (Integer) map.get("permission_grouping_id");
        String[] hidden_menu_id = authManagementDto.getHidden_menu_id().split(",");
        int k = 0;
        int addAuthMenu = 0;
        boolean isSeccess = true;
        for (int i = 0; i < hidden_menu_id.length; i++){
            k = Integer.parseInt(hidden_menu_id[i]);
            addAuthMenu = authManagementDao.addAuthMenu(permission_grouping_id,k);
            if (addAuthMenu <= 0){
                isSeccess = false;
            }
        }
        if (addAuthManagement>0 && addAuthMenu>0){
            return new AuthManagementExcution(IndustryClassificationEnum.RETURN_SUCCESS);
        }else {
            return new AuthManagementExcution(IndustryClassificationEnum.RETURN_FAIL);
        }
    }

    /**
     * 查询菜单名称
     * @return
     */
    public AuthManagementExcution getMenuName() {
        List<MenuName> getMenuName = authManagementDao.getMenuName();
        return new AuthManagementExcution(getMenuName,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 显示编辑页面
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution editMvAuth(MvAuthDto mvAuthDto) {
        int permission_grouping_id = mvAuthDto.getPermission_grouping_id();
        List<AuthManagement> editMvAuth = authManagementDao.editMvAuth(permission_grouping_id);
        StringBuffer menuNameString = new StringBuffer();
        StringBuffer menuIDString = new StringBuffer();
        for (AuthManagement authManage : editMvAuth){
            menuNameString.append(authManage.getMenuName());
            menuNameString.append(",");
            menuIDString.append(authManage.getMenuId());
            menuIDString.append(",");
        }
        menuNameString.deleteCharAt(menuNameString.length()-1);
        menuIDString.deleteCharAt(menuIDString.length()-1);
        Map map = new HashMap();
        map.put("rows",editMvAuth);
        map.put("groupName",editMvAuth.get(0).getPermissionGroupingName());
        map.put("groupID",editMvAuth.get(0).getPermissionGroupingId());
        map.put("menuName",menuNameString);
        map.put("menuID",menuIDString);
        return new AuthManagementExcution(map,IndustryClassificationEnum.RETURN_SUCCESS);
    }

    /**
     * 编辑权限
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution editEditAuth(MvAuthDto mvAuthDto) {
        int permission_grouping_id_s = mvAuthDto.getPermission_grouping_id();
        int deletePermission = authManagementDao.deletePermission(permission_grouping_id_s);
        String permission_grouping_name = mvAuthDto.getPermission_grouping_name();
        Map map = new HashMap();
        map.put("permission_grouping_name",permission_grouping_name);
        map.put("permission_grouping_id",0);
        int addAuthManagement = authManagementDao.addAuthManagement(map);
        int permission_grouping_id = (Integer) map.get("permission_grouping_id");
        String[] hidden_menu_id = mvAuthDto.getHidden_menu_id().split(",");
        int k = 0;
        int addAuthMenu = 0;
        boolean isSeccess = true;
        for (int i = 0; i < hidden_menu_id.length; i++){
            k = Integer.parseInt(hidden_menu_id[i]);
            addAuthMenu = authManagementDao.addAuthMenu(permission_grouping_id,k);
            if (addAuthMenu <= 0){
                isSeccess = false;
            }
        }
        if (deletePermission>0 && addAuthManagement>0 && addAuthMenu>0){
            return new AuthManagementExcution(IndustryClassificationEnum.RETURN_SUCCESS);
        }else {
            return new AuthManagementExcution(IndustryClassificationEnum.RETURN_FAIL);
        }
    }

    /**
     * 查询要删除的数据
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution findAuthInfo(MvAuthDto mvAuthDto) {
        int permission_grouping_id = mvAuthDto.getPermission_grouping_id();
        AuthManagement findAuthInfo = authManagementDao.findAuthInfo(permission_grouping_id);
        if (findAuthInfo == null){
            return new AuthManagementExcution(IndustryClassificationEnum.FIND_ERROR);
        }
        return new AuthManagementExcution(findAuthInfo,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 删除权限数据
     * @param mvAuthDto
     * @return
     */
    public AuthManagementExcution deleteParameter(MvAuthDto mvAuthDto) {
        int permission_grouping_id = mvAuthDto.getPermission_grouping_id();
        int deleteParameter = authManagementDao.deleteParameter(permission_grouping_id);
        if (deleteParameter > 0){
            return new AuthManagementExcution(IndustryClassificationEnum.DELETE_SUCCESS);
        }else {
            return new AuthManagementExcution(IndustryClassificationEnum.DELETE_ERROR);
        }
    }

}
