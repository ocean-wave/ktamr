package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaMeter extends BaseEntity {

    private Integer meterId;
    /**
     * 房间ID
     */
    private Integer roomId;
    /**
     * 计费标准ID
     */
    private Integer pricestandId;
    private String addr;
    private Integer rate;
    private Integer isBranch;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    private Date lastTime;
    private double sNumber;
    private double jNumber;
    private double fNumber;
    private double pNumber;
    private double gNumber;
    private String state;
    private Date lfTime;
    private double lfNumber;
    private Date thTime;
    private double thNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date thRTime;
    private Integer areaId;
    private Integer meterNumber;
    private Date fDay;
    private Date fMon;
    private double fDayN;
    private double fMonN;
    private String isUsed;
    private double vendorMeterId;
    private Integer meterChannel;
    private Integer meterSequence;
    private long rssi;
    private long vol;
    private String ver;
    private String imsi;
    private String imei;
    private long offsetN;

    private HaVendor haVendor;
    private HaCentor haCentor;
    private HaCollector haCollector;
    private HaPricestandard haPricestandard;
    private HaRoom haRoom;
    private HaFreeze haFreeze;
    private HavMeterinfo havMeterinfo;
    private Integer haMeterCount;


    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPricestandId() {
        return pricestandId;
    }

    public void setPricestandId(Integer pricestandId) {
        this.pricestandId = pricestandId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getIsBranch() {
        return isBranch;
    }

    public void setIsBranch(Integer isBranch) {
        this.isBranch = isBranch;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public double getsNumber() {
        return sNumber;
    }

    public void setsNumber(double sNumber) {
        this.sNumber = sNumber;
    }

    public double getjNumber() {
        return jNumber;
    }

    public void setjNumber(double jNumber) {
        this.jNumber = jNumber;
    }

    public double getfNumber() {
        return fNumber;
    }

    public void setfNumber(double fNumber) {
        this.fNumber = fNumber;
    }

    public double getpNumber() {
        return pNumber;
    }

    public void setpNumber(double pNumber) {
        this.pNumber = pNumber;
    }

    public double getgNumber() {
        return gNumber;
    }

    public void setgNumber(double gNumber) {
        this.gNumber = gNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getLfTime() {
        return lfTime;
    }

    public void setLfTime(Date lfTime) {
        this.lfTime = lfTime;
    }

    public double getLfNumber() {
        return lfNumber;
    }

    public void setLfNumber(double lfNumber) {
        this.lfNumber = lfNumber;
    }

    public Date getThTime() {
        return thTime;
    }

    public void setThTime(Date thTime) {
        this.thTime = thTime;
    }

    public double getThNumber() {
        return thNumber;
    }

    public void setThNumber(double thNumber) {
        this.thNumber = thNumber;
    }

    public Date getThRTime() {
        return thRTime;
    }

    public void setThRTime(Date thRTime) {
        this.thRTime = thRTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(Integer meterNumber) {
        this.meterNumber = meterNumber;
    }

    public Date getfDay() {
        return fDay;
    }

    public void setfDay(Date fDay) {
        this.fDay = fDay;
    }

    public Date getfMon() {
        return fMon;
    }

    public void setfMon(Date fMon) {
        this.fMon = fMon;
    }

    public double getfDayN() {
        return fDayN;
    }

    public void setfDayN(double fDayN) {
        this.fDayN = fDayN;
    }

    public double getfMonN() {
        return fMonN;
    }

    public void setfMonN(double fMonN) {
        this.fMonN = fMonN;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public double getVendorMeterId() {
        return vendorMeterId;
    }

    public void setVendorMeterId(double vendorMeterId) {
        this.vendorMeterId = vendorMeterId;
    }

    public Integer getMeterChannel() {
        return meterChannel;
    }

    public void setMeterChannel(Integer meterChannel) {
        this.meterChannel = meterChannel;
    }

    public Integer getMeterSequence() {
        return meterSequence;
    }

    public void setMeterSequence(Integer meterSequence) {
        this.meterSequence = meterSequence;
    }

    public long getRssi() {
        return rssi;
    }

    public void setRssi(long rssi) {
        this.rssi = rssi;
    }

    public long getVol() {
        return vol;
    }

    public void setVol(long vol) {
        this.vol = vol;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getOffsetN() {
        return offsetN;
    }

    public void setOffsetN(long offsetN) {
        this.offsetN = offsetN;
    }

    public HaVendor getHaVendor() {
        return haVendor;
    }

    public void setHaVendor(HaVendor haVendor) {
        this.haVendor = haVendor;
    }

    public HaCentor getHaCentor() {
        return haCentor;
    }

    public void setHaCentor(HaCentor haCentor) {
        this.haCentor = haCentor;
    }

    public HaCollector getHaCollector() {
        return haCollector;
    }

    public void setHaCollector(HaCollector haCollector) {
        this.haCollector = haCollector;
    }

    public HaPricestandard getHaPricestandard() {
        return haPricestandard;
    }

    public void setHaPricestandard(HaPricestandard haPricestandard) {
        this.haPricestandard = haPricestandard;
    }

    public HaRoom getHaRoom() {
        return haRoom;
    }

    public void setHaRoom(HaRoom haRoom) {
        this.haRoom = haRoom;
    }

    public HaFreeze getHaFreeze() {
        return haFreeze;
    }

    public void setHaFreeze(HaFreeze haFreeze) {
        this.haFreeze = haFreeze;
    }

    public Integer getHaMeterCount() {
        return haMeterCount;
    }

    public void setHaMeterCount(Integer haMeterCount) {
        this.haMeterCount = haMeterCount;
    }

    public HavMeterinfo getHavMeterinfo() {
        return havMeterinfo;
    }

    public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
        this.havMeterinfo = havMeterinfo;
    }
}
