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
    private String userNo;
    private Long meterNumber;
    private String maddr;
    private String userName;
    private String areaName;
    private String userDs;
    private double thNumber;
    private double lfNumber;
    private double snumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date thRTime;
    private String lfTime;
    private String state;

    private HaRecords haRecords;
    private HaRoom haRoom;
    private HaFreeze haFreeze;
    private HaCustom haCustom;
    private HaMeter haMeter;
    private HaPricestandard haPricestandard;
    private HaBuilding haBuilding;

    private String defaultOne;
    private String defaultTwo;
    private String defaultThree;
    private String defaultFour;
    private String defaultFive;
    private String emptyStr;
    private Integer waterMete;
    private String topEquipment;

    public HaBuilding getHaBuilding() {
        return haBuilding;
    }

    public void setHaBuilding(HaBuilding haBuilding) {
        this.haBuilding = haBuilding;
    }

    public HaMeter getHaMeter() {
        return haMeter;
    }

    public void setHaMeter(HaMeter haMeter) {
        this.haMeter = haMeter;
    }

    public HaPricestandard getHaPricestandard() {
        return haPricestandard;
    }

    public void setHaPricestandard(HaPricestandard haPricestandard) {
        this.haPricestandard = haPricestandard;
    }

    public HaCustom getHaCustom() {
        return haCustom;
    }

    public void setHaCustom(HaCustom haCustom) {
        this.haCustom = haCustom;
    }

    public HaFreeze getHaFreeze() {
        return haFreeze;
    }

    public void setHaFreeze(HaFreeze haFreeze) {
        this.haFreeze = haFreeze;
    }

    public HaRoom getHaRoom() {
        return haRoom;
    }

    public void setHaRoom(HaRoom haRoom) {
        this.haRoom = haRoom;
    }

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

    public double getSnumber() {
        return snumber;
    }

    public void setSnumber(double snumber) {
        this.snumber = snumber;
    }

    public String getDefaultOne() {

        return defaultOne;
    }

    public void setDefaultOne(String defaultOne) {
        this.defaultOne = defaultOne;
    }

    public String getEmptyStr() {
        return emptyStr;
    }

    public void setEmptyStr(String emptyStr) {
        this.emptyStr = emptyStr;
    }

    public Integer getWaterMete() {
        return waterMete;
    }

    public void setWaterMete(Integer waterMete) {
        this.waterMete = waterMete;
    }

    public String getTopEquipment() {
        return topEquipment;
    }

    public void setTopEquipment(String topEquipment) {
        this.topEquipment = topEquipment;
    }

    public String getDefaultTwo() {
        return defaultTwo;
    }

    public void setDefaultTwo(String defaultTwo) {
        this.defaultTwo = defaultTwo;
    }

    public String getDefaultThree() {
        return defaultThree;
    }

    public void setDefaultThree(String defaultThree) {
        this.defaultThree = defaultThree;
    }

    public String getDefaultFour() {
        return defaultFour;
    }

    public void setDefaultFour(String defaultFour) {
        this.defaultFour = defaultFour;
    }

    public String getDefaultFive() {
        return defaultFive;
    }

    public void setDefaultFive(String defaultFive) {
        this.defaultFive = defaultFive;
    }
}
