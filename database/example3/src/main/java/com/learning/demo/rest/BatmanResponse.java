package com.learning.demo.rest;

public class BatmanResponse {
    String callCount;
    String broodRemark;

    public BatmanResponse(String callCount, String broodRemark) {
        this.callCount = callCount;
        this.broodRemark = broodRemark;
    }

    public String getCallCount() {
        return callCount;
    }

    public void setCallCount(String callCount) {
        this.callCount = callCount;
    }

    public String getBroodRemark() {
        return broodRemark;
    }

    public void setBroodRemark(String broodRemark) {
        this.broodRemark = broodRemark;
    }

    @Override
    public String toString() {
        return "BatmanResponse{" +
                "callCount='" + callCount + '\'' +
                ", broodRemark='" + broodRemark + '\'' +
                '}';
    }
}
