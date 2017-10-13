package com.zxjz.service;

import com.zxjz.dto.excution.CodeExcution;
import com.zxjz.dto.excution.UpdatePwdExcution;
import com.zxjz.dto.excution.UserCountExcution;
import com.zxjz.dto.in.CodeDto;
import com.zxjz.dto.in.UpdateByIdDto;
import com.zxjz.dto.in.UpdatePwdDto;
import com.zxjz.dto.in.UserCountDto;

public interface UserCountService {
    /**
     * 密码登陆
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByPhoneAndPwd(UserCountDto userCountDto);

    /**
     * 根据微信账号登陆接口
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByWechatID(UserCountDto userCountDto);

    /**
     * 根据QQ账号登陆接口
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByQQID(UserCountDto userCountDto);

    /**
     * 发送手机验证码
     * @param codeDto
     * @return
     */
    public CodeExcution findVerifyCode(CodeDto codeDto);

    /**
     * 验证码登陆
     * @param codeDto
     * @return
     */
    public UserCountExcution findUserByPhone(CodeDto codeDto);

    /**
     * 注册 验证验证码
     * @param codeDto
     * @return
     */
    public UserCountExcution getUserByPhone(CodeDto codeDto);

    /**
     * 注册
     * @param userCountDto
     * @return
     */
    public UserCountExcution insertUserCount(UserCountDto userCountDto);

    /**
     * 找回密码
     * @return
     */
    public UpdatePwdExcution updataPwdByPhone(UpdatePwdDto updatePwdDto);

    /**
     * 设置密码
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution findUserById(UpdatePwdDto updatePwdDto);

    /**
     * 获取个人信息
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution postUserById(UpdatePwdDto updatePwdDto);

    /**
     * 获取个人信息(贾)
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution getUserById(UpdatePwdDto updatePwdDto);

    /**
     * 保存个人基本信息
     * @param updateByIdDto
     * @return
     */
    public UserCountExcution updateById(UpdateByIdDto updateByIdDto);

    /**
     * 根据ID查询学生信息
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution saveUserById(UpdatePwdDto updatePwdDto);
}
