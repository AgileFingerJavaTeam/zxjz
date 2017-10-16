package com.zxjz.base;

import com.zxjz.util.PageData;
import com.zxjz.util.UuidUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class BaseController {

    public Logger logger= LoggerFactory.getLogger(this.getClass());


    /**
     * 得到32位的uuid
     * @return
     */
    public String get32UUID(){

        return UuidUtil.get32UUID();
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }
    /**
     * 写文件到当前目录的upload目录
     *
     * @param in
     *
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



    public PageData getPageData(){
        return new PageData(this.getRequest());
    }
}
