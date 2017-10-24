package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.SecurityPositionDao;
import com.zxjz.dto.excution.AtSecurityPositionExcution;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.AtSecurityPositionDto;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.entity.AtCollection;
import com.zxjz.entity.MerchantAccount;
import com.zxjz.entity.Station;
import com.zxjz.enums.SecurityPositionEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.SecurityPositionService;
import com.zxjz.util.UuidUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Service
public class SecurityPositionServiceImpl implements SecurityPositionService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SecurityPositionDao securityPositionDao;

    public SecurityPositionExcution getSecurityPositionList(SecurityPositionDto securityPositionDto) {
            String StatusSearch = securityPositionDto.getStatusSearch();
            String statusSearchT = securityPositionDto.getStatusSearchT();
            String search = securityPositionDto.getSearch();
            int page=securityPositionDto.getPage();
            int rows=securityPositionDto.getRows();
            int offset=(page-1)*rows;
        try{
            List<AtCollection> list = securityPositionDao.findListCollection(offset,rows);
            int total = securityPositionDao.findSecurityPositionListCount(StatusSearch,search,statusSearchT);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
         if(list != null){
             for (AtCollection mer : list) {
                 String reBegin = mer.getRecommendBeginTime();
                 String reEnd = mer.getRecommendEndTime();
                 String begin = mer.getGoodBeginTime();
                 String end = mer.getGoodEndTime();
                 if(reBegin != null){
                     Date date = fmt.parse(reBegin);
                     String apply = fmt.format(date);
                     mer.setRecommendBeginTime(apply);
                 }
                 if(reEnd != null){
                     Date date = fmt.parse(reEnd);
                     String apply = fmt.format(date);
                     mer.setRecommendEndTime(apply);
                 }
                 if (begin != null) {
                     Date date = fmt.parse(begin);
                     String apply = fmt.format(date);
                     mer.setGoodBeginTime(apply);
                 }
                 if (end != null) {
                     Date date = fmt.parse(end);
                     String status = fmt.format(date);
                     mer.setGoodEndTime(status);
                 }
             }
         }
             HashMap map =new HashMap();
             map.put("rows",list);
             map.put("total",total);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution getSecurityPositionList2(SecurityPositionDto securityPositionDto) {
            String StatusSearch = securityPositionDto.getStatusSearch();
            String search = securityPositionDto.getSearch();
            int page=securityPositionDto.getPage();
            int rows=securityPositionDto.getRows();
            int offset=(page-1)*rows;
        try{
            List<AtCollection> list = securityPositionDao.findListCollection2(offset,rows);
            int total = securityPositionDao.findSecurityPositionListCount2(StatusSearch,search);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            if(list != null){
                for (AtCollection mer : list) {
                    String reBegin = mer.getRecommendBeginTime();
                    String reEnd = mer.getRecommendEndTime();
                    String begin = mer.getGoodBeginTime();
                    String end = mer.getGoodEndTime();
                    if(reBegin != null){
                        Date date = fmt.parse(reBegin);
                        String apply = fmt.format(date);
                        mer.setRecommendBeginTime(apply);
                    }
                    if(reEnd != null){
                        Date date = fmt.parse(reEnd);
                        String apply = fmt.format(date);
                        mer.setRecommendEndTime(apply);
                    }
                    if (begin != null) {
                        Date date = fmt.parse(begin);
                        String apply = fmt.format(date);
                        mer.setGoodBeginTime(apply);
                    }
                    if (end != null) {
                        Date date = fmt.parse(end);
                        String status = fmt.format(date);
                        mer.setGoodEndTime(status);
                    }
                }
            }
            HashMap map = new HashMap();
            map.put("rows",list);
            map.put("total",total);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution getSecurityPositionSecurity(SecurityPositionDto securityPositionDto) {
            int id = securityPositionDto.getId();
        try {
            AtCollection atCollection=securityPositionDao.findSecurityPositionSecurity(id);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,atCollection);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution getSecurityPosition(SecurityPositionDto securityPositionDto) {
            int id = securityPositionDto.getId();
        try {
            AtCollection atCollection=securityPositionDao.findSecurityPositionSecurity(id);
            int post_calssification=atCollection.getPostClassification();
            Map maps=securityPositionDao.findSecurityPositionSecurity1(post_calssification);
            HashMap map = new HashMap();
            map.put("data",atCollection);
            map.put("info",maps);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution findListMarchantName() {
        try {
            List<MerchantAccount> info=securityPositionDao.findListMarchantName();
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,info);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution findListStation() {
        try {
            List<Station> info=securityPositionDao.findListStation();
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,info);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution findListTwoLevelStation(SecurityPositionDto securityPositionDto) {
                  int p_station_id = securityPositionDto.getP_station_id();
        try {
            List<Station> info=securityPositionDao.findListTwoLevelStation(p_station_id);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,info);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
    /**
     * 写文件到当前目录的upload目录
     *
     * @param in
     *
     * @throws IOException
     */
    protected  String copyFile(InputStream in, String dir, String realName) throws IOException {
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
    @Transactional
    public AtSecurityPositionExcution insertSecurityPosition(AtSecurityPositionDto atSecurityPositionDto) {
                 int releases_user_id = atSecurityPositionDto.getReleases_user_id();
                 String post_name = atSecurityPositionDto.getPost_name();
                 int post_classification = atSecurityPositionDto.getPost_classification();
                 String work_date = atSecurityPositionDto.getWork_date();
                 String work_time = atSecurityPositionDto.getWork_time();
                 String work_location = atSecurityPositionDto.getWork_location();
                 String position_longitude = atSecurityPositionDto.getPosition_longitude();
                 String position_latitude = atSecurityPositionDto.getPosition_latitude();
                 String work_content = atSecurityPositionDto.getWork_content();
                 double salary_treatment = atSecurityPositionDto.getSalary_treatment();
                 String commission = atSecurityPositionDto.getCommission();
                 String benefits = atSecurityPositionDto.getBenefits();
                 String gender_requirements = atSecurityPositionDto.getGender_requirements();
                 String other_requirements = atSecurityPositionDto.getOther_requirements();
                 int recruitment = atSecurityPositionDto.getRecruitment();
                 String hiring_expiration_date = atSecurityPositionDto.getHiring_expiration_date();
                 String main_title = atSecurityPositionDto.getMain_title();
                 String subtitle = atSecurityPositionDto.getSubtitle();
                 String short_description = atSecurityPositionDto.getShort_description();
                 MultipartFile page_url = atSecurityPositionDto.getPage_url();
                 MultipartFile first_page_carousel_url = atSecurityPositionDto.getFirst_page_carousel_url();
                 MultipartFile main_page_url = atSecurityPositionDto.getMain_page_url();
                 String details_page_introduction = atSecurityPositionDto.getDetails_page_introduction();
                 HashMap map = new HashMap();
                 map.put("releases_user_id", releases_user_id);
                 map.put("post_name", post_name);
                 map.put("post_classification", post_classification );
                 map.put("work_date", work_date);
                 map.put("work_time", work_time );
                 map.put("work_location", work_location );
                 map.put("position_longitude", position_longitude );
                 map.put("position_latitude", position_latitude );
                 map.put("work_content",work_content );
                 map.put("salary_treatment", salary_treatment );
                 map.put("commission",commission);
                 map.put("benefits", benefits);
                 map.put("gender_requirements", gender_requirements);
                 map.put("other_requirements", other_requirements);
                 map.put("recruitment", recruitment);
                 map.put("hiring_expiration_date",hiring_expiration_date);
                 map.put("main_title", main_title);
                 map.put("subtitle", subtitle);
                 map.put("short_description", short_description);
                 map.put("page_url", page_url);
                 map.put("first_page_carousel_url", first_page_carousel_url);
                 map.put("main_page_url", main_page_url);
                 map.put("details_page_introduction", details_page_introduction);
                 int recruiting_id=0;
        try {
            String index=securityPositionDao.getSecurityIndex();
            if(index==null){
                recruiting_id=-1;
                map.put("recruiting_id",recruiting_id);
            }else{
                recruiting_id=Integer.parseInt(index)-1;
                map.put("recruiting_id",recruiting_id);
            }
            // 图片上传
            String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
                    + "../../";
            // E:\newJ2EEWorkspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
            pictureSaveFilePath = pictureSaveFilePath.substring(6); // 去掉
            // 'file:/'E:/newJ2EEWorkspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestUploadFile/WEB-INF/classes/../../
            if (null != page_url && !page_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (page_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = page_url.getOriginalFilename().substring(page_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(page_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("page_url", id + extName);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new BaseException(e.getMessage());
                }
            } else {// 没有上传图片
                map.put("state","暂停");
            }
            if (null != first_page_carousel_url && !first_page_carousel_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (first_page_carousel_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = first_page_carousel_url.getOriginalFilename().substring(first_page_carousel_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(first_page_carousel_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("first_page_carousel_url", id + extName);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new BaseException(e.getMessage());
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }
            if (null != main_page_url && !main_page_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (main_page_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = main_page_url.getOriginalFilename().substring(main_page_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(main_page_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("main_page_url", id + extName);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new BaseException(e.getMessage());
                }
            } else {// 没有上传图片
                map.put("state","暂停");
            }
            int total = securityPositionDao.addSecurityPosition(map);
            map.put("recruiting_id",recruiting_id);
            int total1 = securityPositionDao.addSecurityPosition2(map);
            if (total > 0 && total1 > 0) {
                return new AtSecurityPositionExcution(SecurityPositionEnum.ADD_JOB_SUCCESS,null);
            } else {
                throw new InsertInnerErrorException("添加失败");
            }
        } catch (InsertInnerErrorException e1) {
            throw e1;
        }
          catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }



    public static String htmlEncode(String source) {
        if (source == null) {
            return "";
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                case '&':
                    buffer.append("&amp;");
                    break;
                case '"':
                    buffer.append("&quot;");
                    break;
                case 10:
                case 13:
                    break;
                default:
                    buffer.append(c);
            }
        }
        html = buffer.toString();
        return html;
    }
    public SecurityPositionExcution findSecurityPositionHref(SecurityPositionDto securityPositionDto) {
        try {
            int id = securityPositionDto.getId();
            AtCollection atCollection = securityPositionDao.findSecurityPositionSecurity(id);
            int i = atCollection.getPostClassification();
            int parentPostClassification = i;
            int p_post_classification = securityPositionDao.findParentPostClassification(parentPostClassification);
            atCollection.setpPostClassification(p_post_classification);
            return new SecurityPositionExcution(SecurityPositionEnum.UPDATE_PSW_SUCCESS,atCollection);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }


    public AtSecurityPositionExcution updateSecurityPosition(@RequestParam(value = "recruiting_id", required = true) Integer recruiting_id,
                                                             @RequestParam(value = "post_name", required = false) String post_name,
                                                             @RequestParam(value = "post_classification", required = true) Integer post_classification,
                                                             @RequestParam(value = "work_date", required = true) String work_date,
                                                             @RequestParam(value = "work_time", required = true) String work_time,
                                                             @RequestParam(value = "work_location", required = true) String work_location,
                                                             @RequestParam(value = "position_longitude", required = true) String position_longitude,
                                                             @RequestParam(value = "position_latitude", required = true) String position_latitude,
                                                             @RequestParam(value = "work_content", required = true) String work_content,
                                                             @RequestParam(value = "salary_treatment", required = true) double salary_treatment,
                                                             @RequestParam(value = "commission", required = true) double commission,
                                                             @RequestParam(value = "benefits", required = true) double benefits,
                                                             @RequestParam(value = "gender_requirements", required = true) String gender_requirements,
                                                             @RequestParam(value = "other_requirements", required = true) String other_requirements,
                                                             @RequestParam(value = "recruitment", required = true) int recruitment,
                                                             @RequestParam(value = "hiring_expiration_date", required = true) String hiring_expiration_date,
                                                             @RequestParam(value = "main_title", required = true) String main_title,
                                                             @RequestParam(value = "subtitle", required = true) String subtitle,
                                                             @RequestParam(value = "short_description", required = true) String short_description,
                                                             @RequestParam(value = "page_url", required = false) MultipartFile page_url,
                                                             @RequestParam(value = "first_page_carousel_url", required = false) MultipartFile first_page_carousel_url,
                                                             @RequestParam(value = "main_page_url", required = false) MultipartFile main_page_url,
                                                             @RequestParam(value = "details_page_introduction", required = true) String details_page_introduction,
                                                             @RequestParam(value = "releases_user_id", required = true) Integer releases_user_id,
                                                             @RequestParam(value = "up_down_frame", required = true) String up_down_frame
    ) {
        HashMap map = new HashMap();
        map.put("up_down_frame", up_down_frame);
        map.put("post_name", post_name);
        map.put("post_classification", post_classification );
        map.put("work_date", work_date);
        map.put("work_time", work_time );
        map.put("work_location", work_location );
        map.put("position_longitude", position_longitude );
        map.put("position_latitude", position_latitude );
        map.put("work_content",work_content );
        map.put("salary_treatment", salary_treatment );
        map.put("commission",commission);
        map.put("benefits", benefits);
        map.put("gender_requirements", gender_requirements);
        map.put("other_requirements", other_requirements);
        map.put("recruitment", recruitment);
        map.put("hiring_expiration_date",hiring_expiration_date);
        map.put("main_title", main_title);
        map.put("subtitle", subtitle);
        map.put("short_description", short_description);
        map.put("releases_user_id", releases_user_id);
        map.put("recruiting_id", recruiting_id);
        map.put("page_url", page_url);
        map.put("first_page_carousel_url", first_page_carousel_url);
        map.put("main_page_url", main_page_url);
        map.put("details_page_introduction", details_page_introduction);
        try {
            // 图片上传
            String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
                    + "../../";
            // E:\newJ2EEWorkspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
            pictureSaveFilePath = pictureSaveFilePath.substring(6); // 去掉
            // 'file:/'E:/newJ2EEWorkspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestUploadFile/WEB-INF/classes/../../
            if (null != page_url && !page_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (page_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = page_url.getOriginalFilename().substring(page_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(page_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("page_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }
            if (null != first_page_carousel_url && !first_page_carousel_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (first_page_carousel_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = first_page_carousel_url.getOriginalFilename().substring(first_page_carousel_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(first_page_carousel_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("first_page_carousel_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }
            if (null != main_page_url && !main_page_url.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (main_page_url.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = main_page_url.getOriginalFilename().substring(main_page_url.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(main_page_url.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("main_page_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }
            int total = securityPositionDao.SecurityPositionUpdate(map);
            if(page_url !=null){
                int total2 = securityPositionDao.SecurityPositionUpdate2(map);
                if(total2 ==0){
                    throw new InsertInnerErrorException("更改失败");
                }
            }
            if(first_page_carousel_url !=null){
                int total3 = securityPositionDao.SecurityPositionUpdate3(map);
                if(total3==0){
                    throw new InsertInnerErrorException("更改失败");
                }
            }
            if(main_page_url!=null){
                int total4 = securityPositionDao.SecurityPositionUpdate4(map);
                if(total4==0){
                    throw new InsertInnerErrorException("更改失败");
                }
            }
            return new AtSecurityPositionExcution(SecurityPositionEnum.UPDATE_PSW_SUCCESS,null);
        }catch (InsertInnerErrorException e1) {
            throw e1;
        }
         catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public SecurityPositionExcution findSearch(SecurityPositionDto securityPositionDto) {
               String StatusSearch = securityPositionDto.getStatusSearch();
               String search = securityPositionDto.getSearch();
               String statusSearch = securityPositionDto.getStatusSearchT();
               int page = (securityPositionDto.getPage() != 0) ? securityPositionDto.getPage() : 1;
               int rows = (securityPositionDto.getRows() !=0) ? securityPositionDto.getRows() :20;
               try{
               int offset=(page-1)*rows;
               List<AtCollection> list = securityPositionDao.findSearch(offset,rows,search);
               int total = securityPositionDao.findSecurityPositionListCount(StatusSearch,search,statusSearch);
               HashMap map = new HashMap();
               map.put("rows",list);
               map.put("total",total);
               return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            e.printStackTrace();
        }
               return null;
    }

    public SecurityPositionExcution findSearch2(SecurityPositionDto securityPositionDto) {
        String StatusSearch = securityPositionDto.getStatusSearch();
        String search = securityPositionDto.getSearch();
        int page = (securityPositionDto.getPage() != 0) ? securityPositionDto.getPage() : 1;
        int rows = (securityPositionDto.getRows() !=0) ? securityPositionDto.getRows() :20;
        try{
            int offset=(page-1)*rows;
            List<AtCollection> list = securityPositionDao.findSearch2(offset,rows,search);
            int total = securityPositionDao.findSecurityPositionListCount2(StatusSearch,search);
            HashMap map = new HashMap();
            map.put("rows",list);
            map.put("total",total);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SecurityPositionExcution findStatusSearch(SecurityPositionDto securityPositionDto) {
            String StatusSearch = securityPositionDto.getStatusSearch();
            String search = securityPositionDto.getSearch();
            String statusSearchT = securityPositionDto.getStatusSearchT();
        int page = (securityPositionDto.getPage() != 0) ? securityPositionDto.getPage() : 1;
        int rows = (securityPositionDto.getRows() !=0) ? securityPositionDto.getRows() :20;
        try{
            int offset=(page-1)*rows;
            List<AtCollection> list = securityPositionDao.findStatusSearch(offset,rows,StatusSearch,statusSearchT);
            int total = securityPositionDao.findSecurityPositionListCount(StatusSearch,search,statusSearchT);
            HashMap map = new HashMap();
            map.put("rows",list);
            map.put("total",total);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SecurityPositionExcution findStatusSearch2(SecurityPositionDto securityPositionDto) {
        String StatusSearch = securityPositionDto.getStatusSearch();
        String search = securityPositionDto.getSearch();
        int page = (securityPositionDto.getPage() != 0) ? securityPositionDto.getPage() : 1;
        int rows = (securityPositionDto.getRows() !=0) ? securityPositionDto.getRows() :20;
        try{
            int offset=(page-1)*rows;
            List<AtCollection> list = securityPositionDao.findStatusSearch2(offset,rows,StatusSearch);
            int total = securityPositionDao.findSecurityPositionListCount2(StatusSearch,search);
            HashMap map = new HashMap();
            map.put("rows",list);
            map.put("total",total);
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,map);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
