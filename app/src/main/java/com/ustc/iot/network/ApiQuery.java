package com.ustc.iot.network;

import com.google.gson.Gson;
import com.ustc.iot.model.entity.ConditionQueryResponse;
import com.ustc.iot.model.entity.SingleComponent;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiQuery
 * 创建时间：      2020/7/3 9:44 PM
 *
 */
public class ApiQuery {
    private static final String TAG = "ApiQuery";
    public static final String TEST_A = "{\n" +
            "    \"status\": 0,\n" +
            "    \"data\": {\n" +
            "        \"total\": 4,\n" +
            "        \"list\": [\n" +
            "            {\n" +
            "                \"id\": 1,\n" +
            "                \"model\": \"AnybusModbus到KNX网关\",\n" +
            "                \"innerProtocols\": \"Modbus TCP 、Modbus RTU \",\n" +
            "                \"uploadProtocols\": \"KNX\",\n" +
            "                \"industrialGrade\": \"工业普通级\",\n" +
            "                \"chargeable\": 0,\n" +
            "                \"lowVoltage\": 9.0,\n" +
            "                \"highVoltage\": 30.0,\n" +
            "                \"lowTemperature\": 0.0,\n" +
            "                \"highTemperature\": 60.0,\n" +
            "                \"desc\": \"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。\",\n" +
            "                \"otherDesc\": \"尺寸：90 x 88 x 56 mm\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 2,\n" +
            "                \"model\": \"AnybusModbus到KNX网关2\",\n" +
            "                \"innerProtocols\": \"Modbus TCP 、Modbus RTU \",\n" +
            "                \"uploadProtocols\": \"KNX\",\n" +
            "                \"industrialGrade\": \"工业普通级\",\n" +
            "                \"chargeable\": 0,\n" +
            "                \"lowVoltage\": 9.0,\n" +
            "                \"highVoltage\": 30.0,\n" +
            "                \"lowTemperature\": 0.0,\n" +
            "                \"highTemperature\": 60.0,\n" +
            "                \"desc\": \"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。\",\n" +
            "                \"otherDesc\": \"尺寸：90 x 88 x 56 mm\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 3,\n" +
            "                \"model\": \"xumu\",\n" +
            "                \"innerProtocols\": \"TCP\",\n" +
            "                \"uploadProtocols\": \"KNX\",\n" +
            "                \"industrialGrade\": \"gongye\",\n" +
            "                \"chargeable\": 0,\n" +
            "                \"lowVoltage\": 8.0,\n" +
            "                \"highVoltage\": 66.0,\n" +
            "                \"lowTemperature\": 0.0,\n" +
            "                \"highTemperature\": 60.0,\n" +
            "                \"desc\": \"xxxxxx\",\n" +
            "                \"otherDesc\": \"xxxxxxxxx\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 5,\n" +
            "                \"model\": \"xumu5\",\n" +
            "                \"innerProtocols\": \"TCP\",\n" +
            "                \"uploadProtocols\": \"KNX\",\n" +
            "                \"industrialGrade\": \"gongye\",\n" +
            "                \"chargeable\": 0,\n" +
            "                \"lowVoltage\": 8.0,\n" +
            "                \"highVoltage\": 66.0,\n" +
            "                \"lowTemperature\": 0.0,\n" +
            "                \"highTemperature\": 60.0,\n" +
            "                \"desc\": \"xxxxxx\",\n" +
            "                \"otherDesc\": \"xxxxxxxxx\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"pageNum\": 1,\n" +
            "        \"pageSize\": 10,\n" +
            "        \"size\": 4,\n" +
            "        \"startRow\": 1,\n" +
            "        \"endRow\": 4,\n" +
            "        \"pages\": 1,\n" +
            "        \"prePage\": 0,\n" +
            "        \"nextPage\": 0,\n" +
            "        \"isFirstPage\": true,\n" +
            "        \"isLastPage\": true,\n" +
            "        \"hasPreviousPage\": false,\n" +
            "        \"hasNextPage\": false,\n" +
            "        \"navigatePages\": 8,\n" +
            "        \"navigatepageNums\": [\n" +
            "            1\n" +
            "        ],\n" +
            "        \"navigateFirstPage\": 1,\n" +
            "        \"navigateLastPage\": 1\n" +
            "    }\n" +
            "}";
    public static ConditionQueryResponse queryComponentByModel(int type){
        ConditionQueryResponse response = new Gson().fromJson(SINGLE_COMPONENT, ConditionQueryResponse.class);
       return response;
    }
    public static ConditionQueryResponse queryComponentByOther(int type){
        ConditionQueryResponse response = new Gson().fromJson(TEST_A, ConditionQueryResponse.class);
        return response;
    }
    public static final String SINGLE_COMPONENT = "{\n" +
            "    \"status\": 0,\n" +
            "    \"data\": {\n" +
            "        \"total\": 1,\n" +
            "        \"list\": [\n" +
            "            {\n" +
            "                \"id\": 1,\n" +
            "                \"model\": \"AnybusModbus到KNX网关\",\n" +
            "                \"innerProtocols\": \"Modbus TCP 、Modbus RTU \",\n" +
            "                \"uploadProtocols\": \"KNX\",\n" +
            "                \"industrialGrade\": \"工业普通级\",\n" +
            "                \"chargeable\": 0,\n" +
            "                \"lowVoltage\": 9.0,\n" +
            "                \"highVoltage\": 30.0,\n" +
            "                \"lowTemperature\": 0.0,\n" +
            "                \"highTemperature\": 60.0,\n" +
            "                \"desc\": \"Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。\",\n" +
            "                \"otherDesc\": \"尺寸：90 x 88 x 56 mm\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"pageNum\": 1,\n" +
            "        \"pageSize\": 10,\n" +
            "        \"size\": 4,\n" +
            "        \"startRow\": 1,\n" +
            "        \"endRow\": 4,\n" +
            "        \"pages\": 1,\n" +
            "        \"prePage\": 0,\n" +
            "        \"nextPage\": 0,\n" +
            "        \"isFirstPage\": true,\n" +
            "        \"isLastPage\": true,\n" +
            "        \"hasPreviousPage\": false,\n" +
            "        \"hasNextPage\": false,\n" +
            "        \"navigatePages\": 8,\n" +
            "        \"navigatepageNums\": [\n" +
            "            1\n" +
            "        ],\n" +
            "        \"navigateFirstPage\": 1,\n" +
            "        \"navigateLastPage\": 1\n" +
            "    }\n" +
            "}";
    public static ConditionQueryResponse queryByid(int type, int id){
        return  new Gson().fromJson(TEST_A, ConditionQueryResponse.class);
    }

}
