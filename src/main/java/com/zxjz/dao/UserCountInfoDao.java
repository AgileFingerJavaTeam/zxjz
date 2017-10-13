package com.zxjz.dao;

import com.zxjz.entity.UserCountInfo;
import org.apache.ibatis.annotations.Param;

public interface UserCountInfoDao {
    /**
     * 密码登陆
     * @param phone
     * @param password
     * @return
     */
    public UserCountInfo getUserCountInfo(@Param("phone") String phone,
                                          @Param("password") String password);
}
