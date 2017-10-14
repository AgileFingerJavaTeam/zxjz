package com.zxjz.service.impl;

import com.zxjz.dao.UserCountInfoDao;
import com.zxjz.dto.excution.CodeExcution;
import com.zxjz.dto.excution.UpdatePwdExcution;
import com.zxjz.dto.excution.UserCountExcution;
import com.zxjz.dto.in.CodeDto;
import com.zxjz.dto.in.UpdateByIdDto;
import com.zxjz.dto.in.UpdatePwdDto;
import com.zxjz.dto.in.UserCountDto;
import com.zxjz.entity.UserCountInfo;
import com.zxjz.enums.CodeEnum;
import com.zxjz.enums.RegistrationEnum;
import com.zxjz.exception.FindPhonePasswordFailException;
import com.zxjz.exception.FindUserTypeFailException;
import com.zxjz.service.UserCountService;
import com.zxjz.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class UserCountServiceImpl implements UserCountService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserCountInfoDao userCountInfoDao;

    /**
     * 密码登陆
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByPhoneAndPwd(UserCountDto userCountDto) {
        String phone = userCountDto.getPhone();
        String psd = userCountDto.getPassword();
        UserCountInfo getUserCountInfo = userCountInfoDao.getUserCountInfo(phone,psd);
        if (getUserCountInfo == null){
            throw new FindPhonePasswordFailException("手机号或密码输入错误，请检查!");
        }
        String userType = getUserCountInfo.getUserType();
        if (userType.equals("商户")) {
            throw new FindUserTypeFailException("用户类型不对");
        } else {
            return new UserCountExcution(getUserCountInfo,RegistrationEnum.FIND_SUCCESS);
        }
    }

    /**
     * 微信登陆
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByWechatID(UserCountDto userCountDto) {
        String wechat_id = userCountDto.getWechat_id();
        String headimgurl = userCountDto.getHeadimgurl();
        UserCountInfo getUserByWechatID = userCountInfoDao.getUserByWechatID(wechat_id);
        if (getUserByWechatID == null){
            String recommendation_number = getStringRandom();
            boolean insertUserCountByWechat = userCountInfoDao.insertUserCountByWechat(wechat_id,headimgurl);
            if (insertUserCountByWechat){
                UserCountInfo getUserByWechatIDNew = userCountInfoDao.getUserByWechatID(wechat_id);
                return new UserCountExcution(getUserByWechatIDNew,RegistrationEnum.FIND_SUCCESS);
            }else{
                return new UserCountExcution(RegistrationEnum.FIND_ERROR);
            }
        }else {
            String userType = getUserByWechatID.getUserType();
            if (userType.equals("商户")){
                throw new FindUserTypeFailException("用户类型不对");
            } else {
                return new UserCountExcution(getUserByWechatID,RegistrationEnum.FIND_SUCCESS);
            }
        }
    }

    /**
     * QQ登陆
     * @param userCountDto
     * @return
     */
    public UserCountExcution findUserByQQID(UserCountDto userCountDto) {
        String qq_id = userCountDto.getQq_id();
        String headimgurl = userCountDto.getHeadimgurl();
        UserCountInfo findUserByQQID = userCountInfoDao.findUserByQQID(qq_id);
        if (findUserByQQID == null){
            String recommendation_number = getStringRandom();
            boolean insertUserCountByQQ = userCountInfoDao.insertUserCountByQQ(qq_id,headimgurl);
            if (insertUserCountByQQ){
                UserCountInfo findUserByQQIDNew = userCountInfoDao.findUserByQQID(qq_id);
                return new UserCountExcution(findUserByQQIDNew,RegistrationEnum.FIND_SUCCESS);
            }else{
                return new UserCountExcution(RegistrationEnum.FIND_ERROR);
            }
        }else {
            String userType = findUserByQQID.getUserType();
            if (userType.equals("商户")){
                throw new FindUserTypeFailException("用户类型不对");
            } else {
                return new UserCountExcution(findUserByQQID,RegistrationEnum.FIND_SUCCESS);
            }
        }
    }

    /**
     * 发送手机验证码
     * @param codeDto
     * @return
     */
    public CodeExcution findVerifyCode(CodeDto codeDto) {
        String phone = codeDto.getPhone();
        String verify_code = codeDto.getVerify_code();
        if (phone != null && phone.length() == 11){
            Random random = new Random();
            String code = random.nextInt(10000) + "";
            int codeLength = code.length();
            if (codeLength > 4){
                for (int i = 1; i <= 4 - codeLength; i++)
                    code = "0" + code;
            }
            String smsText = "职信兼职一次性验证码：" + code + "，不要告诉别人哦！";
            String url = "http://utf8.sms.webchinese.cn/?Uid=" + CodeEnum.MSG_UID + "&Key=" + CodeEnum.MSG_KEY
                    + "&smsMob=" + phone + "&smsText=" + smsText;
            String res = HttpClientUtil.doPost(url, null, "UTF-8");
            if ("1".equals(res)){
                String verifyCode = userCountInfoDao.findVerifyCode(phone);
                if (verifyCode != null){
                    int updateVerifyCode = userCountInfoDao.updateVerifyCode(verifyCode);
                    if (updateVerifyCode > 0){
                        return new CodeExcution(RegistrationEnum.SEND_NSG_SUCCESS, code);
                    }else{
                        return new CodeExcution(RegistrationEnum.SEND_NSG_FAIL);
                    }
                }else {
                    int verifyCodeNew = userCountInfoDao.insertVerifyCode(phone,verifyCode);
                    if (verifyCodeNew > 0){
                        return new CodeExcution(RegistrationEnum.SEND_NSG_SUCCESS, code);
                    }else {
                        return new CodeExcution(RegistrationEnum.SEND_NSG_FAIL);
                    }
                }
            }else{
                return new CodeExcution(RegistrationEnum.SEND_NSG_FAIL);
            }
        }else {
            return new CodeExcution(RegistrationEnum.NO_PRAM);
        }
    }

    /**
     * 验证码登陆
     * @param codeDto
     * @return
     */
    public UserCountExcution findUserByPhone(CodeDto codeDto) {
        String phone = codeDto.getPhone();
        String verify_code = codeDto.getVerify_code();
        UserCountInfo findUserByPhone = userCountInfoDao.findUserByPhone(phone);
        if (findUserByPhone == null){
            return new UserCountExcution(RegistrationEnum.NO_REGISTER);
        }
        String verifyCode = userCountInfoDao.findVerifyCode(phone);
        if (verify_code.equals(verifyCode)){
            String userType = findUserByPhone.getUserType();
            if (userType.equals("商户")){
                throw new FindUserTypeFailException("用户类型不对");
            }else {
                return new UserCountExcution(findUserByPhone,RegistrationEnum.FIND_SUCCESS);
            }
        }else {
            return new UserCountExcution(RegistrationEnum.NO_VERIFY_CODE);
        }
    }

    /**
     * 注册 验证验证码
     * @param codeDto
     * @return
     */
    public UserCountExcution getUserByPhone(CodeDto codeDto) {
        String phone = codeDto.getPhone();
        String verify_code = codeDto.getVerify_code();
        UserCountInfo findUserByPhone = userCountInfoDao.findUserByPhone(phone);
        if (findUserByPhone == null){
            String verifyCode = userCountInfoDao.findVerifyCode(phone);
            if (verify_code.equals(verifyCode)){
                return new UserCountExcution(RegistrationEnum.FIND_SUCCESS);
            }else {
                return new UserCountExcution(RegistrationEnum.NO_VERIFY_CODE);
            }
        }else {
            return new UserCountExcution(RegistrationEnum.ALREADY_REGISTER);
        }
    }

    /**
     * 注册
     * @param userCountDto
     * @return
     */
    public UserCountExcution insertUserCount(UserCountDto userCountDto) {
        String recommendation_number = getStringRandom();
        String phone = userCountDto.getPhone();
        String psd = userCountDto.getPassword();
        UserCountInfo findUserByPhone = userCountInfoDao.findUserByPhone(phone);
        if (findUserByPhone == null){
            boolean insertUserCount = userCountInfoDao.insertUserCount(phone,psd);
            if (insertUserCount){
                return new UserCountExcution(RegistrationEnum.REGISTER_SUCCESS);
            }else {
                return new UserCountExcution(RegistrationEnum.REGISTER_FAIL);
            }
        }else {
            return new UserCountExcution(RegistrationEnum.ALREADY_REGISTER);
        }
    }

    /**
     * 找回密码
     * @param updatePwdDto
     * @return
     */
    public UpdatePwdExcution updataPwdByPhone(UpdatePwdDto updatePwdDto) {
        String pwd = updatePwdDto.getNewPwd();
        String phone = updatePwdDto.getPhone();
        String verify_code = updatePwdDto.getVerify_code();
        UserCountInfo findUserByPhone = userCountInfoDao.findUserByPhone(phone);
        if (findUserByPhone == null){
            return new UpdatePwdExcution(RegistrationEnum.ALREADY_REGISTER);
        }
        String verifyCode = userCountInfoDao.findVerifyCode(phone);
        if (verify_code.equals(verifyCode)){
            int updataPwdByPhone = userCountInfoDao.updataPwdByPhone(pwd,phone);
            if (updataPwdByPhone > 0){
                return new UpdatePwdExcution(RegistrationEnum.MODIFICATION_SUCCESS);
            }else {
                return new UpdatePwdExcution(RegistrationEnum.MODIFICATION_ERROR);
            }
        }else {
            return new UpdatePwdExcution(RegistrationEnum.NO_VERIFY_CODE);
        }
    }

    /**
     * 设置密码
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution findUserById(UpdatePwdDto updatePwdDto) {
        String userID = updatePwdDto.getUserID();
        String newPwd = updatePwdDto.getNewPwd();
        String pwd = updatePwdDto.getPassword();
        int user_id = Integer.parseInt(userID);
        UserCountInfo findUserById = userCountInfoDao.findUserById(user_id);
        if (findUserById == null){
            return new UserCountExcution(RegistrationEnum.PHONEADNPWD_ERROR);
        }
        String phone_pwd = findUserById.getPhonePassword();
        if (pwd.equals(phone_pwd)){
            if (newPwd.equals(phone_pwd)){
                return new UserCountExcution(RegistrationEnum.NEWPADTHEOLDPAD);
            }
            int updatePwdById = userCountInfoDao.updatePwdById(newPwd,user_id);
            if (updatePwdById > 0){
                return new UserCountExcution(RegistrationEnum.MODIFICATION_SUCCESS);
            }else {
                return new UserCountExcution(RegistrationEnum.MODIFICATION_ERROR);
            }
        }else {
            return new UserCountExcution(RegistrationEnum.PSD_ERROR);
        }
    }

    /**
     * 获取个人信息
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution postUserById(UpdatePwdDto updatePwdDto) {
        String userID = updatePwdDto.getUserID();
        int user_id = Integer.parseInt(userID);
        UserCountInfo findUserById = userCountInfoDao.findUserById(user_id);
        if (findUserById == null){
            return new UserCountExcution(RegistrationEnum.FIND_SUCCESS);
        }else {
            return new UserCountExcution(RegistrationEnum.FIND_ERROR);
        }
    }

    /**
     * 获取个人信息(贾)
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution getUserById(UpdatePwdDto updatePwdDto) {
        String userID = updatePwdDto.getUserID();
        int user_id = Integer.parseInt(userID);
        UserCountInfo findUserById = userCountInfoDao.findUserById(user_id);
        if (findUserById == null){
            return new UserCountExcution(RegistrationEnum.FIND_SUCCESS);
        }else {
            return new UserCountExcution(RegistrationEnum.FIND_ERROR);
        }
    }

    /**
     * 保存个人基本信息
     * @param updateByIdDto
     * @return
     */
    public UserCountExcution updateById(UpdateByIdDto updateByIdDto) {
        String userID = updateByIdDto.getUserID();
        int user_id = Integer.parseInt(userID);
        String name = updateByIdDto.getName();
        String phone = updateByIdDto.getPhone();
        String head_pic = updateByIdDto.getHead_pic();
        String sex = updateByIdDto.getSex();
        String birthday = updateByIdDto.getBirthday();
        String email = updateByIdDto.getEmail();
        String school = updateByIdDto.getSchool();
        String enrollment_year = updateByIdDto.getEnrollment_year();
        String college = updateByIdDto.getCollege();
        String system = updateByIdDto.getSystem();
        String sch_class = updateByIdDto.getSch_class();
        String major = updateByIdDto.getMajor();
        String qqNum = updateByIdDto.getQqNum();
        String weixinNum = updateByIdDto.getWeixinNum();
        String stu_number = updateByIdDto.getStu_number();
        String height = updateByIdDto.getHeight();
        String weight = updateByIdDto.getWeight();
        String blood = updateByIdDto.getBlood();
        String constellation = updateByIdDto.getConstellation();
        String selfdescription = updateByIdDto.getSelfdescription();
        UserCountInfo findUserById = userCountInfoDao.findUserById(user_id);
        if (findUserById == null){
            return new UserCountExcution(RegistrationEnum.NO_USER_INFO);
        }
        boolean updateById = userCountInfoDao.updateById(user_id,name,phone,head_pic,sex,birthday,email,school,enrollment_year,college,system,sch_class,major,qqNum,weixinNum,stu_number,height,weight,blood,constellation,selfdescription);
        if (updateById){
            return new UserCountExcution(RegistrationEnum.SAVE_USER_INFO_SUCCESS);
        }else {
            return new UserCountExcution(RegistrationEnum.SAVE_USER_INFO_FAIL);
        }
    }

    /**
     * 根据ID查询学生信息
     * @param updatePwdDto
     * @return
     */
    public UserCountExcution saveUserById(UpdatePwdDto updatePwdDto) {
        String userID = updatePwdDto.getUserID();
        int user_id = Integer.parseInt(userID);
        UserCountInfo findUserById = userCountInfoDao.findUserById(user_id);
        if (findUserById == null){
            return new UserCountExcution(RegistrationEnum.FIND_SUCCESS);
        }else {
            return new UserCountExcution(RegistrationEnum.FIND_ERROR);
        }
    }


    //生成随机数字和字母,
    public String getStringRandom() {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < 12; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
