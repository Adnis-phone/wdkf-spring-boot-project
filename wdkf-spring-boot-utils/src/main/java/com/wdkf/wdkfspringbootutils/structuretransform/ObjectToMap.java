package com.wdkf.wdkfspringbootutils.structuretransform;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: ObjectToMap
 * @Description: 将object对象转化为Map对象
 * @Author: wangdehonga
 * @Date: 2020/7/6 9:27
 * @Version: 1.0
 */
public class ObjectToMap {

    public Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            // 设置些属性是可以访问的
            f.setAccessible(true);
            Object val = new Object();
            try {
                // 得到此属性的值
                val = f.get(obj);
                // 设置键值
                map.put(f.getName(), val);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return map;
    }
}
