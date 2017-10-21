package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StudentWithdrawDao;
import com.zxjz.dto.excution.StudentWithdrawExcution;
import com.zxjz.dto.in.StudentWithdrawDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.entity.StudentWithdraw;
import com.zxjz.enums.StudentWithdrawEnum;
import com.zxjz.service.StudentWithdrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class studentWithdrawServiceImpl implements StudentWithdrawService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentWithdrawDao studentWithdrawDao;

    /**
     * 查询学生提现列表
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution findStudentWithdrawList(StudentWithdrawDto studentWithdrawDto) {
        int page = studentWithdrawDto.getPage();
        int rows = studentWithdrawDto.getRows();
        String withdraw_search = studentWithdrawDto.getWithdraw_search();
        String selectStatus = studentWithdrawDto.getSelectStatus();
        int offset = (page - 1) * rows;
        try {
            List<StudentWithdraw> studentWithdrawList = studentWithdrawDao.findStudentWithdrawList(offset, rows,withdraw_search,selectStatus);
            int studentWithdrawCount = studentWithdrawDao.findStudentWithdrawCount(withdraw_search,selectStatus);
            HashMap map = new HashMap();
            map.put("rows",studentWithdrawList);
            map.put("total",studentWithdrawCount);
            return new StudentWithdrawExcution(StudentWithdrawEnum.FIND_SUCCESS,map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     *  查询当前选中条学生提现信息
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution findAcceptStudentWithdrawInfo(StudentWithdrawDto studentWithdrawDto) {
        int user_id = studentWithdrawDto.getUser_id();
        int withdraw_num = studentWithdrawDto.getWithdraw_num();
        try {
            StudentWithdraw studentWithdrawInfo = studentWithdrawDao.findStudentWithdrawInfo(user_id,withdraw_num);
            return new StudentWithdrawExcution(StudentWithdrawEnum.FIND_SUCCESS,studentWithdrawInfo);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 更新处理的学生提现信息状态
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution updateStudentWithdrawStatus(StudentWithdrawDto studentWithdrawDto) {
        int user_id = studentWithdrawDto.getUser_id();
        int withdraw_num = studentWithdrawDto.getWithdraw_num();
        int staff_id = studentWithdrawDto.getStaff_id();
        try {
            int isUpdate = studentWithdrawDao.updateStudentWithdrawStatus(user_id,withdraw_num,staff_id);
            return new StudentWithdrawExcution(StudentWithdrawEnum.UPDATA_STUDENT_WITHDRAW_SUCCESS,isUpdate);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
