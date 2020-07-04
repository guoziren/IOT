package com.ustc.iot.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/*
 * 包名：      com.ustc.iot.util
 * 文件名：      ReflectUtil
 * 创建时间：      2020/7/4 5:26 PM
 *
 */
public class ReflectUtil {
    public static String[] getFieldName(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
    /* 根据属性名获取属性值
     * */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {

            return null;
        }
    }

    private static HashMap<String,String> map = new HashMap<>();
    public static void initMap( ){
        map.put("model","型号");
        map.put("innerprotocols","网间协议");
        map.put("uploadProtocols","上传协议");
        map.put("industrialGrade","行业等级");
        map.put("chargeable","是否可充电");
        map.put("lowVoltage","低压");
        map.put("highVoltage","高压");
        map.put("lowTemperature","低温");
        map.put("highTemperature","高温");
        map.put("ohterDesc","其他");
        map.put("desc","详情");
    }
    public static String getString(String name){
            return map.get(name) == null ? name :map.get(name);
    }
}
