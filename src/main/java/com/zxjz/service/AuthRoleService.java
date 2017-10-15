package com.zxjz.service;

import com.zxjz.dto.excution.AuthRoleExcution;
import com.zxjz.dto.in.AuthRoleDto;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public interface AuthRoleService {

       public AuthRoleExcution AuthRole (AuthRoleDto authRoleDto);
}
