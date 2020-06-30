package com.ustc.iot.model.entity;

/*
 * 包名：      com.ustc.iot.model
 * 文件名：      Sensor
 * 创建时间：      2020/5/28 10:29 PM
 *
 */
public class Sensor {
    private String name;//传感器名称
    private String desc;//传感器介绍
    private String trade;//公司行业
    private String company;//所属公司
    private String address;//公司地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
