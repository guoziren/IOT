package com.ustc.iot.model.entity;

/*
 * 包名：      com.ustc.iot.model.entity
 * 文件名：      SingleComponent
 * 创建时间：      2020/7/4 5:50 PM
 *
 */
public class SingleComponent {

    /**
     * status : 0
     * data : {"id":1,"model":"AnybusModbus到KNX网关","innerProtocols":"Modbus TCP 、Modbus RTU ","uploadProtocols":"KNX","industrialGrade":"工业普通级","chargeable":0,"lowVoltage":9,"highVoltage":30,"lowTemperature":0,"highTemperature":60,"desc":"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。","otherDesc":"尺寸：90 x 88 x 56 mm"}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * model : AnybusModbus到KNX网关
         * innerProtocols : Modbus TCP 、Modbus RTU
         * uploadProtocols : KNX
         * industrialGrade : 工业普通级
         * chargeable : 0
         * lowVoltage : 9.0
         * highVoltage : 30.0
         * lowTemperature : 0.0
         * highTemperature : 60.0
         * desc : Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。
         * otherDesc : 尺寸：90 x 88 x 56 mm
         */

        private int id;
        private String model;
        private String innerProtocols;
        private String uploadProtocols;
        private String industrialGrade;
        private int chargeable;
        private double lowVoltage;
        private double highVoltage;
        private double lowTemperature;
        private double highTemperature;
        private String desc;
        private String otherDesc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getInnerProtocols() {
            return innerProtocols;
        }

        public void setInnerProtocols(String innerProtocols) {
            this.innerProtocols = innerProtocols;
        }

        public String getUploadProtocols() {
            return uploadProtocols;
        }

        public void setUploadProtocols(String uploadProtocols) {
            this.uploadProtocols = uploadProtocols;
        }

        public String getIndustrialGrade() {
            return industrialGrade;
        }

        public void setIndustrialGrade(String industrialGrade) {
            this.industrialGrade = industrialGrade;
        }

        public int getChargeable() {
            return chargeable;
        }

        public void setChargeable(int chargeable) {
            this.chargeable = chargeable;
        }

        public double getLowVoltage() {
            return lowVoltage;
        }

        public void setLowVoltage(double lowVoltage) {
            this.lowVoltage = lowVoltage;
        }

        public double getHighVoltage() {
            return highVoltage;
        }

        public void setHighVoltage(double highVoltage) {
            this.highVoltage = highVoltage;
        }

        public double getLowTemperature() {
            return lowTemperature;
        }

        public void setLowTemperature(double lowTemperature) {
            this.lowTemperature = lowTemperature;
        }

        public double getHighTemperature() {
            return highTemperature;
        }

        public void setHighTemperature(double highTemperature) {
            this.highTemperature = highTemperature;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getOtherDesc() {
            return otherDesc;
        }

        public void setOtherDesc(String otherDesc) {
            this.otherDesc = otherDesc;
        }
    }
}
