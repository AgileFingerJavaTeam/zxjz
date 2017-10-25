package com.zxjz.dao;

import com.zxjz.entity.AuthInfo;
import com.zxjz.entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityDao {
    /**
     * 查询员工列表
     * @param offset
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    public List<Authority> findListAuthority(@Param("offset") int offset,
                                              @Param("rows") int rows,
                                              @Param("sort") String sort,
                                              @Param("order") String order);

    /**
     * 查询员工列表数量
     * @param sort
     * @param order
     * @return
     */
    public int authoritycount(@Param("sort") String sort,@Param("order") String order);

    /**
     * 查询权限
     * @return
     */
    public List<Authority> findListAuthInfo();

    /**
     * 查询编号
     * @return
     */
    public List<Authority> findEmployeesNum();

    /**
     * 新增员工
     * @param employees_num
     * @param employees_name
     * @param permission_grouping_name
     * @return
     */
    public int addStaffMember(@Param("employees_num") int employees_num,
                               @Param("employees_name") String employees_name,
                               @Param("permission_grouping_name") String permission_grouping_name);

    /**
     * 显示编辑页面
     * @param employees_id
     * @return
     */
    public Authority findAuthority(@Param("employees_id") int employees_id);

    /**
     * 修改员工
     * @param employees_num
     * @param employees_name
     * @param permission_grouping_name
     * @param employees_id
     * @return
     */
    public int updateStaffMember(@Param("employees_num") int employees_num,
                                  @Param("employees_name") String employees_name,
                                  @Param("permission_grouping_name") String permission_grouping_name,
                                  @Param("employees_id") int employees_id);

    /**
     * 删除
     * @param employees_id
     * @return
     */
    public int deleteStaffMember(@Param("employees_id") int employees_id);
}
