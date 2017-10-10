package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.RecruitmentDao;
import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.dto.in.PaypsdDto;
import com.zxjz.dto.in.RecruitmentDto;
import com.zxjz.entity.CheckBill;
import com.zxjz.entity.IsSetPassword;
import com.zxjz.entity.MerchantFundsCurrentAccount;
import com.zxjz.entity.Recruitment;
import com.zxjz.enums.RecruitmentEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.RecruitmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecruitmentDao recruitmentDao;
    /*
    * 发布职位
    *
    * */
    public RecruitmentExcution postjob(RecruitmentDto recruitmentDto) {
        int user_id = recruitmentDto.getUser_id();
        String settlement_method = recruitmentDto.getSettlement_method();
        String salary_treatment = recruitmentDto.getSalary_treatment();
        String benefits = recruitmentDto.getBenefits();
        int city = recruitmentDto.getCity();
        String commission = recruitmentDto.getCommission();
        String gender_requirements = recruitmentDto.getGender_requirements();
        String hiring_expiration_date = recruitmentDto.getHiring_expiration_date();
        String leader = recruitmentDto.getLeader();
        String leader_phone = recruitmentDto.getLeader_phone();
        String position_latitude = recruitmentDto.getPosition_latitude();
        String position_longitude = recruitmentDto.getPosition_longitude();
        int post_classification = recruitmentDto.getPost_classification();
        int recruitment = recruitmentDto.getRecruitment();
        String post_name = recruitmentDto.getPost_name();
        String work_content = recruitmentDto.getWork_content();
        String work_date = recruitmentDto.getWork_date();
        String work_location = recruitmentDto.getWork_location();
        String work_time = recruitmentDto.getWork_time();
        try {
            int addPsostJob = recruitmentDao.addPsostJob(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
            if(addPsostJob>0){
                return new  RecruitmentExcution(RecruitmentEnum.ADD_JOB_SUCCESS);
            }else{
                throw  new InsertInnerErrorException("职位发布失败");
            }
        } catch (InsertInnerErrorException i) {
            throw i;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /*
   * 草稿
   *
   * */
    public RecruitmentExcution postjobcopy(RecruitmentDto recruitmentDto) {
        int user_id = recruitmentDto.getUser_id();
        String settlement_method = recruitmentDto.getSettlement_method();
        String salary_treatment = recruitmentDto.getSalary_treatment();
        String commission = recruitmentDto.getCommission();
        String benefits = recruitmentDto.getBenefits();
        String position_longitude = recruitmentDto.getPosition_longitude();
        String position_latitude = recruitmentDto.getPosition_latitude();
        String work_location = recruitmentDto.getWork_location();
        String work_date = recruitmentDto.getWork_date();
        String work_time = recruitmentDto.getWork_time();
        int recruitment = recruitmentDto.getRecruitment();
        String gender_requirements = recruitmentDto.getGender_requirements();
        String work_content = recruitmentDto.getWork_content();
        String hiring_expiration_date = recruitmentDto.getHiring_expiration_date();
        String leader = recruitmentDto.getLeader();
        int city = recruitmentDto.getCity();
        int recruiting_id=recruitmentDto.getRecruiting_id();
        String leader_phone = recruitmentDto.getLeader_phone();
        int post_classification = recruitmentDto.getPost_classification();
        String post_name = recruitmentDto.getPost_name();
        try {
            Recruitment recruID=recruitmentDao.findRecruID(recruiting_id);
            if(recruID!=null){
                int updateJobcopy=recruitmentDao.updateJobcopy(recruiting_id);
                if(updateJobcopy>0){
                    return  new RecruitmentExcution(RecruitmentEnum.UPDATE_SUCCESS);
                }else{
                    throw new UpdateInnerErrorException("更改状态失败");
                }
            }else {
                int addPostJobcopy=recruitmentDao.addPostJobcopy(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
                if(addPostJobcopy>0){
                    return  new RecruitmentExcution(RecruitmentEnum.SAVE_JOB_COPY_SUCCESS);
                }else {
                    throw new InsertInnerErrorException("保存草稿失败");
                }
            }
        }catch (UpdateInnerErrorException u) {
            throw u;
        }catch (InsertInnerErrorException i) {
            throw i;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public RecruitmentExcution postfailure(RecruitmentDto recruitmentDto) {
        int user_id = recruitmentDto.getUser_id();
        String settlement_method = recruitmentDto.getSettlement_method();
        String salary_treatment = recruitmentDto.getSalary_treatment();
        String commission = recruitmentDto.getCommission();
        String benefits = recruitmentDto.getBenefits();
        String position_longitude = recruitmentDto.getPosition_longitude();
        String position_latitude = recruitmentDto.getPosition_latitude();
        String work_location = recruitmentDto.getWork_location();
        String work_date = recruitmentDto.getWork_date();
        String work_time = recruitmentDto.getWork_time();
        int recruitment = recruitmentDto.getRecruitment();
        String gender_requirements = recruitmentDto.getGender_requirements();
        String work_content = recruitmentDto.getWork_content();
        String hiring_expiration_date = recruitmentDto.getHiring_expiration_date();
        String leader = recruitmentDto.getLeader();
        int city = recruitmentDto.getCity();
        int recruiting_id=recruitmentDto.getRecruiting_id();
        String leader_phone = recruitmentDto.getLeader_phone();
        int post_classification = recruitmentDto.getPost_classification();
        String post_name = recruitmentDto.getPost_name();
        String status_time=recruitmentDto.getStatus_time();
        try{
            Recruitment status =recruitmentDao.status(recruiting_id);
                int data=0;
                if (status==null){
                    throw  new  UpdateInnerErrorException("更改状态失败");
                }else{
                    if (status.equals("草稿") || status.equals("已驳回")) {
                        int updataStatus =recruitmentDao.updateStatus(status_time, user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
                        if(updataStatus>0){
                            return  new RecruitmentExcution(RecruitmentEnum.UPDATE_SUCCESS);
                        }else{
                            throw new UpdateInnerErrorException("更改状态失败");
                        }
                    }else if (status.equals("已通过")) {
                        data=recruitmentDao.insertData(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
                        if(data>0){
                            return  new RecruitmentExcution(RecruitmentEnum.SUCCESS);
                        }else{
                            throw new InsertInnerErrorException("新增失败");
                        }
                    }
                }
        }catch (UpdateInnerErrorException u){
            throw u;
        }catch (InsertInnerErrorException i){
            throw i;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
        return null;
    }

    /*
  * 编辑草稿
  *
  * */
    public RecruitmentExcution editpostjobcopy(RecruitmentDto recruitmentDto) {
        int user_id = recruitmentDto.getUser_id();
        String settlement_method = recruitmentDto.getSettlement_method();
        String salary_treatment = recruitmentDto.getSalary_treatment();
        String commission = recruitmentDto.getCommission();
        String benefits = recruitmentDto.getBenefits();
        String position_longitude = recruitmentDto.getPosition_longitude();
        String position_latitude = recruitmentDto.getPosition_latitude();
        String work_location = recruitmentDto.getWork_location();
        String work_date = recruitmentDto.getWork_date();
        String work_time = recruitmentDto.getWork_time();
        int recruitment = recruitmentDto.getRecruitment();
        String gender_requirements = recruitmentDto.getGender_requirements();
        String work_content = recruitmentDto.getWork_content();
        String hiring_expiration_date = recruitmentDto.getHiring_expiration_date();
        String leader = recruitmentDto.getLeader();
        int city = recruitmentDto.getCity();
        int recruiting_id=recruitmentDto.getRecruiting_id();
        String leader_phone = recruitmentDto.getLeader_phone();
        int post_classification = recruitmentDto.getPost_classification();
        String post_name = recruitmentDto.getPost_name();
        try {
            String audit_status="草稿";
            Recruitment applyStatus=recruitmentDao.findStatus(recruiting_id);
            if(applyStatus!=null){
               if(applyStatus.equals("草稿")||applyStatus.equals("待审核")){
                int updateStatus=recruitmentDao.updateStatusC(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
                if(updateStatus>0){
                    return  new RecruitmentExcution(RecruitmentEnum.UPDATE_SUCCESS);
                }else {
                    throw  new  UpdateInnerErrorException("更改状态失败");
                }
               }else if (applyStatus.equals("已通过")){
                int  data =recruitmentDao.addData(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
                if(data>0){
                    return  new RecruitmentExcution(RecruitmentEnum.SUCCESS);
                }
               }else {
                    throw  new InsertInnerErrorException("插入数据失败");
               }
            }else{
                throw new QueryInnerErrorException("担保职位不可编辑");
            }
        }catch (UpdateInnerErrorException u) {
            throw u;
        }catch (InsertInnerErrorException i) {
            throw i;
        }catch (QueryInnerErrorException q) {
            throw q;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
        return null;
    }

    /*
 * 编辑职位
 *
 * */
    public RecruitmentExcution editJob(RecruitmentDto recruitmentDto) {
        int user_id = recruitmentDto.getUser_id();
        String settlement_method = recruitmentDto.getSettlement_method();
        String salary_treatment = recruitmentDto.getSalary_treatment();
        String commission = recruitmentDto.getCommission();
        String benefits = recruitmentDto.getBenefits();
        String position_longitude = recruitmentDto.getPosition_longitude();
        String position_latitude = recruitmentDto.getPosition_latitude();
        String work_location = recruitmentDto.getWork_location();
        String work_date = recruitmentDto.getWork_date();
        String work_time = recruitmentDto.getWork_time();
        int recruitment = recruitmentDto.getRecruitment();
        String gender_requirements = recruitmentDto.getGender_requirements();
        String work_content = recruitmentDto.getWork_content();
        String hiring_expiration_date = recruitmentDto.getHiring_expiration_date();
        String leader = recruitmentDto.getLeader();
        int city = recruitmentDto.getCity();
        int recruiting_id=recruitmentDto.getRecruiting_id();
        String leader_phone = recruitmentDto.getLeader_phone();
        int post_classification = recruitmentDto.getPost_classification();
        String post_name = recruitmentDto.getPost_name();
        try {
            int editjob=recruitmentDao.updatejob(user_id, post_name, settlement_method, salary_treatment, commission, benefits, position_longitude, position_latitude, work_location, work_date, work_time, recruitment, gender_requirements, work_content, hiring_expiration_date, leader, leader_phone, post_classification,city);
            if(editjob>0){
                int editpostjob=recruitmentDao.updatepostjob(recruiting_id);
                if(editpostjob>0){
                    return  new RecruitmentExcution(RecruitmentEnum.SUCCESS);
                }else {
                    throw  new UpdateInnerErrorException("更改失败");
                }
            }else {
                throw  new InsertInnerErrorException("插入失败");
            }
        }catch (UpdateInnerErrorException u) {
            throw u;
        }catch (InsertInnerErrorException i) {
            throw i;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }


    public RecruitmentExcution setpaypsd(PaypsdDto paypsdDto) {
        int user_id = paypsdDto.getUser_id();
        int is_need_psw = paypsdDto.getIs_need_psw();
        int not_need_psw_period = paypsdDto.getNot_need_psw_period();
        String pay_psw = paypsdDto.getPay_psw();
        try {
            IsSetPassword issetpsd = recruitmentDao.findIsPayPswByUserId(user_id);
            if (issetpsd == null) {
                int flag = recruitmentDao.savePayPswByUserId(pay_psw, not_need_psw_period, is_need_psw, user_id);
                if (flag > 0) {
                    return new RecruitmentExcution(RecruitmentEnum.ADD_PSW_SUCCESS);
                } else {
                    return new RecruitmentExcution(RecruitmentEnum.ADD_PSW_FAIL);
                }
            } else {
                int flag = recruitmentDao.updatePayPswByUserId(pay_psw, not_need_psw_period, is_need_psw, user_id);
                if (flag > 0) {
                    return new RecruitmentExcution(RecruitmentEnum.UPDATE_PSW_SUCCESS);
                } else {
                    return new RecruitmentExcution(RecruitmentEnum.UPDATE_PSW_FAIL);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    @Transactional
    public RecruitmentExcution tradingRecord(PaypsdDto paypsdDto) {
        int user_id = paypsdDto.getUser_id();
        List<MerchantFundsCurrentAccount> merchantFundsCurrentAccountInfoList = recruitmentDao.findListTradingRecord(user_id);
        if (merchantFundsCurrentAccountInfoList == null) {
            return null;
        }
        for (MerchantFundsCurrentAccount info : merchantFundsCurrentAccountInfoList) {
            if (info.getReferenceBillClassification().equals("平台代付工资")) {
                info.setIsPayWages("是");
                int student_id = info.getTargetId();
                int work_id = info.getWorkId();
                MerchantFundsCurrentAccount studentPartInfo = recruitmentDao.findTradingRecord(student_id);
                if (studentPartInfo != null) {
                    info.setName(studentPartInfo.getName());
                    info.setHeadPic(studentPartInfo.getHeadPic());
                }
                MerchantFundsCurrentAccount workInfo = recruitmentDao.findTradingRecords(work_id);
                if (workInfo != null) {
                    info.setPostName(workInfo.getPostName());
                }
            } else if (info.getReferenceBillClassification().equals("充值")) {
                int references_the_bill_id = info.getReferencesTheBillId();
                int references_the_internal_serial_number1 = info.getReferencesTheInternalSerialNumber1();
                MerchantFundsCurrentAccount merchantFundsCurrentAccountInfo = recruitmentDao.findMerchantRecharge(references_the_bill_id, references_the_internal_serial_number1);
                if (merchantFundsCurrentAccountInfo != null) {
                    info.setRechargeMode(merchantFundsCurrentAccountInfo.getRechargeMode());
                }
            } else if (info.getReferenceBillClassification().equals("提现")) {
                int references_the_bill_id = info.getReferencesTheBillId();
                int references_the_internal_serial_number1 = info.getReferencesTheInternalSerialNumber1();
                MerchantFundsCurrentAccount merchantFundsCurrentAccountInfo = recruitmentDao.findMerchantTX(references_the_bill_id, references_the_internal_serial_number1);
                if (merchantFundsCurrentAccountInfo != null) {
                    info.setCashWithdrawal(merchantFundsCurrentAccountInfo.getCashWithdrawal());
                }
            }
        }
        return null;
    }

    public RecruitmentExcution checkBill(CheckBillDto checkBillDto) {
        int student_user_id = checkBillDto.getStudent_user_id();
        int user_id = checkBillDto.getUser_id();
        try {
            List<CheckBill> findList = recruitmentDao.findListCheckBill(student_user_id, user_id);
            if (findList == null) {
                return new RecruitmentExcution(RecruitmentEnum.COLLECTION_NOT_STATE);
            } else {
                return new RecruitmentExcution(RecruitmentEnum.COLLECTION_SUCCESS,findList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
