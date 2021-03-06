package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.EnrollJobStatusInfoDao;
import com.zxjz.dto.excution.EnrollJobStatusExcution;
import com.zxjz.dto.excution.QuickSignUpExcution;
import com.zxjz.dto.excution.UpdateJobStatusExcution;
import com.zxjz.dto.in.EnrollJobStatusDto;
import com.zxjz.dto.in.QuickSignUpDto;
import com.zxjz.dto.in.UpdateJobStatusDto;
import com.zxjz.entity.EnrollJobStatus;
import com.zxjz.entity.QuickSignUp;
import com.zxjz.enums.EnrollJobStatusEnum;
import com.zxjz.exception.EnrollJobStatusException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.EnrollJobStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
@Service
public class EnrollJobStatusServiceImpl implements EnrollJobStatusService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EnrollJobStatusInfoDao enrollJobStatusInfoDao;

    //获取兼职状态
    public EnrollJobStatusExcution findEnrollJobStatus(EnrollJobStatusDto enrollJobStatusDto) {
        int recruiting_id = enrollJobStatusDto.getRecruiting_id();
        int student_user_id = enrollJobStatusDto.getStudent_user_id();

        try {
            EnrollJobStatus enrollJobStatus = enrollJobStatusInfoDao.findEnrollJobStatus(recruiting_id, student_user_id);
            if (enrollJobStatus == null) {
                throw new QueryInnerErrorException("查询兼职状态失败");
            }
            return new EnrollJobStatusExcution(EnrollJobStatusEnum.FIND_ENROLLJOBSTATUS_SUCCESS, enrollJobStatus);
        } catch (QueryInnerErrorException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    //修改入职状态
    @Transactional
    public UpdateJobStatusExcution updateJobStatus(UpdateJobStatusDto updateJobStatusDto) {
        int recruiting_id = updateJobStatusDto.getRecruiting_id();
        int student_user_id = updateJobStatusDto.getStudent_user_id();
        String students_confirmed = updateJobStatusDto.getStudents_confirmed();
        try {
            if (students_confirmed == null) {
                throw new EnrollJobStatusException("缺少参数");
            }
            String findJobNumber = enrollJobStatusInfoDao.findJobNumber(student_user_id);
            if (findJobNumber == null) {
                findJobNumber = "1";
            }
            if (students_confirmed.equals("1")) {
                int findJobNumberS = enrollJobStatusInfoDao.findJobNumberS(findJobNumber);
                int updateJobNumber = enrollJobStatusInfoDao.updateJobStatus(recruiting_id, student_user_id, students_confirmed);
                if (findJobNumberS > 0 && updateJobNumber > 0) {
                    String isBusinessSee = enrollJobStatusInfoDao.findIsBusinessSee(recruiting_id, student_user_id);
                    if (isBusinessSee == null) {
                        throw new QueryInnerErrorException("商家没有查看");
                    } else {
                        return new UpdateJobStatusExcution(EnrollJobStatusEnum.IS_MERCHANT_SEE, isBusinessSee);
                    }
                } else {
                    throw new InsertInnerErrorException("缺少参数");
                }
            } else if (students_confirmed.equals("0")) {
                int updateJobNumber = enrollJobStatusInfoDao.updateJobStatus1(recruiting_id, student_user_id);
                if (updateJobNumber > 0) {
                    return new UpdateJobStatusExcution(EnrollJobStatusEnum.UPDATE_JOB_STATUS_SUCCESS, null);
                } else {
                    throw new UpdateInnerErrorException("兼职状态更改失败");
                }
            } else if (students_confirmed.equals("-1")) {
                int updateJobNumber = enrollJobStatusInfoDao.updateJobStatus1(recruiting_id, student_user_id);
                if (updateJobNumber > 0) {
                    return new UpdateJobStatusExcution(EnrollJobStatusEnum.UPDATE_JOB_STATUS_SUCCESS, null);
                } else {
                    throw new UpdateInnerErrorException("兼职状态更改失败");
                }
            }
            throw new EnrollJobStatusException("参数值有误");
        } catch (EnrollJobStatusException e1) {
            throw e1;
        } catch (QueryInnerErrorException e2) {
            throw e2;
        } catch (InsertInnerErrorException e3) {
            throw e3;
        } catch (UpdateInnerErrorException e4) {
            throw e4;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    //快速报名
    @Transactional
    public QuickSignUpExcution quickSignUp(QuickSignUpDto quickSignUpDto) {
        int recruiting_id = quickSignUpDto.getRecruiting_id();
        int student_user_id = quickSignUpDto.getStudent_user_id();
        String student_name = quickSignUpDto.getStudent_name();
        String contact_phone = quickSignUpDto.getContact_phone();
        String code = quickSignUpDto.getCode();
        String school = quickSignUpDto.getSchool();
        String sex = quickSignUpDto.getSex();
        String leave_message_merchant = quickSignUpDto.getLeave_message_merchant();
        String registration_time = quickSignUpDto.getRegistration_time();
        try {
            if (student_name == null && contact_phone == null && code == null && school == null && sex == null) {
                throw new EnrollJobStatusException("请检查参数是否为空");
            }
            QuickSignUp findRepeatSignUp = enrollJobStatusInfoDao.findRepeatSignUp(recruiting_id, student_user_id);
            if (findRepeatSignUp != null) {
                return new QuickSignUpExcution(EnrollJobStatusEnum.REPEAT_REGISTRATION, null);
            }
            int quickSignUp = enrollJobStatusInfoDao.addQuickSignUp(recruiting_id, student_user_id, student_name, contact_phone, leave_message_merchant, code, school, sex, registration_time);
            if (quickSignUp > 0) {
                String selectInfors = enrollJobStatusInfoDao.selectInfor(recruiting_id);
                if (selectInfors == null) {
                    throw new QueryInnerErrorException("没有该职位");
                }
                int selectInfor = Integer.parseInt(selectInfors);
                int isSuccesss = enrollJobStatusInfoDao.insertWork(selectInfor, student_user_id, recruiting_id);
                int updatePeopleNum = enrollJobStatusInfoDao.updatePeopleNum(recruiting_id);
                if (isSuccesss > 0 && updatePeopleNum > 0) {
                    return new QuickSignUpExcution(EnrollJobStatusEnum.SIGNUP_SUCCESS, null);
                }
                throw new InsertInnerErrorException("报名失败");
            } else {
                throw new InsertInnerErrorException("报名失败");
            }
        }catch (EnrollJobStatusException e1) {
            throw e1;
        }
         catch (QueryInnerErrorException e2) {
            throw e2;
        }
         catch (InsertInnerErrorException e3) {
            throw e3;
        }
         catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
