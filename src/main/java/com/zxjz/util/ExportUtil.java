package com.zxjz.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

public class ExportUtil {
    /**
     *
     *              导出生成csv文件
     * @author      ccg
     * @param       titles       标题头
     * @param       propertys    每一列标题头对应数据集合里对象的属性
     * @param       list         数据集合
     * @param       fileName     文件名称注意不能有空格以及冒号
     * @param       request
     * @param       response
     * @return
     * @throws      IOException
     * @throws      IllegalArgumentException
     * @throws      IllegalAccessException
     * Created      2017年2月22日 下午8:35:57
     */
    public static<T> String exportCsv(String[] titles, String[] propertys, List<T> list, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalArgumentException, IllegalAccessException{
        BufferedWriter bw = null;

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment; filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //构建输出流，同时指定编码
        bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"gbk"));

        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for(String title : titles){
            bw.write(title);
            bw.write(",");
        }
        //写完文件头后换行
        bw.write("\r\n");
        //写内容
        for(Object obj :list){
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for(String property : propertys){
                for(Field field : fields){
                    //设置字段可见性
                    field.setAccessible(true);
                    if(property.equals(field.getName())){
                        bw.write(field.get(obj).toString());
                        //如果包含:说明是日期最后写一个|否则日期不显示秒
                        if((field.get(obj).toString()).indexOf(":") > -1){
                            bw.write("|");
                        }
                        bw.write(",");
                        continue;
                    }
                }
            }
            //写完一行换行
            bw.write("\r\n");
        }
        bw.flush();
        bw.close();
        return "0";
    }


}
