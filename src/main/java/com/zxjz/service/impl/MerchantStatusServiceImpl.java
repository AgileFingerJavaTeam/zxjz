package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.MerchantStatusDao;
import com.zxjz.dto.excution.MerchantStatusExcution;
import com.zxjz.dto.in.MerchantStatusDto;
import com.zxjz.entity.MerchantStatusOne;
import com.zxjz.entity.MerchantStatusThree;
import com.zxjz.entity.MerchantStatusTwo;
import com.zxjz.enums.MerchantStatusEnum;
import com.zxjz.service.MerchantStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Service
public class MerchantStatusServiceImpl implements MerchantStatusService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MerchantStatusDao merchantStatusDao;

    public MerchantStatusExcution findMerchantStatus(MerchantStatusDto merchantStatusDto) {
        int user_id = merchantStatusDto.getUser_id();
        String which = merchantStatusDto.getWhich();
        try {


            if (which.equals("1")) {
                List<MerchantStatusOne> merChantStatusOne = merchantStatusDao.findMerchantStatusOne(user_id);
                if (merChantStatusOne == null || merChantStatusOne.size()== 0) {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_NOT_STATE);
                } else {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_SUCCESS,merChantStatusOne,null,null);
                }
            } else if (which.equals("2")) {
                List<MerchantStatusTwo> merchantStatusTwo = merchantStatusDao.findMerchantStatusTwo(user_id);
                if (merchantStatusTwo == null || merchantStatusTwo.size()== 0) {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_NOT_STATE);
                } else {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_SUCCESS,null,merchantStatusTwo,null);
                }
            } else if (which.equals("3")) {
                List<MerchantStatusThree> merchantStatusThree = merchantStatusDao.findMerchantStatusThree(user_id);
                if (merchantStatusThree == null || merchantStatusThree.size()== 0) {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_NOT_STATE);
                } else {
                    return new MerchantStatusExcution(MerchantStatusEnum.COLLECTION_SUCCESS,null,null,merchantStatusThree);
                }
            }
            return new MerchantStatusExcution(MerchantStatusEnum.NO_PRAM);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
