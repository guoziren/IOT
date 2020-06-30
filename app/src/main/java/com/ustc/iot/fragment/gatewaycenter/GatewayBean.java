package com.ustc.iot.fragment.gatewaycenter;

import java.util.HashMap;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      GatewayBean
 * 创建时间：      2020/6/30 3:06 AM
 *
 */
public class GatewayBean {
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
