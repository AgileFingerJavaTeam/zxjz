package com.zxjz.dao;

import com.zxjz.entity.EmployeeRightsInfo;
import com.zxjz.entity.LandFallInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginDao {
    /**
     * 验证账号和密码
     * @param employees_num
     * @return
     */
    public LandFallInfo findAccountInfo(@Param("employees_num") String employees_num);

    /**
     * 查询员工权限菜单
     * @param employees_num
     * @return
     */
    public List<EmployeeRightsInfo> findMenuList(@Param("employees_num") String employees_num);
}
