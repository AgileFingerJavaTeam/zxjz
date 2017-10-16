package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.AuthRoleDao;
import com.zxjz.dto.excution.AuthRoleExcution;
import com.zxjz.dto.in.AuthRoleDto;
import com.zxjz.entity.AuthRole;
import com.zxjz.enums.AuthRoleEnum;
import com.zxjz.service.AuthRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthRoleDao authRoleDao;



    public AuthRoleExcution AuthRole(AuthRoleDto authRoleDto) {
              int id = authRoleDto.getId();
        try {
            List<AuthRole> list = authRoleDao.findAuthRole(id);
            if (list == null) {
                list = new ArrayList<AuthRole>();
            }
            return new AuthRoleExcution(AuthRoleEnum.SUCCESS,list);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
