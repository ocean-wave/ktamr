package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HatDevicesimport extends BaseEntity {

  private Integer id;
  private String deviceId;
  private String deviceName;
  private String description;
  private String areaName;
  private String areaNo;
  private Integer areaId;
  private Date setupTime;
  private String tel;
  private String reMark;
  private String check;
  private Date importTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getAreaNo() {
    return areaNo;
  }

  public void setAreaNo(String areaNo) {
    this.areaNo = areaNo;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Date getSetupTime() {
    return setupTime;
  }

  public void setSetupTime(Date setupTime) {
    this.setupTime = setupTime;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getReMark() {
    return reMark;
  }

  public void setReMark(String reMark) {
    this.reMark = reMark;
  }

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }
}
