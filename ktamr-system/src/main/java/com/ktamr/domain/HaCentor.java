package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaCentor extends BaseEntity {

  private Integer id;
  private Long centorId;
  private String ver;
  private String rtime;
  private java.sql.Timestamp setuptime;
  private String addr;
  private String description;
  private String telnumber;
  private java.sql.Timestamp endtime;
  private String usetypecode;
  private String state;
  private String centorNo;
  private java.sql.Timestamp lastfreezetime;
  private java.sql.Timestamp lastfreezeday;
  private java.sql.Timestamp lastfreezemon;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp modifytime;
  private long meters;
  private long areaid;
  private java.sql.Timestamp lastStateChangeTime;
  private String remark;
  private long rssi;
  private long vol;
  private String imsi;
  private String imei;

  private HaArea haArea;

  public Long getCentorId() {
    return centorId;
  }

  public void setCentorId(Long centorId) {
    this.centorId = centorId;
  }

  public HaArea getHaArea() {
    return haArea;
  }

  public void setHaArea(HaArea haArea) {
    this.haArea = haArea;
  }

  public String getCentorNo() {
    return centorNo;
  }

  public void setCentorNo(String centorNo) {
    this.centorNo = centorNo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }


  public String getRtime() {
    return rtime;
  }

  public void setRtime(String rtime) {
    this.rtime = rtime;
  }


  public java.sql.Timestamp getSetuptime() {
    return setuptime;
  }

  public void setSetuptime(java.sql.Timestamp setuptime) {
    this.setuptime = setuptime;
  }


  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getTelnumber() {
    return telnumber;
  }

  public void setTelnumber(String telnumber) {
    this.telnumber = telnumber;
  }


  public java.sql.Timestamp getEndtime() {
    return endtime;
  }

  public void setEndtime(java.sql.Timestamp endtime) {
    this.endtime = endtime;
  }


  public String getUsetypecode() {
    return usetypecode;
  }

  public void setUsetypecode(String usetypecode) {
    this.usetypecode = usetypecode;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public java.sql.Timestamp getLastfreezetime() {
    return lastfreezetime;
  }

  public void setLastfreezetime(java.sql.Timestamp lastfreezetime) {
    this.lastfreezetime = lastfreezetime;
  }


  public java.sql.Timestamp getLastfreezeday() {
    return lastfreezeday;
  }

  public void setLastfreezeday(java.sql.Timestamp lastfreezeday) {
    this.lastfreezeday = lastfreezeday;
  }


  public java.sql.Timestamp getLastfreezemon() {
    return lastfreezemon;
  }

  public void setLastfreezemon(java.sql.Timestamp lastfreezemon) {
    this.lastfreezemon = lastfreezemon;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public java.sql.Timestamp getModifytime() {
    return modifytime;
  }

  public void setModifytime(java.sql.Timestamp modifytime) {
    this.modifytime = modifytime;
  }


  public long getMeters() {
    return meters;
  }

  public void setMeters(long meters) {
    this.meters = meters;
  }


  public long getAreaid() {
    return areaid;
  }

  public void setAreaid(long areaid) {
    this.areaid = areaid;
  }


  public java.sql.Timestamp getLastStateChangeTime() {
    return lastStateChangeTime;
  }

  public void setLastStateChangeTime(java.sql.Timestamp lastStateChangeTime) {
    this.lastStateChangeTime = lastStateChangeTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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
