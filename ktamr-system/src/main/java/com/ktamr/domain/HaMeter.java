package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaMeter extends BaseEntity {

  private Integer meterId;
  private String addr;
  private long rate;
  private long isbranch;
  @JsonFormat( pattern = "yyyy-MM-dd HH:MM:SS")
  private Date startTime;
  private Date lasttime;
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
  @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
  private Date thRTime;
  private Integer areaId;
  private Long meterNumber;
  private Date fday;
  private Date fmon;
  private double fdayN;
  private double fmonN;
  private String isUsed;
  private double vendorMeterid;
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
  private Integer haMeterCount;

  public Integer getHaMeterCount() {
    return haMeterCount;
  }

  public void setHaMeterCount(Integer haMeterCount) {
    this.haMeterCount = haMeterCount;
  }

  public double getsNumber() {
    return sNumber;
  }

  public void setsNumber(double sNumber) {
    this.sNumber = sNumber;
  }

  public double getLfNumber() {
    return lfNumber;
  }

  public void setLfNumber(double lfNumber) {
    this.lfNumber = lfNumber;
  }

  public double getThNumber() {
    return thNumber;
  }

  public void setThNumber(double thNumber) {
    this.thNumber = thNumber;
  }

  public Long getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(Long meterNumber) {
    this.meterNumber = meterNumber;
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

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public HaPricestandard getHaPricestandard() {
    return haPricestandard;
  }

  public void setHaPricestandard(HaPricestandard haPricestandard) {
    this.haPricestandard = haPricestandard;
  }

  public HaCollector getHaCollector() {
    return haCollector;
  }

  public void setHaCollector(HaCollector haCollector) {
    this.haCollector = haCollector;
  }

  public HaCentor getHaCentor() {
    return haCentor;
  }

  public void setHaCentor(HaCentor haCentor) {
    this.haCentor = haCentor;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
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

  public HaVendor getHaVendor() {
    return haVendor;
  }

  public void setHaVendor(HaVendor haVendor) {
    this.haVendor = haVendor;
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

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Date getLasttime() {
    return lasttime;
  }

  public void setLasttime(Date lasttime) {
    this.lasttime = lasttime;
  }

  public Date getLfTime() {
    return lfTime;
  }

  public void setLfTime(Date lfTime) {
    this.lfTime = lfTime;
  }

  public Date getThTime() {
    return thTime;
  }

  public void setThTime(Date thTime) {
    this.thTime = thTime;
  }

  public Date getThRTime() {
    return thRTime;
  }

  public void setThRTime(Date thRTime) {
    this.thRTime = thRTime;
  }

  public Date getFday() {
    return fday;
  }

  public void setFday(Date fday) {
    this.fday = fday;
  }

  public Date getFmon() {
    return fmon;
  }

  public void setFmon(Date fmon) {
    this.fmon = fmon;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }


  public long getRate() {
    return rate;
  }

  public void setRate(long rate) {
    this.rate = rate;
  }


  public long getIsbranch() {
    return isbranch;
  }

  public void setIsbranch(long isbranch) {
    this.isbranch = isbranch;
  }

  public double getJNumber() {
    return jNumber;
  }

  public void setJNumber(double jNumber) {
    this.jNumber = jNumber;
  }


  public double getFNumber() {
    return fNumber;
  }

  public void setFNumber(double fNumber) {
    this.fNumber = fNumber;
  }


  public double getPNumber() {
    return pNumber;
  }

  public void setPNumber(double pNumber) {
    this.pNumber = pNumber;
  }


  public double getGNumber() {
    return gNumber;
  }

  public void setGNumber(double gNumber) {
    this.gNumber = gNumber;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public double getFdayN() {
    return fdayN;
  }

  public void setFdayN(double fdayN) {
    this.fdayN = fdayN;
  }


  public double getFmonN() {
    return fmonN;
  }

  public void setFmonN(double fmonN) {
    this.fmonN = fmonN;
  }

  public String getIsUsed() {
    return isUsed;
  }

  public void setIsUsed(String isUsed) {
    this.isUsed = isUsed;
  }


  public double getVendorMeterid() {
    return vendorMeterid;
  }

  public void setVendorMeterid(double vendorMeterid) {
    this.vendorMeterid = vendorMeterid;
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

}
