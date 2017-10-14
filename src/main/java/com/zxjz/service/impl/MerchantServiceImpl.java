package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.MerchantDao;
import com.zxjz.dto.excution.MerchantExcution;
import com.zxjz.dto.excution.MerchantInformationExcution;
import com.zxjz.dto.in.MerchantDto;
import com.zxjz.entity.*;
import com.zxjz.enums.MerchantEnum;
import com.zxjz.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MerchantDao merchantDao;

    public MerchantExcution merchant(MerchantDto merchantDto) {
        int student_user_id = merchantDto.getStudent_user_id();
        int recruiting_id = merchantDto.getRecruiting_id();
        try {
            GuaranteePositionInfo guaranteePositionInfo = merchantDao.findBoutique(recruiting_id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("cruinfo", guaranteePositionInfo);
            if (student_user_id != 0) {
                RegistrationInfo reginfo = merchantDao.findReinfo(recruiting_id, student_user_id);
                InformationCollectionInfo mainfo = merchantDao.findMainfo(recruiting_id, student_user_id);
                if (reginfo != null && mainfo != null) {
                    map.put("is_enrol", "1");
                    map.put("is_collect", "1");
                    return new MerchantExcution(MerchantEnum.FIND_SUCCESS, map);
                } else if (reginfo != null && mainfo == null) {
                    map.put("is_enrol", "1");
                    map.put("is_collect", "0");
                    return new MerchantExcution(MerchantEnum.FIND_SUCCESS, map);
                } else if (reginfo == null && mainfo == null) {
                    map.put("is_enrol", "0");
                    map.put("is_collect", "0");
                    return new MerchantExcution(MerchantEnum.FIND_SUCCESS, map);
                } else {
                    map.put("is_enrol", "0");
                    map.put("is_collect", "1");
                    return new MerchantExcution(MerchantEnum.FIND_SUCCESS, map);
                }
            } else {
                return new MerchantExcution(MerchantEnum.FIND_SUCCESS, map);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MerchantExcution findOrdinaryMerchant(MerchantDto merchantDto) {
        int student_user_id = merchantDto.getStudent_user_id();
        int recruiting_id = merchantDto.getRecruiting_id();
        try {
            RecruitmentInfo cruinfo = merchantDao.findGuaRec(recruiting_id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("cruinfo", cruinfo);
            if (student_user_id != 0) {
                RegistrationInfo reginfo = merchantDao.findReinfo(recruiting_id, student_user_id);
                InformationCollectionInfo mainfo = merchantDao.findMainfo(recruiting_id, student_user_id);
                if (reginfo != null && mainfo != null) {
                    map.put("is_enrol", "1");
                    map.put("is_collect", "1");
                    return new MerchantExcution(MerchantEnum.ORDINARY_FIND_SUCCESS, map);
                } else if (reginfo != null && mainfo == null) {
                    map.put("is_enrol", "1");
                    map.put("is_collect", "0");
                    return new MerchantExcution(MerchantEnum.ORDINARY_FIND_SUCCESS, map);
                } else if (reginfo == null && mainfo == null) {
                    map.put("is_enrol", "0");
                    map.put("is_collect", "0");
                    return new MerchantExcution(MerchantEnum.ORDINARY_FIND_SUCCESS, map);
                } else {
                    map.put("is_enrol", "0");
                    map.put("is_collect", "1");
                    return new MerchantExcution(MerchantEnum.ORDINARY_FIND_SUCCESS, map);
                }
            } else {
                return new MerchantExcution(MerchantEnum.ORDINARY_FIND_SUCCESS, map);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MerchantInformationExcution findMerchantinfor(MerchantDto merchantDto) {
        int user_id = merchantDto.getUser_id();
        try {
            GetMerchantInfo merinfo = merchantDao.findMerchantInformation(user_id);
            return new MerchantInformationExcution(MerchantEnum.FIND_MERCHANT_SUCCESS, merinfo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }
}
