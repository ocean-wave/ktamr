package com.ktamr.domain;


public class PmKt3Nb {

  private long id;
  private long batchId;
  private String deviceCode;
  private java.sql.Timestamp createTime;
  private String setState;
  private String getState;
  private String state;
  private String description;
  private long rssi;
  private long vol;
  private String imsi;
  private String imei;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getBatchId() {
    return batchId;
  }

  public void setBatchId(long batchId) {
    this.batchId = batchId;
  }


  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getSetState() {
    return setState;
  }

  public void setSetState(String setState) {
    this.setState = setState;
  }


  public String getGetState() {
    return getState;
  }

  public void setGetState(String getState) {
    this.getState = getState;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

}
