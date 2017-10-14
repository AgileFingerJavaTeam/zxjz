package com.zxjz.service.impl;


import com.zxjz.base.BaseException;
import com.zxjz.dao.CheckStudentsDao;
import com.zxjz.dto.excution.CheckStudentsExcution;
import com.zxjz.dto.in.CheckStudentsDto;
import com.zxjz.entity.CheckStudentsInfo;
import com.zxjz.enums.CheckStudentsEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.CheckStudentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckStudentsServiceImpl implements CheckStudentsService {
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
 @Autowired
    private CheckStudentsDao checkStudentsDao;

    /**
     * 查询学生审核列表
     * @param checkStudentsDto
     * @return
     */
     public CheckStudentsExcution  findStudentsInfoList (CheckStudentsDto checkStudentsDto){
         int page = checkStudentsDto.getPage();
         int rows = checkStudentsDto.getRows();
         int check_state = checkStudentsDto.getCheck_state();
         int offset = (page - 1) * rows;
         String srt_searchStu_content = checkStudentsDto.getSrt_searchStu_content();
         String srt_filtrate = checkStudentsDto.getSrt_filtrate();
         try {
             List<CheckStudentsInfo> studentsInfoList = checkStudentsDao.findStudentsCheckInfo(offset,rows,check_state,srt_searchStu_content,srt_filtrate);
             if (studentsInfoList == null){
                 throw new QueryInnerErrorException("查询学生审核列表失败");
             }
             return new CheckStudentsExcution(CheckStudentsEnum.FIND_STUDENTS_LIST_SUCCESS,studentsInfoList);
         }catch (QueryInnerErrorException e1){
             throw e1;
         }catch (Exception e){
             logger.error(e.getMessage(), e);
             throw new BaseException(e.getMessage());
         }
     }

    /**
     * 查询当前审核学生信息
     * @param checkStudentsDto
     * @return
     */
    public CheckStudentsExcution findStudentsInfoById(CheckStudentsDto checkStudentsDto) {
        int id = checkStudentsDto.getUser_id();
        try {
            CheckStudentsInfo checkStudentInfo = checkStudentsDao.findStuInfoById(id);
            if (checkStudentInfo == null){
                throw new QueryInnerErrorException("查询审核学生信息失败");
            }
            return new CheckStudentsExcution(CheckStudentsEnum.FIND_STUDENT_SUCCESS,checkStudentInfo);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 提交审核
     * @param checkStudentsDto
     * @return
     */
    public CheckStudentsExcution submitAudit(CheckStudentsDto checkStudentsDto) {
        int user_id = checkStudentsDto.getUser_id();
        String stat_res = checkStudentsDto.getStat_res();
        try {
            if (stat_res.equals("1")){
                int isRefuseStudent = checkStudentsDao.refuseStudent(user_id);
                if (isRefuseStudent == 0){
                    throw new UpdateInnerErrorException("审核驳回失败");
                }
                return new CheckStudentsExcution(CheckStudentsEnum.CHECK_SUCCESS);
            }else {
                int isPassStudent = checkStudentsDao.passStudent(user_id);
                if (isPassStudent == 0){
                    throw new UpdateInnerErrorException("审核通过失败");
                }
                return new CheckStudentsExcution(CheckStudentsEnum.CHECK_SUCCESS);
            }
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
