package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaImportcustom extends BaseEntity {

  private Integer id;
  private String custNo;
  private String custName;
  private String areaName;
  private String buildingName;
  private String roomName;
  private double meterNo;
  private Integer meterChannel;
  private Integer meterSequence;
  private Integer vendorId;
  private Integer areaId;
  private Integer buildingId;
  private Integer roomId;
  private String centorNo;
  private String collectorNo;
  private Integer centorId;
  private Integer collectorId;
  private String state;
  private double meterNoD;
  private String meterType;
  private String meterIsbranch;
  private Integer meterOriNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date setupTime;
  private String priceStandard;
  private double meterRate;
  private String custSex;
  private String custMobile;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date importTime;
  private Integer useMeterSequence;
  private Integer custBalance;

  private HaCentor haCentor;
  private HaCollector haCollector;

  private String fileName;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCustNo() {
    return custNo;
  }

  public void setCustNo(String custNo) {
    this.custNo = custNo;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public double getMeterNo() {
    return meterNo;
  }

  public void setMeterNo(double meterNo) {
    this.meterNo = meterNo;
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

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
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

  public String getCentorNo() {
    return centorNo;
  }

  public void setCentorNo(String centorNo) {
    this.centorNo = centorNo;
  }

  public String getCollectorNo() {
    return collectorNo;
  }

  public void setCollectorNo(String collectorNo) {
    this.collectorNo = collectorNo;
  }

  public Integer getCentorId() {
    return centorId;
  }

  public void setCentorId(Integer centorId) {
    this.centorId = centorId;
  }

  public Integer getCollectorId() {
    return collectorId;
  }

  public void setCollectorId(Integer collectorId) {
    this.collectorId = collectorId;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public double getMeterNoD() {
    return meterNoD;
  }

  public void setMeterNoD(double meterNoD) {
    this.meterNoD = meterNoD;
  }

  public String getMeterType() {
    return meterType;
  }

  public void setMeterType(String meterType) {
    this.meterType = meterType;
  }

  public String getMeterIsbranch() {
    return meterIsbranch;
  }

  public void setMeterIsbranch(String meterIsbranch) {
    this.meterIsbranch = meterIsbranch;
  }

  public Integer getMeterOriNum() {
    return meterOriNum;
  }

  public void setMeterOriNum(Integer meterOriNum) {
    this.meterOriNum = meterOriNum;
  }

  public Date getSetupTime() {
    return setupTime;
  }

  public void setSetupTime(Date setupTime) {
    this.setupTime = setupTime;
  }

  public String getPriceStandard() {
    return priceStandard;
  }

  public void setPriceStandard(String priceStandard) {
    this.priceStandard = priceStandard;
  }

  public double getMeterRate() {
    return meterRate;
  }

  public void setMeterRate(double meterRate) {
    this.meterRate = meterRate;
  }

  public String getCustSex() {
    return custSex;
  }

  public void setCustSex(String custSex) {
    this.custSex = custSex;
  }

  public String getCustMobile() {
    return custMobile;
  }

  public void setCustMobile(String custMobile) {
    this.custMobile = custMobile;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }

  public Integer getUseMeterSequence() {
    return useMeterSequence;
  }

  public void setUseMeterSequence(Integer useMeterSequence) {
    this.useMeterSequence = useMeterSequence;
  }

  public Integer getCustBalance() {
    return custBalance;
  }

  public void setCustBalance(Integer custBalance) {
    this.custBalance = custBalance;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
