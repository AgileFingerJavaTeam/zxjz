package com.zxjz.service;

import com.zxjz.dto.excution.LoginExcution;
import com.zxjz.dto.in.LoginDto;

public interface LoginService {
    /**
     * 登陆页面
     * @param loginDto
     * @return
     */
    public LoginExcution findAccountInfo(LoginDto loginDto);
}
