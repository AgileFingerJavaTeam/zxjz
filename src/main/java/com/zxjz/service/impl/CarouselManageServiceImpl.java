package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.CarouselManageDao;
import com.zxjz.dto.excution.CarouselManageExcution;
import com.zxjz.dto.in.CarouselManageDto;
import com.zxjz.entity.AtCarouselManage;
import com.zxjz.entity.CarouselInfo;
import com.zxjz.enums.CarouselManageEnum;
import com.zxjz.exception.db.DeleteInnerErrorException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.CarouselManageService;
import com.zxjz.util.UuidUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * Created by Administrator on 2017/10/20 0020.
 */
@Service
public class CarouselManageServiceImpl implements CarouselManageService {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarouselManageDao carouselManageDao;

    public CarouselManageExcution getCarouselList(CarouselManageDto carouselManageDto) {
        try {
            String xzf_search_content = carouselManageDto.getXzf_search_content();
            int page = (carouselManageDto.getPage() != 0) ? carouselManageDto.getPage() :1;
            int rows = (carouselManageDto.getRows() !=0) ? carouselManageDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<CarouselInfo> info = carouselManageDao.findCarouselListAll(xzf_search_content, offset, rows);
            if (info != null) {
                for (CarouselInfo car : info) {
                    String start_date = car.getStartDate();
                    String end_date = car.getEndDate();
                    if (start_date != null) {
                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = fmt.parse(start_date);
                        String s = fmt.format(date);
                        car.setStartDate(s);
                    }

                    if (end_date != null) {
                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = fmt.parse(end_date);
                        String s = fmt.format(date);
                        car.setEndDate(s);
                    }

                }
            }
            int total = carouselManageDao.findCarouselListCount(xzf_search_content);
            HashMap map = new HashMap();
            map.put("rows", info);
            map.put("total", total);
            return new CarouselManageExcution(CarouselManageEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
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

    public CarouselManageExcution insertCarouse(@RequestParam(value = "carousel_code", required = true) String carousel_code, @RequestParam(value = "carousel_name", required = true) String carousel_name, @RequestParam(value = "carousel_figure_type", required = true) String carousel_figure_type, @RequestParam(value = "image", required = false) MultipartFile image, @RequestParam(value = "start_date", required = true) String start_date, @RequestParam(value = "end_date", required = true) String end_date, @RequestParam(value = "target_id", required = false) Integer target_id, @RequestParam(value = "target_parameter", required = false) String target_parameter, @RequestParam(value = "target_url", required = false) String target_url, @RequestParam(value = "target_type", required = true) String target_type, @RequestParam(value = "is_good_position", required = true) String is_good_position, @RequestParam(value = "state", required = true) String state) {
        HashMap map = new HashMap();
        map.put("carousel_code", carousel_code);
        map.put("carousel_name", carousel_name);
        map.put("carousel_figure_type", carousel_figure_type);
        map.put("image", image);
        map.put("start_date", start_date);
        map.put("end_date", end_date);
        map.put("target_id", target_id);
        map.put("target_parameter", target_parameter);
        map.put("target_url", target_url);
        map.put("target_type", target_type);
        map.put("is_good_position", is_good_position);
        map.put("state", state);
        try {
            // 图片上传
            String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
                    + "../../";
            // E:\newJ2EEWorkspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
            pictureSaveFilePath = pictureSaveFilePath.substring(6); // 去掉
            // 'file:/'E:/newJ2EEWorkspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestUploadFile/WEB-INF/classes/../../
            if (null != image && !image.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (image.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(image.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("picture_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }

            int flag = carouselManageDao.insertCarousel(map);
            if (flag > 0) {
                return new CarouselManageExcution(CarouselManageEnum.SUCCESS, null);
            } else {
                throw new InsertInnerErrorException("添加失败");
            }
        } catch (InsertInnerErrorException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CarouselManageExcution findTitle() {
        try {
            List<AtCarouselManage> info = carouselManageDao.findTitle();
            if (info != null) {
                return new CarouselManageExcution(CarouselManageEnum.SUCCESS, info);
            } else {
                throw new QueryInnerErrorException("查询失败");
            }
        }catch (QueryInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CarouselManageExcution findCarouseObject(CarouselManageDto carouselManageDto) {
             int carousel_figure_id = carouselManageDto.getCarousel_figure_id();
        try {
            CarouselInfo info = carouselManageDao.findCarouseObject(carousel_figure_id);
                return new CarouselManageExcution(CarouselManageEnum.SUCCESS, info);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CarouselManageExcution updateCarouse(@RequestParam(value = "carousel_code", required = true) String carousel_code, @RequestParam(value = "carousel_name", required = true) String carousel_name, @RequestParam(value = "carousel_figure_id", required = true) String carousel_figure_id, @RequestParam(value = "image", required = false) MultipartFile image, @RequestParam(value = "start_date", required = true) String start_date, @RequestParam(value = "end_date", required = true) String end_date, @RequestParam(value = "target_id", required = false) Integer target_id, @RequestParam(value = "target_parameter", required = false) String target_parameter, @RequestParam(value = "target_url", required = false) String target_url, @RequestParam(value = "target_type", required = true) String target_type, @RequestParam(value = "is_good_position", required = true) String is_good_position) {
                HashMap map = new HashMap();
                map.put("carousel_code", carousel_code);
                map.put("carousel_name", carousel_name);
                map.put("carousel_figure_id", carousel_figure_id);
                map.put("image", image);
                map.put("start_date", start_date);
                map.put("end_date", end_date);
                map.put("target_id", target_id);
                map.put("target_parameter", target_parameter);
                map.put("target_url", target_url);
                map.put("target_type", target_type);
                map.put("is_good_position", is_good_position);
        try {
            // 图片上传
            String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))
                    + "../../";
            // E:\newJ2EEWorkspaces\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
            pictureSaveFilePath = pictureSaveFilePath.substring(6); // 去掉
            // 'file:/'E:/newJ2EEWorkspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestUploadFile/WEB-INF/classes/../../
            if (null != image && !image.isEmpty()) { // 上传图片
                try {
                    String id = UuidUtil.get32UUID();// 0fad33b27b9f47eea37fdff85e1b2e86
                    // 扩展名格式：
                    String extName = "";
                    if (image.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
                    }
                    this.copyFile(image.getInputStream(), pictureSaveFilePath + "TP", id + extName).replaceAll("-", "");
                    map.put("picture_url", id + extName);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } else {// 没有上传图片
                map.put("state", "暂停");
            }
            int flag = carouselManageDao.updateCarousel(map);
             if(image!=null){
                 int flags = carouselManageDao.updateCarousel2(map);
                 if(flags ==0){
                     throw new UpdateInnerErrorException("更改失败");
                 }
             }
             return new CarouselManageExcution(CarouselManageEnum.SUCCESS,null);
        }catch (UpdateInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CarouselManageExcution updateChangeCarouse(@RequestParam(value = "state", required = true) String state,@RequestParam(value = "carousel_figure_id", required = true) int carousel_figure_id) {
             HashMap map = new HashMap();
             map.put("state",state);
             map.put("carousel_figure_id",carousel_figure_id);
        try {
            int info = carouselManageDao.updateChangeCarousel(state,carousel_figure_id);
            if (info > 0) {
                return new CarouselManageExcution(CarouselManageEnum.SUCCESS,null);
            }else {
                throw new UpdateInnerErrorException("编辑失败");
            }
        }catch (UpdateInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CarouselManageExcution deleteCarouse(CarouselManageDto carouselManageDto) {
               int carousel_figure_id = carouselManageDto.getCarousel_figure_id();
        try {
            int info = carouselManageDao.deleteCarousel(carousel_figure_id);
            if (info > 0) {
                return new CarouselManageExcution(CarouselManageEnum.SUCCESS,null);
            }else {
                throw new DeleteInnerErrorException("删除失败");
            }
        }catch (DeleteInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
