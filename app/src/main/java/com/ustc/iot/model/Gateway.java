package com.ustc.iot.model;

/*
 * 包名：      com.ustc.iot.model
 * 文件名：      Gateway
 * 创建时间：      2020/5/28 7:48 PM
 *
 */
public class Gateway {
    private String name;//网关名称
    private String company;//所属公司
    private String trade;//行业
    private String desc;//网关介绍

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
