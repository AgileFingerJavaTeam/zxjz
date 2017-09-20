package com.zxjz.dao;

import com.zxjz.entity.UserInfo;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public interface UserInfoDao {

    /**
     * 根据账户名称查询用户信息
     * @param username
     * @return
     */
    public UserInfo getUserInfoByName(String username);

}
