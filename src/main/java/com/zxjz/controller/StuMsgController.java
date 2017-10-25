package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.CreditAndPaymentExcution;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.excution.StuMsgExcution;
import com.zxjz.dto.in.CreditAndPaymentDto;
import com.zxjz.dto.in.StuJobDto;
import com.zxjz.dto.in.StuMsgDto;
import com.zxjz.enums.CreditEnum;
import com.zxjz.enums.RecruitApprovalEnum;
import com.zxjz.enums.StuJobEnum;
import com.zxjz.enums.StuMsgEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.StuJobService;
import com.zxjz.service.StuMsgService;
import com.zxjz.util.ExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("StuMsg")
public class StuMsgController extends BaseController {
    @Autowired
    private StuMsgService stuMsgService;
    /*
	 * 显示页面
	 * */
    @RequestMapping(value = "/getStuMsgPage")
    public ModelAndView creditPage(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("message/studentmessage");
        return mv;
    }

    @RequestMapping(value = "/getStuMsg",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getStuMsgList(StuMsgDto stuMsgDto){
        try {
            StuMsgExcution stuMsgExcution = stuMsgService.stuMsg(stuMsgDto);
            return BaseUIResult.returnJsonEasyUI(stuMsgExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            StuMsgExcution stuMsgExcution=new StuMsgExcution(StuMsgEnum.FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(stuMsgExcution);
        }
    }



    @RequestMapping(value = "/updateStatusPage")
    public ModelAndView updateStatusPage(StuMsgDto stuMsgDto){
        ModelAndView mv=new ModelAndView();
        mv.addObject("id", stuMsgDto.getUser_id());
        mv.setViewName("message/updatestatu");
        return mv;
    }

    @RequestMapping(value = "/updateStatus",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String updateStatus(StuMsgDto stuMsgDto) {
        try {
            StuMsgExcution stuMsgExcution=stuMsgService.stuMsgStat(stuMsgDto);
            return BaseUIResult.returnJsonMSG(1,stuMsgExcution,"更改成功");
        } catch (UpdateDatabaseException e) {
            logger.error(e.getMessage(), e);
            StuMsgExcution stuMsgExcution = new StuMsgExcution(StuMsgEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,stuMsgExcution,"更改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            StuMsgExcution stuMsgExcution = new StuMsgExcution(StuMsgEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,stuMsgExcution,"更改失败");
        }
    }


}
