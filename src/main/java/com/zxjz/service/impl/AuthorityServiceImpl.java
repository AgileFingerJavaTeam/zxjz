package com.zxjz.service.impl;

import com.zxjz.dao.AuthorityDao;
import com.zxjz.dto.excution.AuthorityExcution;
import com.zxjz.dto.in.AuthorityDto;
import com.zxjz.dto.in.StaffMemberDto;
import com.zxjz.entity.Authority;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthorityDao authorityDao;

    /**
     * 查询员工列表
     * @param authorityDto
     * @return
     */
    public AuthorityExcution findListAuthority(AuthorityDto authorityDto) {
        int offset = authorityDto.getOffset();
        int rows = authorityDto.getRows();
        String sort = authorityDto.getSort();
        String order = authorityDto.getOrder();
        List<Authority> findListAuthority = authorityDao.findListAuthority(offset,rows,sort,order);
        int total = authorityDao.authoritycount(sort,order);
        Map map = new HashMap();
        map.put("rows",findListAuthority);
        map.put("total",total);
        return new AuthorityExcution(map, IndustryClassificationEnum.FIND_SUCCESS);
    }


    /**
     * 查询权限
     * @return
     */
    public AuthorityExcution findListAuthInfo() {
        List<Authority> findListAuthInfo = authorityDao.findListAuthInfo();
        return new AuthorityExcution(findListAuthInfo, IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 查询编号
     * @return
     */
    public AuthorityExcution findEmployeesNum() {
        List<Authority> findEmployeesNum = authorityDao.findEmployeesNum();
        return new AuthorityExcution(findEmployeesNum, IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 新增员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution addStaffMember(StaffMemberDto staffMemberDto) {
        int employees_num = staffMemberDto.getEmployees_num();
        String employees_name = staffMemberDto.getEmployees_name();
        String permission_grouping_name = staffMemberDto.getPermission_grouping_name();
        int addStaffMember = authorityDao.addStaffMember(employees_num,employees_name,permission_grouping_name);
        if (addStaffMember > 0){
            return new AuthorityExcution(IndustryClassificationEnum.ADD_SUCCESS);
        }else {
            return new AuthorityExcution(IndustryClassificationEnum.ADD_ERROR);
        }
    }

    /**
     * 显示编辑页面
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution findAuthority(StaffMemberDto staffMemberDto) {
        int employees_id = staffMemberDto.getEmployees_id();
        Authority findAuthority = authorityDao.findAuthority(employees_id);
        return new AuthorityExcution(findAuthority,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 修改员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution updateStaffMember(StaffMemberDto staffMemberDto) {
        int employees_num = staffMemberDto.getEmployees_num();
        String employees_name = staffMemberDto.getEmployees_name();
        String permission_grouping_name = staffMemberDto.getPermission_grouping_name();
        int employees_id = staffMemberDto.getEmployees_id();
        int updateStaffMember = authorityDao.updateStaffMember(employees_num,employees_name,permission_grouping_name,employees_id);
        if (updateStaffMember > 0){
            return new AuthorityExcution(IndustryClassificationEnum.UPDATE_SUCCESS);
        }else {
            return new AuthorityExcution(IndustryClassificationEnum.UPDATE_FAIL);
        }
    }

    /**
     * 显示删除页面
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution deleteAuthority(StaffMemberDto staffMemberDto) {
        int employees_id = staffMemberDto.getEmployees_id();
        Authority findAuthority = authorityDao.findAuthority(employees_id);
        return new AuthorityExcution(findAuthority,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 删除员工
     * @param staffMemberDto
     * @return
     */
    public AuthorityExcution deleteStaffMember(StaffMemberDto staffMemberDto) {
        int employees_id = staffMemberDto.getEmployees_id();
        int deleteStaffMember = authorityDao.deleteStaffMember(employees_id);
        if (deleteStaffMember > 0){
            return new AuthorityExcution(IndustryClassificationEnum.UPDATE_SUCCESS);
        }else {
            return new AuthorityExcution(IndustryClassificationEnum.UPDATE_FAIL);
        }
    }
}
