package com.zxjz.base;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunzhongyuan on 2017/10/16.
 */
public class BaseUIResult {


    public static String returnJsonEasyUI(BaseAPIExcution baseAPIExcution) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        String result = "";
        Map<String,Object> dataMap = (HashMap<String,Object>)baseAPIExcution.getData();
        try {
            map.put("rows",dataMap.get("rows"));
            map.put("total",dataMap.get("total"));
            result=mapper.writeValueAsString(map);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
