package com.ktamr.domain;


public class HatDevicesimport {

  private long id;
  private String deviceid;
  private String devicename;
  private String description;
  private String areaname;
  private String areano;
  private long areaid;
  private java.sql.Timestamp setuptime;
  private String tel;
  private String remark;
  private String check;
  private java.sql.Timestamp importtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeviceid() {
    return deviceid;
  }

  public void setDeviceid(String deviceid) {
    this.deviceid = deviceid;
  }


  public String getDevicename() {
    return devicename;
  }

  public void setDevicename(String devicename) {
    this.devicename = devicename;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getAreaname() {
    return areaname;
  }

  public void setAreaname(String areaname) {
    this.areaname = areaname;
  }


  public String getAreano() {
    return areano;
  }

  public void setAreano(String areano) {
    this.areano = areano;
  }


  public long getAreaid() {
    return areaid;
  }

  public void setAreaid(long areaid) {
    this.areaid = areaid;
  }


  public java.sql.Timestamp getSetuptime() {
    return setuptime;
  }

  public void setSetuptime(java.sql.Timestamp setuptime) {
    this.setuptime = setuptime;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }


  public java.sql.Timestamp getImporttime() {
    return importtime;
  }

  public void setImporttime(java.sql.Timestamp importtime) {
    this.importtime = importtime;
  }

}
