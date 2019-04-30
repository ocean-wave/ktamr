package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class PmKt3Nb extends BaseEntity {

  private Integer id;
  private Integer batchId;
  private String deviceCode;
  private Date createTime;
  private String setState;
  private String getState;
  private String state;
  private String description;
  private Integer rssi;
  private Integer vol;
  private String imsi;
  private String imei;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBatchId() {
    return batchId;
  }

  public void setBatchId(Integer batchId) {
    this.batchId = batchId;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
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

  public Integer getRssi() {
    return rssi;
  }

  public void setRssi(Integer rssi) {
    this.rssi = rssi;
  }

  public Integer getVol() {
    return vol;
  }

  public void setVol(Integer vol) {
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
