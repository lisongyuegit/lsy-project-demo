package com.lsytest.demo.statistics;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
