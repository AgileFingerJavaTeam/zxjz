package com.zxjz.service.impl;

import com.zxjz.dao.MerchantAccountDao;
import com.zxjz.dto.excution.MerchantAccountExcution;
import com.zxjz.dto.excution.MerchantApprovalStatusExcution;
import com.zxjz.dto.excution.UpdatePwdByPhoneExcution;
import com.zxjz.dto.in.*;
import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.entity.MerchantApprovalStatusInfo;
import com.zxjz.enums.RegistrationEnum;
import com.zxjz.exception.*;
import com.zxjz.service.MerchantAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MerchantAccountServiceImpl implements MerchantAccountService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MerchantAccountDao merchantAccountDao;

    /**
     * 手机号密码登陆接口
     *
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findMerchantAccountinfo(MerchantAccountDto merchantAccountDto) {
        String phone = merchantAccountDto.getPhone();
        String paw = merchantAccountDto.getPassword();
        MerchantAccountInfo findMerchantAccountInfo = merchantAccountDao.getMerchantAccountInfo(phone, paw);
        if (findMerchantAccountInfo == null) {
            throw new FindPhonePasswordFailException("手机号或密码输入错误，请检查!");
        }
        String userType = findMerchantAccountInfo.getUserType();
        if (userType.equals("大学生")) {
            throw new FindUserTypeFailException("用户类型不对");
        } else {
            return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, findMerchantAccountInfo);
        }
    }

    /**
     * 验证码登陆接口
     *
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findUserByPhone(MerchantAccountDto merchantAccountDto) {
        String phone = merchantAccountDto.getPhone();
        String verifyCode = merchantAccountDto.getVerify_code();
        MerchantAccountInfo getUserByPhone = merchantAccountDao.getUserByPhone(phone);
        if (getUserByPhone == null) {
            throw new FindUserByPhoneFailException("手机号没有注册!");
        }
        String findVerifyCode = merchantAccountDao.getVerifyCode(phone);
        if (verifyCode.equals(findVerifyCode)) {
            String userType = getUserByPhone.getUserType();
            if (userType.equals("大学生")) {
                throw new FindUserTypeFailException("用户类型不对");
            } else {
                return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, getUserByPhone);
            }
        } else {
            throw new FindVerifyCodeException("验证码错误");
        }
    }

    /**
     * 微信登陆
     *
     * @param userByWechatIDDto
     * @return
     */
    public MerchantAccountExcution findUserByWechatID(UserByWechatIDDto userByWechatIDDto) {
        String wechat_id = userByWechatIDDto.getWechat_id();
        String headimgurl = userByWechatIDDto.getHeadimgurl();
        MerchantAccountInfo getUserByWechatID = merchantAccountDao.getUserByWechatID(wechat_id);
        if (getUserByWechatID == null) {
            boolean insertUserCountByWechat = merchantAccountDao.insertUserCountByWechat(wechat_id, headimgurl);
            if (insertUserCountByWechat) {
                MerchantAccountInfo getUserByWechatIDNew = merchantAccountDao.getUserByWechatID(wechat_id);
                return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, getUserByWechatIDNew);
            } else {
                throw new FindUserByWechatIDException("查询失败");
            }
        } else {
            String userType = getUserByWechatID.getUserType();
            if (userType.equals("大学生")) {
                throw new FindUserTypeFailException("用户类型不对");
            } else {
                return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, getUserByWechatID);
            }
        }
    }

    /**
     * 根据QQ账号登陆接口
     *
     * @param userByQQIDDto
     * @return
     */
    public MerchantAccountExcution findUserByQQID(UserByQQIDDto userByQQIDDto) {
        String qq_id = userByQQIDDto.getQq_id();
        String headimgurl = userByQQIDDto.getHeadimgurl();
        MerchantAccountInfo findUserByQQID = merchantAccountDao.getUserByQQID(qq_id);
        if (findUserByQQID == null) {
            boolean insertUserCountByQQ = merchantAccountDao.insertUserCountByQQ(qq_id, headimgurl);
            if (insertUserCountByQQ) {
                MerchantAccountInfo getUserByQQIDNew = merchantAccountDao.getUserByWechatID(qq_id);
                return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, getUserByQQIDNew);
            } else {
                throw new FindUserByWechatIDException("查询失败");
            }
        } else {
            String userType = findUserByQQID.getUserType();
            if (userType.equals("大学生")) {
                throw new FindUserTypeFailException("用户类型不对");
            } else {
                return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS, findUserByQQID);
            }
        }
    }

    /**
     * 注册
     *
     * @param merchantAccountDto
     * @return
     */
    public MerchantAccountExcution findRegistration(MerchantAccountDto merchantAccountDto) {
        String phone = merchantAccountDto.getPhone();
        String psd = merchantAccountDto.getPassword();
        String Verify_code = merchantAccountDto.getVerify_code();
        MerchantAccountInfo findRegistration = merchantAccountDao.getUserByQQID(phone);
        if (findRegistration == null) {
            String findVerifyCode = merchantAccountDao.getVerifyCode(phone);
            if (findVerifyCode.equals(Verify_code)) {
                boolean insertUserCount = merchantAccountDao.insertUserCount(phone, psd);
                if (insertUserCount) {
                    return new MerchantAccountExcution(RegistrationEnum.REGISTER_SUCCESS);
                } else {
                    return new MerchantAccountExcution(RegistrationEnum.REGISTER_FAIL);
                }
            } else {
                return new MerchantAccountExcution(RegistrationEnum.NO_VERIFY_CODE);
            }
        } else {
            return new MerchantAccountExcution(RegistrationEnum.FIND_ERROR);
        }
    }

    /**
     * 找回密码接口
     *
     * @param merchantAccountDto
     * @return
     */
    public UpdatePwdByPhoneExcution updatePwdByPhone(MerchantAccountDto merchantAccountDto) {
        String phone = merchantAccountDto.getPhone();
        String verify_code = merchantAccountDto.getVerify_code();
        MerchantAccountInfo getUserByPhone = merchantAccountDao.getUserByPhone(phone);
        if (getUserByPhone == null) {
            return new UpdatePwdByPhoneExcution(RegistrationEnum.NO_REGISTER);
        } else {
            String getVerifyCode = merchantAccountDao.getVerifyCode(phone);
            if (getVerifyCode.equals(verify_code)) {
                int updataPwdByPhone = merchantAccountDao.updataPwdByPhone(phone);
                if (updataPwdByPhone > 0) {
                    return new UpdatePwdByPhoneExcution(RegistrationEnum.MODIFICATION_SUCCESS);
                } else {
                    return new UpdatePwdByPhoneExcution(RegistrationEnum.MODIFICATION_ERROR);
                }
            } else {
                return new UpdatePwdByPhoneExcution(RegistrationEnum.NO_VERIFY_CODE);
            }
        }
    }

    /**
     * 修改密码接口
     * @param userByIdDto
     * @return
     */
    public MerchantAccountExcution findUserById(UserByIdDto userByIdDto) {
        String user_id = userByIdDto.getUser_id();
        int userID = Integer.parseInt(user_id);
        String password = userByIdDto.getPassword();
        String newPwd = userByIdDto.getNewPwd();
        MerchantAccountInfo getUserByPhone = merchantAccountDao.getUserByPhone(user_id);
        if (getUserByPhone == null) {
            throw new FindPhonePasswordFailException("手机号或密码输入错误，请检查!");
        } else {
            String phone_password = getUserByPhone.getPhonePassword();
            if (password.equals(phone_password)) {
                if (newPwd.equals(phone_password)) {
                    return new MerchantAccountExcution(RegistrationEnum.NEWPADTHEOLDPAD);
                } else {
                    int updatePwdById = merchantAccountDao.updatePwdById(userID);
                    if (updatePwdById > 0) {
                        return new MerchantAccountExcution(RegistrationEnum.MODIFICATION_SUCCESS);
                    } else {
                        return new MerchantAccountExcution(RegistrationEnum.MODIFICATION_ERROR);
                    }
                }
            }else{
                return new MerchantAccountExcution(RegistrationEnum.PSD_ERROR);
            }
        }
    }

    /**
     * 根据ID查询商家信息
     * @param userByIdDto
     * @return
     */
    public MerchantAccountExcution getUserById(UserByIdDto userByIdDto) {
        String user_id = userByIdDto.getUser_id();
        int userID = Integer.parseInt(user_id);
        MerchantAccountInfo findUserById = merchantAccountDao.getUserById(userID);
        if (findUserById == null){
            return new MerchantAccountExcution(RegistrationEnum.NO_USER_INFO);
        }else {
            return new MerchantAccountExcution(RegistrationEnum.FIND_SUCCESS);
        }
    }

    /**
     * 查询商家审核状态
     * @param merchantApprovalStatusDto
     * @return
     */
    public MerchantApprovalStatusExcution findApprovalStatusById(MerchantApprovalStatusDto merchantApprovalStatusDto) {
        int user_id = merchantApprovalStatusDto.getUser_id();
        MerchantApprovalStatusInfo getApprovalStatusById = merchantAccountDao.getApprovalStatusById(user_id);
        if (getApprovalStatusById == null){
            return new MerchantApprovalStatusExcution(RegistrationEnum.NO_USER_INFO);
        }else {
            return new MerchantApprovalStatusExcution(RegistrationEnum.FIND_SUCCESS);
        }
    }

    /**
     * 提交审核
     * @param approvalStatusByIdDto
     * @return
     */
    public MerchantAccountExcution findApprovalStatusById(ApprovalStatusByIdDto approvalStatusByIdDto) {
        int user_id = approvalStatusByIdDto.getUser_id();
        String logo_url = approvalStatusByIdDto.getLogo_url();
        String company_name = approvalStatusByIdDto.getCompany_name();
        String industry_involved = approvalStatusByIdDto.getIndustry_involved();
        String company_address = approvalStatusByIdDto.getCompany_address();
        String longitude = approvalStatusByIdDto.getLongitude();
        String latitude = approvalStatusByIdDto.getLatitude();
        String head = approvalStatusByIdDto.getHead();
        String job = approvalStatusByIdDto.getJob();
        String phone = approvalStatusByIdDto.getPhone();
        String url = approvalStatusByIdDto.getUrl();
        MerchantAccountInfo getUserById = merchantAccountDao.getUserById(user_id);
        MerchantApprovalStatusInfo getApprovalStatusById = merchantAccountDao.getApprovalStatusById(user_id);
        if (getUserById == null){
            return new MerchantAccountExcution(RegistrationEnum.NO_USER_INFO);
        }else {
            if (getApprovalStatusById == null){
                int insertApprovalInfo = merchantAccountDao.insertApprovalInfo(user_id,logo_url,company_name,industry_involved,company_address,longitude,latitude,head,job,phone,url);
                if (insertApprovalInfo > 0){
                    return new MerchantAccountExcution(RegistrationEnum.SUBMIT_SUCCESS);
                }else {
                    return new MerchantAccountExcution(RegistrationEnum.SUBMIT_FAIL);
                }
            }else {
                String status = getApprovalStatusById.getStatus();
                if (("等待审核").equals(status)){
                    return new MerchantAccountExcution(RegistrationEnum.APPROVALING_NOW);
                }else{
                    int insertApprovalInfo = merchantAccountDao.insertApprovalInfo(user_id,logo_url,company_name,industry_involved,company_address,longitude,latitude,head,job,phone,url);
                    if (insertApprovalInfo > 0){
                        return new MerchantAccountExcution(RegistrationEnum.SUBMIT_SUCCESS);
                    }else {
                        return new MerchantAccountExcution(RegistrationEnum.SUBMIT_FAIL);
                    }
                }
            }
        }
    }


}
