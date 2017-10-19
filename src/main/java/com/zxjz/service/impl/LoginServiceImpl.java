package com.zxjz.service.impl;

import com.zxjz.dao.LoginDao;
import com.zxjz.dto.excution.LoginExcution;
import com.zxjz.dto.in.LoginDto;
import com.zxjz.entity.EmployeeRightsInfo;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.LoginEnum;
import com.zxjz.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginServiceImpl implements LoginService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoginDao loginDao;

    public LoginExcution findAccountInfo(LoginDto loginDto) {
        String employees_num = loginDto.getEmployees_num();
        HttpSession session = getRequest().getSession();
        try{
            LandFallInfo findAccountInfo = loginDao.findAccountInfo(employees_num);
            if (findAccountInfo == null){
                return new LoginExcution(LoginEnum.ACCOUNTNUM_IS_NO);
            }else if (!findAccountInfo.getLoginPassword().equals(loginDto.getEmployees_num())){
                return new LoginExcution(LoginEnum.PAW_MISTAKE);
            }
            List<EmployeeRightsInfo> findMenuList = loginDao.findMenuList(employees_num);
            session.setAttribute("list",findMenuList);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return new LoginExcution(LoginEnum.LOG_IN_SUCESS);
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }
}
