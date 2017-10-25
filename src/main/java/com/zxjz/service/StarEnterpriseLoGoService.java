package com.zxjz.service;

import com.zxjz.dto.excution.StarEnterpriseLoGoExcution;
import com.zxjz.dto.in.StarEnterpriseLoGoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface StarEnterpriseLoGoService {
    /**
     * 查询企业logo列表
     * @return
     */
    public StarEnterpriseLoGoExcution findStarEnterpriseLoGoList();

    /**
     * 显示编辑页面
     * @param starEnterpriseLoGoDto
     * @return
     */
    public StarEnterpriseLoGoExcution findStarEnterpriseLoGo(StarEnterpriseLoGoDto starEnterpriseLoGoDto);

    /**
     * 编辑企业logo
     * @param icon_id
     * @param picture_url
     * @return
     */
    public StarEnterpriseLoGoExcution updateStarLoGo(@RequestParam(value = "picture_url", required = true) MultipartFile picture_url,
                                                     @RequestParam(value = "icon_id", required = true) int icon_id);
}
