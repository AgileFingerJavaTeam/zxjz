package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.AddMerchantDao;
import com.zxjz.dto.excution.AddMerchantExcution;
import com.zxjz.dto.in.AddMerchantDto;
import com.zxjz.entity.AddMerchant;
import com.zxjz.enums.AddMerchantEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.AddMerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AddMerchantServiceImpl implements AddMerchantService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AddMerchantDao addMerchantDao;
    /**
     * 查询商户列表
     * @return
     */
    public AddMerchantExcution findMerchantList(AddMerchantDto addMerchantDto) {
        int page = addMerchantDto.getPage();
        int rows = addMerchantDto.getRows();
        int offset = (page-1)*rows;
        String search_content = addMerchantDto.getSearch_content();
        try {
            List<AddMerchant> merchantApprovalInfoList = addMerchantDao.findMerchantList(rows,offset,search_content);
            int merchantCount = addMerchantDao.findMerchantCount(search_content);
            HashMap map = new HashMap();
            map.put("rows",merchantApprovalInfoList);
            map.put("total",merchantCount);
            return new AddMerchantExcution(AddMerchantEnum.FIND_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 新增商户
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution insertMerchant(AddMerchantDto addMerchantDto){
        String merchantPhoneNum = addMerchantDto.getMerchantPhoneNum();
        try {
            int isAddIntoUserAccount = addMerchantDao.insertMerchantIntoTableUserCount(merchantPhoneNum);
            if(isAddIntoUserAccount == 0){
                throw new InsertInnerErrorException("新增商户到用户基本信息表失败");
            }
//            int merchantId = addMerchantDao.findMerchantId(merchantPhoneNum);
//            if (merchantId == 0){
//                throw new QueryInnerErrorException("查询商户ID失败");
//            }
//            int isAddIntoMerchantCount = addMerchantDao.insertMerchantIntoTableMerchantAccount(merchantId,merchantPhoneNum);
//            if (isAddIntoMerchantCount == 0){
//                throw new InsertInnerErrorException("新增商户到商户基本信息表失败");
//            }
            return new AddMerchantExcution(AddMerchantEnum.INERT_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
//        }catch (QueryInnerErrorException e2){
//            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
    /**
     * 查询当前选择商户的信息
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution findMerchantInfo(AddMerchantDto addMerchantDto) {
        int merchantId = addMerchantDto.getId();
        try {
            AddMerchant merchantInfo = addMerchantDao.findMerchantInfo(merchantId);
            return new AddMerchantExcution(AddMerchantEnum.FIND_SUCCESS,merchantInfo);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 编辑商户
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution editMerchant(AddMerchantDto addMerchantDto) {
        int merchantId = addMerchantDto.getMerchantId();
        String merchantPhoneNum = addMerchantDto.getMerchantPhoneNum();
        try {
            int isEditMerchant = addMerchantDao.editMerchant(merchantId,merchantPhoneNum);
            if (isEditMerchant == 0){
                throw new UpdateInnerErrorException("编辑商户失败");
            }
            return new AddMerchantExcution(AddMerchantEnum.EDIT_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
