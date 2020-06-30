package com.ustc.iot.network;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      Response
 * 创建时间：      2020/6/29 8:31 PM
 *
 */
public class Response {
    private String objectId;
    private String sessionToken;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
