package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StarEnterpriseLoGoDao;
import com.zxjz.dto.excution.CarouselManageExcution;
import com.zxjz.dto.excution.StarEnterpriseLoGoExcution;
import com.zxjz.dto.in.StarEnterpriseLoGoDto;
import com.zxjz.entity.StarEnterpriseLoGo;
import com.zxjz.enums.CarouselManageEnum;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.StarEnterpriseLoGoService;
import com.zxjz.util.UuidUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StarEnterpriseLoGoServiceImpl implements StarEnterpriseLoGoService{
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired

    private StarEnterpriseLoGoDao starEnterpriseLoGoDao;

    /**
     * 查询企业logo列表
     * @return
     */
    public StarEnterpriseLoGoExcution findStarEnterpriseLoGoList() {
        List<StarEnterpriseLoGo> findStarEnterpriseLoGoList = starEnterpriseLoGoDao.findStarEnterpriseLoGoList();
        int total = starEnterpriseLoGoDao.total();
        Map map = new HashMap();
        map.put("rows", findStarEnterpriseLoGoList);
        map.put("total", total);
        return new StarEnterpriseLoGoExcution(map,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 显示企业logo
     * @param starEnterpriseLoGoDto
     * @return
     */
    public StarEnterpriseLoGoExcution findStarEnterpriseLoGo(StarEnterpriseLoGoDto starEnterpriseLoGoDto) {
        int icon_id = starEnterpriseLoGoDto.getIcon_id();
        StarEnterpriseLoGo findStarEnterpriseLoGo = starEnterpriseLoGoDao.findStarEnterpriseLoGo(icon_id);
        return new StarEnterpriseLoGoExcution(findStarEnterpriseLoGo,IndustryClassificationEnum.FIND_SUCCESS);
    }



    /**
     * 写文件到当前目录的upload目录
     *
     * @param in
     * @throws IOException
     */
    protected String copyFile(InputStream in, String dir, String realName) throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }



    /**
     * 编辑企业Logo
     * @param
     * @return
     */
    public StarEnterpriseLoGoExcution updateStarLoGo(@RequestParam(value = "picture_url", required = true) MultipartFile picture_url,
                                                     @RequestParam(value = "icon_id", required = true) int icon_id) {
        Map map = new HashMap();
        map.put("icon_id",icon_id);
        map.put("picture_url",picture_url);
        try {
            // 图片上传
            String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
                    + "../../";
            // E:\newJ2EEWorkspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
            pictureSaveFilePath = pictureSaveFilePath.substring(6); // 去掉
            // 'file:/'E:/newJ2EEWorkspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestUploadFile/WEB-INF/classes/../../
            if (null != picture_url && !picture_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (picture_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = picture_url.getOriginalFilename().substring(picture_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(picture_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("picture_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }

            int updateStarLoGo = starEnterpriseLoGoDao.updateStarLoGo((Integer) map.get("icon_id"), (String) map.get("picture_url"));
            if (updateStarLoGo > 0) {
                return new StarEnterpriseLoGoExcution(IndustryClassificationEnum.UPDATE_SUCCESS);
            } else {
                throw new InsertInnerErrorException("更改失败");
            }
        } catch (InsertInnerErrorException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
