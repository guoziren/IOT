package com.ustc.iot.fragment.gatewaycenter;

import java.util.LinkedHashMap;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      GatewayBean
 * 创建时间：      2020/6/30 3:06 AM
 *
 */
public class GatewayBean {
    private String name;
    private LinkedHashMap<String, String> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, String> getMap() {
        return map;
    }

    public void setMap(LinkedHashMap<String, String> map) {
        this.map = map;
    }
}
