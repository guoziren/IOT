package com.ustc.iot.model.entity;

/*
 * 包名：      com.ustc.iot.model
 * 文件名：      Solution 解决方案
 * 创建时间：      2020/5/28 10:26 PM
 *
 */
public class Solution {
    private String name;//解决方案名称
    private String desc;//方案介绍
    private String createdPersonName;//创建人
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

    public String getCreatedPersonName() {
        return createdPersonName;
    }

    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
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
