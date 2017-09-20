package com.zxjz.service;

import com.zxjz.dto.excution.UserInfoExcution;
import com.zxjz.dto.in.UserInfoDto;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public interface UserInfoService {

    /**
     * 根据账户名称查询用户信息
     * @param userInfoDto
     * @return
     */
    public UserInfoExcution login(UserInfoDto userInfoDto);
}
