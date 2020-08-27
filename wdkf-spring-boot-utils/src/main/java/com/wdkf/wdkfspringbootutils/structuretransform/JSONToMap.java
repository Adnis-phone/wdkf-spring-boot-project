package com.wdkf.wdkfspringbootutils.structuretransform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: JSONToMap
 * @Description: JSON字符串转化为Map对象工具
 * @Author: wangdehonga
 * @Date: 2020/7/6 9:25
 * @Version: 1.0
 */
public class JSONToMap {

    public Map<String, Object> parseJSON2Map(String jsonStr) {
        if(StringUtils.isEmpty(jsonStr)) {
            Map<String, Object> map = new HashMap<String, Object>();
            JSONObject json = JSONObject.parseObject(jsonStr);
            for (Object k : json.keySet()) {
                Object v = json.get(k);
                if (v instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    Iterator<Object> it = ((JSONArray) v).iterator();
                    while (it.hasNext()) {
                        JSONObject json2 = (JSONObject) it.next();
                        list.add(parseJSON2Map(json2.toString()));
                    }
                    map.put(k.toString(), list);
                } else {
                    map.put(k.toString(), v);
                }
            }
            return map;
        }
        return null;
    }
}
