package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StudentSetBoundPhoneDao;
import com.zxjz.dto.excution.StudentSetBoundPhoneExcution;
import com.zxjz.dto.in.StudentSetBoundPhoneDto;
import com.zxjz.entity.UserCountInfo;
import com.zxjz.enums.StudentSetBoundPhoneEnum;
import com.zxjz.service.StudentSetBoundPhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentSetBoundPhoneServiceImpl implements StudentSetBoundPhoneService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private StudentSetBoundPhoneDao studentSetBoundPhoneDao;

    public StudentSetBoundPhoneExcution setBoundPhone(StudentSetBoundPhoneDto studentSetBoundPhoneDto) {
        int user_id = studentSetBoundPhoneDto.getUser_id();
        int code = studentSetBoundPhoneDto.getCode();
        String phone = studentSetBoundPhoneDto.getPhone();
        String bound_phone = studentSetBoundPhoneDto.getBound_phone();
        String phone_password = studentSetBoundPhoneDto.getPhone_password();
        String verify_code = studentSetBoundPhoneDto.getVerify_code();
        try {
            //判断新手机号是否已经被绑定
            UserCountInfo PhoneInfo = studentSetBoundPhoneDao.findUserByPhone(phone);
            if (PhoneInfo==null){
                //校验验证码
                String verificationCode = studentSetBoundPhoneDao.findVerifyCode(phone);
                if (verify_code.equals(verificationCode)){
                    //判断是否第一次设置绑定手机号
                    if (code==1){
                        int setBoundPhone = studentSetBoundPhoneDao.AddBoundPhoneById(user_id,phone_password,phone,verify_code,code);
                        if (setBoundPhone > 0){
                            return new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.BOUND_SUCCESS);
                        }
                    }else {
                       UserCountInfo OldPhonePassword = studentSetBoundPhoneDao.findOldPhoneAndPasswordById(user_id);
                       String password = OldPhonePassword.getPhonePassword();
                       String boundPhone = OldPhonePassword.getBoundPhone();
                       if (password.equals(studentSetBoundPhoneDto.getPhone_password())&&boundPhone.equals(studentSetBoundPhoneDto.getBound_phone())){
                           int recomposeBoundPhone = studentSetBoundPhoneDao.recomposeBoundPhone(user_id,phone);
                           if (recomposeBoundPhone > 0){
                               return new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.RECOMPOSE_BOUNDPHONE_SUCCESS);
                           }

                       }else {
                           return new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.PASSWORD_ERROR);
                       }
                    }
                }else {
                    return new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.VERIFY_CODE_ERROR);
                }
            }else {
                return new StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum.BOUND_REPEAT);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
        return null;
    }
}
