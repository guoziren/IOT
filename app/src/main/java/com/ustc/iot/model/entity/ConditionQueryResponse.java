package com.ustc.iot.model.entity;

import java.util.List;

/*
 * 包名：      com.ustc.iot.model.entity
 * 文件名：      ConditionQueryResponse
 * 创建时间：      2020/7/3 12:43 AM
 *
 */
public class ConditionQueryResponse {

    /**
     * status : 0
     * data : {"total":4,"list":[{"id":1,"model":"AnybusModbus到KNX网关","innerProtocols":"Modbus TCP 、Modbus RTU ","uploadProtocols":"KNX","industrialGrade":"工业普通级","chargeable":0,"lowVoltage":9,"highVoltage":30,"lowTemperature":0,"highTemperature":60,"desc":"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。","otherDesc":"尺寸：90 x 88 x 56 mm"},{"id":2,"model":"AnybusModbus到KNX网关2","innerProtocols":"Modbus TCP 、Modbus RTU ","uploadProtocols":"KNX","industrialGrade":"工业普通级","chargeable":0,"lowVoltage":9,"highVoltage":30,"lowTemperature":0,"highTemperature":60,"desc":"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。","otherDesc":"尺寸：90 x 88 x 56 mm"},{"id":3,"model":"xumu","innerProtocols":"TCP","uploadProtocols":"KNX","industrialGrade":"gongye","chargeable":0,"lowVoltage":8,"highVoltage":66,"lowTemperature":0,"highTemperature":60,"desc":"xxxxxx","otherDesc":"xxxxxxxxx"},{"id":5,"model":"xumu5","innerProtocols":"TCP","uploadProtocols":"KNX","industrialGrade":"gongye","chargeable":0,"lowVoltage":8,"highVoltage":66,"lowTemperature":0,"highTemperature":60,"desc":"xxxxxx","otherDesc":"xxxxxxxxx"}],"pageNum":1,"pageSize":10,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 4
         * list : [{"id":1,"model":"AnybusModbus到KNX网关","innerProtocols":"Modbus TCP 、Modbus RTU ","uploadProtocols":"KNX","industrialGrade":"工业普通级","chargeable":0,"lowVoltage":9,"highVoltage":30,"lowTemperature":0,"highTemperature":60,"desc":"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。","otherDesc":"尺寸：90 x 88 x 56 mm"},{"id":2,"model":"AnybusModbus到KNX网关2","innerProtocols":"Modbus TCP 、Modbus RTU ","uploadProtocols":"KNX","industrialGrade":"工业普通级","chargeable":0,"lowVoltage":9,"highVoltage":30,"lowTemperature":0,"highTemperature":60,"desc":"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。","otherDesc":"尺寸：90 x 88 x 56 mm"},{"id":3,"model":"xumu","innerProtocols":"TCP","uploadProtocols":"KNX","industrialGrade":"gongye","chargeable":0,"lowVoltage":8,"highVoltage":66,"lowTemperature":0,"highTemperature":60,"desc":"xxxxxx","otherDesc":"xxxxxxxxx"},{"id":5,"model":"xumu5","innerProtocols":"TCP","uploadProtocols":"KNX","industrialGrade":"gongye","chargeable":0,"lowVoltage":8,"highVoltage":66,"lowTemperature":0,"highTemperature":60,"desc":"xxxxxx","otherDesc":"xxxxxxxxx"}]
         * pageNum : 1
         * pageSize : 10
         * size : 4
         * startRow : 1
         * endRow : 4
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

        private int total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 1
             * model : AnybusModbus到KNX网关
             * innerProtocols : Modbus TCP 、Modbus RTU
             * uploadProtocols : KNX
             * industrialGrade : 工业普通级
             * chargeable : 0
             * lowVoltage : 9
             * highVoltage : 30
             * lowTemperature : 0
             * highTemperature : 60
             * desc : Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。
             * otherDesc : 尺寸：90 x 88 x 56 mm
             */

            private int id;
            private String model;
            private String innerProtocols;
            private String uploadProtocols;
            private String industrialGrade;
            private int chargeable;
            private int lowVoltage;
            private int highVoltage;
            private int lowTemperature;
            private int highTemperature;
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

            public int getLowVoltage() {
                return lowVoltage;
            }

            public void setLowVoltage(int lowVoltage) {
                this.lowVoltage = lowVoltage;
            }

            public int getHighVoltage() {
                return highVoltage;
            }

            public void setHighVoltage(int highVoltage) {
                this.highVoltage = highVoltage;
            }

            public int getLowTemperature() {
                return lowTemperature;
            }

            public void setLowTemperature(int lowTemperature) {
                this.lowTemperature = lowTemperature;
            }

            public int getHighTemperature() {
                return highTemperature;
            }

            public void setHighTemperature(int highTemperature) {
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
}
