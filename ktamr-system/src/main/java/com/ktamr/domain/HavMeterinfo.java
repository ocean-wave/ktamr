package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

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
  private Integer priceStandId;


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

  public Integer getPriceStandId() {
    return priceStandId;
  }

  public void setPriceStandId(Integer priceStandId) {
    this.priceStandId = priceStandId;
  }
}
