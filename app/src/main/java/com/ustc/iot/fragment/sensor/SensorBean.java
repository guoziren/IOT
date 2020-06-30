package com.ustc.iot.fragment.sensor;

import java.util.HashMap;

/*
 * 包名：      com.ustc.iot.fragment.sensor
 * 文件名：      SensorBean
 * 创建时间：      2020/6/30 4:01 AM
 *
 */
public class SensorBean {
    private String name;
    private HashMap<String,String> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
