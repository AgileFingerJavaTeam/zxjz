package com.zxjz.service.impl;


import com.zxjz.base.BaseException;
import com.zxjz.dao.CheckStudentsDao;
import com.zxjz.dto.excution.CheckStudentsExcution;
import com.zxjz.dto.in.CheckStudentsDto;
import com.zxjz.entity.CheckStudentsInfo;
import com.zxjz.enums.CheckStudentsEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
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
 public CheckStudentsExcution  findStudentsInfoList (CheckStudentsDto checkStudentsDto){
     int offset = checkStudentsDto.getOffset();
     int rows = checkStudentsDto.getRows();
     int check_state = checkStudentsDto.getCheck_state();
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
}
