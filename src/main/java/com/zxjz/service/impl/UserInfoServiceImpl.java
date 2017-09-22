package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.UserInfoDao;
import com.zxjz.dto.excution.UserInfoExcution;
import com.zxjz.dto.in.UserInfoDto;
import com.zxjz.entity.UserInfo;
import com.zxjz.enums.UserInfoEnum;
import com.zxjz.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoExcution login(UserInfoDto userInfoDto) {
        String username = userInfoDto.getUsername();
        String password = userInfoDto.getPassword();
        try{
            UserInfo userInfo = userInfoDao.getUserInfoByName(username);
            if (userInfo == null) {
                return new UserInfoExcution(UserInfoEnum.INNER_ERROR);
            }
            if (!password.equals(userInfo.getPassword())) {
                return new UserInfoExcution(UserInfoEnum.PSW_ERROR);
            }
            return new UserInfoExcution(UserInfoEnum.LOGIN_SUCCESS,userInfo);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
