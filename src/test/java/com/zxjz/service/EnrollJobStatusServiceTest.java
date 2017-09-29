package com.zxjz.service;

import com.zxjz.dto.excution.EnrollJobStatusExcution;
import com.zxjz.dto.excution.QuickSignUpExcution;
import com.zxjz.dto.excution.UpdateJobStatusExcution;
import com.zxjz.dto.in.EnrollJobStatusDto;
import com.zxjz.dto.in.QuickSignUpDto;
import com.zxjz.dto.in.UpdateJobStatusDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Administrator on 2017/9/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class EnrollJobStatusServiceTest {
    @Autowired
    private EnrollJobStatusService enrollJobStatusService;
   /* @Test
    public void findEnrollJobStatus() throws Exception {
         EnrollJobStatusDto enrollJobStatusDto = new EnrollJobStatusDto(1,1);
         EnrollJobStatusExcution enrollJobStatusExcution = enrollJobStatusService.findEnrollJobStatus(enrollJobStatusDto);
        System.out.println("---------");
        System.out.println(enrollJobStatusExcution);
        System.out.println("---------");
    }
    @Test
    public void updateJobStatus() throws Exception {
        UpdateJobStatusDto updateJobStatusDto = new UpdateJobStatusDto(3,3,"1");
        UpdateJobStatusExcution updateJobStatusExcution = enrollJobStatusService.updateJobStatus(updateJobStatusDto);
        System.out.println("---------");
        System.out.println(updateJobStatusExcution);
        System.out.println("---------");
    }


    @Test
    public void quickSignUp() throws Exception {
        QuickSignUpDto quickSignUpDto = new QuickSignUpDto(22222,22222,"77","77","1","1","1","1","1","1");
        QuickSignUpExcution quickSignUpExcution = enrollJobStatusService.quickSignUp(quickSignUpDto);
        System.out.println("---------");
        System.out.println(quickSignUpExcution);
        System.out.println("---------");
    }
*/
}