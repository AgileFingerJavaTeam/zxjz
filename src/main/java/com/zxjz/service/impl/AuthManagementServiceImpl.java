package com.zxjz.service.impl;

import com.zxjz.dao.AuthManagementDao;
import com.zxjz.dto.excution.AuthManagementExcution;
import com.zxjz.dto.in.AuthManagementDto;
import com.zxjz.entity.AuthManagement;
import com.zxjz.entity.AuthMenu;
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
        int permission_grouping_id = authManagementDto.getPermission_grouping_id();
        int addAuthManagement = authManagementDao.addAuthManagement(permission_grouping_name);
        String groupingNameStr = authManagementDto.getPermission_grouping_name();
        String[] groupingNameList = groupingNameStr.split(",");
        return null;
    }

}
