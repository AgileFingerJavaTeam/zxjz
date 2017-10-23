package com.zxjz.service;

import com.zxjz.dto.excution.AuthorityExcution;
import com.zxjz.dto.in.AuthorityDto;
import com.zxjz.dto.in.StaffMemberDto;

public interface AuthorityService {
    /**
     * 查询员工列表
     * @param authorityDto
     * @return
     */
    public AuthorityExcution findListAuthority(AuthorityDto authorityDto);

    /**
     * 查询权限
     * @return
     */
    public AuthorityExcution findListAuthInfo();

    /**
     * 查询编号
     * @return
     */
    public AuthorityExcution findEmployeesNum();

    /**
     * 新增员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution addStaffMember(StaffMemberDto staffMemberDto);

    /**
     * 显示编辑页面
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution findAuthority(StaffMemberDto staffMemberDto);

    /**
     * 修改员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution updateStaffMember(StaffMemberDto staffMemberDto);

    /**
     * 显示删除页面
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution deleteAuthority(StaffMemberDto staffMemberDto);

    /**
     * 删除员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution deleteStaffMember(StaffMemberDto staffMemberDto);
}
