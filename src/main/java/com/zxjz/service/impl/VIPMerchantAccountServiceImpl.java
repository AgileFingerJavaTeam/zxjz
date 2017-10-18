package com.zxjz.service.impl;

import com.zxjz.dao.VIPMerchantAccountDao;
import com.zxjz.dto.excution.VIPMerchantAccountExcution;
import com.zxjz.dto.in.VIPMerchantAccountDto;
import com.zxjz.entity.FindMerchantName;
import com.zxjz.entity.VIPMerchantAccount;
import com.zxjz.enums.VIPMerchantAccountEnum;
import com.zxjz.service.VIPMerchantAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VIPMerchantAccountServiceImpl implements VIPMerchantAccountService{


    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private VIPMerchantAccountDao vipMerchantAccountDao;

    /**
     * 显示VIP商家账号信息
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution findListVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto) {
        String hzn_vipMersearch_content = vipMerchantAccountDto.getHzn_vipMersearch_content();
        String sort = vipMerchantAccountDto.getSort();
        String order = vipMerchantAccountDto.getOrder();
        int offset = vipMerchantAccountDto.getOffset();
        int rows = vipMerchantAccountDto.getRows();
        List<VIPMerchantAccount> findListVIPMerchantAccount = vipMerchantAccountDao.findVIPMerchantList(hzn_vipMersearch_content,sort,order,offset,rows);
        int total = vipMerchantAccountDao.total(hzn_vipMersearch_content);
        Map map = new HashMap();
        map.put("rows",findListVIPMerchantAccount);
        map.put("total",total);
        return new VIPMerchantAccountExcution(map,VIPMerchantAccountEnum.RETURN_SUCCESS);
    }

    /**
     * 添加VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution addVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto) {
        int user_id = vipMerchantAccountDto.getUser_id();
        String vip_start = vipMerchantAccountDto.getVip_start();
        String vip_end = vipMerchantAccountDto.getVip_end();
        int addVIPMerchantAccount = vipMerchantAccountDao.addVIPMerchantAccount(user_id,vip_start,vip_end);
        if (addVIPMerchantAccount > 0){
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_SUCCESS);
        }else{
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_FAIL);
        }
    }

    /**
     * 模糊搜索商家名称
     * @return
     */
    public VIPMerchantAccountExcution findMerchantName() {
        List<FindMerchantName> findMerchantName = vipMerchantAccountDao.findMerchantName();
        if (findMerchantName != null){
            return new VIPMerchantAccountExcution(findMerchantName,VIPMerchantAccountEnum.RETURN_SUCCESS);
        }else{
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_FAIL);
        }
    }

    /**
     * 显示VIP商家账号信息
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution findVIPMerchantObject(VIPMerchantAccountDto vipMerchantAccountDto) {
        int id = vipMerchantAccountDto.getId();
        VIPMerchantAccount findVIPMerchantObject = vipMerchantAccountDao.findVIPMerchantObject(id);
        return new VIPMerchantAccountExcution(findVIPMerchantObject,VIPMerchantAccountEnum.RETURN_SUCCESS);
    }

    /**
     * 编辑VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution updateVIPMerchantObject(VIPMerchantAccountDto vipMerchantAccountDto) {
        int user_id = vipMerchantAccountDto.getUser_id();
        String vip_start = vipMerchantAccountDto.getVip_start();
        String vip_end = vipMerchantAccountDto.getVip_end();
        int updateVIPMerchantObject = vipMerchantAccountDao.editVIPMerchant(user_id,vip_start,vip_end);
        if (updateVIPMerchantObject > 0){
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_SUCCESS);
        }else {
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_SUCCESS);
        }
    }

    /**
     * 显示删除VIP商业账户
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution showDelVIPMerchant(VIPMerchantAccountDto vipMerchantAccountDto) {
        int id = vipMerchantAccountDto.getId();
        VIPMerchantAccount findVIPMerchantObject = vipMerchantAccountDao.findVIPMerchantObject(id);
        return new VIPMerchantAccountExcution(findVIPMerchantObject,VIPMerchantAccountEnum.RETURN_SUCCESS);
    }

    /**
     * 删除企业VIP商业账户
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution editVIPMerchantPage(VIPMerchantAccountDto vipMerchantAccountDto) {
        int user_id = vipMerchantAccountDto.getUser_id();
        int editVIPMerchantPage = vipMerchantAccountDao.deleteVIPMerchant(user_id);
        if (editVIPMerchantPage > 0){
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_SUCCESS);
        }else {
            return new VIPMerchantAccountExcution(VIPMerchantAccountEnum.RETURN_SUCCESS);
        }
    }


}
