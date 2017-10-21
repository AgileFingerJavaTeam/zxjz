package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.MerchantsInfoDao;
import com.zxjz.dao.MerchantsUpgadeDao;
import com.zxjz.dto.excution.MerchantsAffirmStudentBreakPromiseExcution;
import com.zxjz.dto.excution.MerchantsChangeHeadExcution;
import com.zxjz.dto.excution.MerchantsInfoExcution;
import com.zxjz.dto.excution.MerchantsUpgradeExcution;
import com.zxjz.dto.in.MerchantsAffirmStudentBreakPromiseDto;
import com.zxjz.dto.in.MerchantsChangeHeadDto;
import com.zxjz.dto.in.MerchantsInfoDto;
import com.zxjz.dto.in.MerchantsUpgradeDto;
import com.zxjz.entity.MerchantsAccount;
import com.zxjz.entity.MerchantsInfo;
import com.zxjz.entity.MerchantsUpgrade;
import com.zxjz.enums.MerchantsAffirmStudentBreakPromiseEnum;
import com.zxjz.enums.MerchantsChangeHeadEnum;
import com.zxjz.enums.MerchantsInfoEnum;
import com.zxjz.enums.MerchantsUpgradeEnum;
import com.zxjz.exception.*;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.MerchantsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class MerchantsInfoServiceImpl implements MerchantsInfoService {
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MerchantsInfoDao merchantsInfoDao;
    @Autowired
    private MerchantsUpgadeDao merchantsUpgadeDao;
//---------获取商户个人信息
    public MerchantsInfoExcution findEmpolyerInfoById(MerchantsInfoDto merchantsInfoDto) {
        int user_id = merchantsInfoDto.getUserId();
        try {
            MerchantsInfo merchantsInfo = merchantsInfoDao.findEmpolyerInfoById(user_id);
            if (merchantsInfo == null){
                throw new FindDatabaseException("从数据库中获取商户信息失败");
            }
            return new MerchantsInfoExcution(MerchantsInfoEnum.INQUIRE_SUCCESS,merchantsInfo);
        }catch (FindDatabaseException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
//    确认员工爽约
    @Transactional
     public MerchantsAffirmStudentBreakPromiseExcution confirmStudentMiss(MerchantsAffirmStudentBreakPromiseDto merchantsAffirmStudentBreakPromiseDto){
         int id = merchantsAffirmStudentBreakPromiseDto.getId();
         try {
             int isUpdateState = merchantsInfoDao.UpdateStateById(id);
             if (isUpdateState == 0){
                 throw  new UpdateInnerErrorException("更新员工是否爽约状态失败");
             }else{
                 MerchantsAccount RIdAndStuId = merchantsInfoDao.findRecruitingIdAndStudentIdById(id);
                 if (RIdAndStuId == null){
                     throw new QueryInnerErrorException("查询招聘ID和学生ID失败");
                 }else {
                     int recruiting_id = RIdAndStuId.getRecruitingId();
                     int student_user_id = RIdAndStuId.getStudentUserId();
                     int isUpdateWorkBase = merchantsInfoDao.updateWorkBaseInfo(recruiting_id,student_user_id);
                     if (isUpdateWorkBase == 0){
                         throw new UpdateDatabaseException("更新关闭工作状态失败");
                     }else{
                         int isUpdateMissNumber = merchantsInfoDao.updateStudentMissNumber(student_user_id);
                         if (isUpdateMissNumber == 0){
                             throw new UpdateStuMissException("更新学生爽约次数失败");
                         }
                     }
                 }
             }
             return new MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum.AFFIRM_SUCCESS);
         }catch (UpdateInnerErrorException e1){
             throw e1;
         }catch (InsertInnerErrorException e2){
             throw e2;
         }catch (UpdateDatabaseException e3){
             throw e3;
         }catch (UpdateStuMissException e4){
             throw e4;
         }catch (Exception e) {
             logger.error(e.getMessage(), e);
             throw new BaseException(e.getMessage());
         }
     }
//     变更负责人
    public MerchantsChangeHeadExcution changeHead (MerchantsChangeHeadDto merchantsChangeHeadDto){
        String head = merchantsChangeHeadDto.getHead();
        String job = merchantsChangeHeadDto.getJob();
        String phone = merchantsChangeHeadDto.getPhone();
        int userId = merchantsChangeHeadDto.getUserId();
        try {
            int result = merchantsInfoDao.updateHeadInfoByUserId(head,job,phone,userId);
            if(result == 0){
                throw new UpdateDatabaseException("更新数据库负责人数据失败");
            }
            return new MerchantsChangeHeadExcution(MerchantsChangeHeadEnum.CHANGE_SUCCESS);
        }catch (UpdateDatabaseException e1){
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }


    //    账户升级申请
    public MerchantsUpgradeExcution upgradeAccount(MerchantsUpgradeDto merchantsUpgradeDto) {
        int userId = merchantsUpgradeDto.getUserId();
        try {
            MerchantsUpgrade id = merchantsUpgadeDao.findUserById(userId);
            if (id != null){
                throw new RepeatApplyException("重复申请");
            }
            int isAdd = merchantsUpgadeDao.addADataById(userId);
            if (isAdd == 0) {
               throw new ApplyFailException("数据库内部错误");
            }
            return new MerchantsUpgradeExcution(MerchantsUpgradeEnum.APPLY_SUCCESS);
        }catch (RepeatApplyException e1){
            throw e1;
        }catch (ApplyFailException e2){
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询申请VIP商户申请信息
     * @param merchantsUpgradeDto
     * @return
     */
    public MerchantsUpgradeExcution showAuditPage(MerchantsUpgradeDto merchantsUpgradeDto) {
        int user_id = merchantsUpgradeDto.getId();
        try {
            MerchantsUpgrade merchantsUpgrade = merchantsUpgadeDao.findEmInfo(user_id);
            if (merchantsUpgrade == null){
                throw new QueryInnerErrorException("数据库内部错误查询申请VIP商户申请信息失败");
            }
            return new MerchantsUpgradeExcution(MerchantsUpgradeEnum.FIND_SUCCESS,merchantsUpgrade);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询申请VIP商户列表
     * @param merchantsUpgradeDto
     * @return
     */
    public MerchantsUpgradeExcution findApplyVipShopList(MerchantsUpgradeDto merchantsUpgradeDto) {
        int page = merchantsUpgradeDto.getPage();
        int rows = merchantsUpgradeDto.getRows();
        int offset = (page-1)*rows;
        int user_id = merchantsUpgradeDto.getUserId();
        String srt_approval_status1 = merchantsUpgradeDto.getSrt_approval_status1();
        String srt_search_content1 = merchantsUpgradeDto.getSrt_search_content1();
        try {
            List<MerchantsUpgrade> merchantsUpgradeList = merchantsUpgadeDao.findApplyVipList(srt_approval_status1,srt_search_content1,offset,rows);
            int merchantsCount = merchantsUpgadeDao.findApplyVipCount(srt_approval_status1,srt_search_content1);
            for (int i=0;i<merchantsUpgradeList.size();i++){
                MerchantsUpgrade info = merchantsUpgradeList.get(i);
//                String is_dispose = info.getIsDispose();
//                if(is_dispose.equals("已经受理")){
                    //查询受理人姓名
                    int acceptEmployeesId = Integer.parseInt(info.getAcceptEmployees());
                    String acceptEmployees = merchantsUpgadeDao.findAcceptEmployer(acceptEmployeesId);
                    info.setAcceptEmployees(acceptEmployees);
                    //查询操作人姓名
                    int OperatingStaffId = Integer.parseInt(info.getOperatingStaff());
                    String OperatingStaff = merchantsUpgadeDao.findOperatingEmployer(OperatingStaffId);
                    info.setOperatingStaff(OperatingStaff);
//            }
            }
            HashMap map = new HashMap();
            map.put("rows",merchantsUpgradeList);
            map.put("total",merchantsCount);
            return new MerchantsUpgradeExcution(MerchantsUpgradeEnum.FIND_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 审核
     * @param merchantsUpgradeDto
     * @return
     */
    public MerchantsUpgradeExcution confirmCheck(MerchantsUpgradeDto merchantsUpgradeDto) {
        int id = merchantsUpgradeDto.getId();
        int employees_name = merchantsUpgradeDto.getEmployees_name();
        int user_id = merchantsUpgradeDto.getUser_id();
        try {
            int isConfirmCheck = merchantsUpgadeDao.conrifmCheck(employees_name,id,user_id);
            if (isConfirmCheck == 0){
                throw new UpdateInnerErrorException("更新商户申请VIP受理状态失败（确认审核失败）");
            }
            return new MerchantsUpgradeExcution(MerchantsUpgradeEnum.CONFIRM_CHECK_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询员工列表
     * @return
     */
    public MerchantsUpgradeExcution findCheckEmployer() {
        try {
           List<MerchantsUpgrade> rows = merchantsUpgadeDao.findEmployerList();
           return new MerchantsUpgradeExcution(MerchantsUpgradeEnum.FIND_SUCCESS,rows);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
