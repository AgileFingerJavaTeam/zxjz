package com.zxjz.service;


import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.in.StuJobDto;

public interface StuJobService {

        /*
        *
        *
        * */
        public StuJobExcution stuJob(StuJobDto stuJobDto);


    /*
    *
    *
    * */
    public StuJobExcution stuJobList(StuJobDto stuJobDto);

}
