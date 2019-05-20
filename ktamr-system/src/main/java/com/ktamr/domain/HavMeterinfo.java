package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HavMeterinfo extends BaseEntity {

    private Integer meterId;
    private Integer areaId;
    private String areaNo;
    private String ds;
    private Integer buildingId;
    private Integer roomId;
    private Integer centorId;
    private Integer deviceId;
    private String centorNo;
    private String addr;
    private Integer custId;
    private Integer pricestandId;
    private String userNo;//�û���
    private Long meterNumber;//���
    private String maddr;//���ַ
    private String userName;//�û���
    private String areaName;//С����
    private String userDs;//�û���ַ
    private double thNumber;//�������
    private double lfNumber;//���ڶ���
    private double sNumber;//��������
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date thRTime;//����ʱ��
    private String lfTime;//���ڳ���ʱ��
    private String state;//״̬

    private HaRecords haRecords;

    public HaRecords getHaRecords() {
        return haRecords;
    }

    public void setHaRecords(HaRecords haRecords) {
        this.haRecords = haRecords;
    }

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCentorId() {
        return centorId;
    }

    public void setCentorId(Integer centorId) {
        this.centorId = centorId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getCentorNo() {
        return centorNo;
    }

    public void setCentorNo(String centorNo) {
        this.centorNo = centorNo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getPricestandId() {
        return pricestandId;
    }

    public void setPricestandId(Integer pricestandId) {
        this.pricestandId = pricestandId;
    }

    public Date getThRTime() {
        return thRTime;
    }

    public void setThRTime(Date thRTime) {
        this.thRTime = thRTime;
    }

    public Long getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(Long meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getMaddr() {
        return maddr;
    }

    public void setMaddr(String maddr) {
        this.maddr = maddr;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserDs() {
        return userDs;
    }

    public void setUserDs(String userDs) {
        this.userDs = userDs;
    }

    public double getThNumber() {
        return thNumber;
    }

    public void setThNumber(double thNumber) {
        this.thNumber = thNumber;
    }

    public double getLfNumber() {
        return lfNumber;
    }

    public void setLfNumber(double lfNumber) {
        this.lfNumber = lfNumber;
    }

    public double getsNumber() {
        return sNumber;
    }

    public void setsNumber(double sNumber) {
        this.sNumber = sNumber;
    }

    public String getLfTime() {
        return lfTime;
    }

    public void setLfTime(String lfTime) {
        this.lfTime = lfTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
