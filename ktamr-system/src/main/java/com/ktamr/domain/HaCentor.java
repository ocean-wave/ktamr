package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaCentor extends BaseEntity {

  private Integer id;
  private long centorId;
  private String ver;
  private String rTime;
  private Date setupTime;
  private String addr;
  private String description;
  private String telNumber;
  private Date endTime;
  private String useTypeCode;
  private String state;
  private String centorNo;
  private Date lastfreezeTime;
  private Date lastfreezeDay;
  private Date lastfreezeMon;
  private Date createTime;
  private Date modifyTime;
  private Integer meters;
  private Integer areaId;
  private Date lastStateChangeTime;
  private String remark;
  private Integer rssi;
  private Integer vol;
  private String imsi;
  private String imei;

  private Integer haCentorCount;
  private HaArea haArea;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getCentorId() {
    return centorId;
  }

  public void setCentorId(long centorId) {
    this.centorId = centorId;
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

  public String getrTime() {
    return rTime;
  }

  public void setrTime(String rTime) {
    this.rTime = rTime;
  }

  public Date getSetupTime() {
    return setupTime;
  }

  public void setSetupTime(Date setupTime) {
    this.setupTime = setupTime;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getTelNumber() {
    return telNumber;
  }

  public void setTelNumber(String telNumber) {
    this.telNumber = telNumber;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getUseTypeCode() {
    return useTypeCode;
  }

  public void setUseTypeCode(String useTypeCode) {
    this.useTypeCode = useTypeCode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCentorNo() {
    return centorNo;
  }

  public void setCentorNo(String centorNo) {
    this.centorNo = centorNo;
  }

  public Date getLastfreezeTime() {
    return lastfreezeTime;
  }

  public void setLastfreezeTime(Date lastfreezeTime) {
    this.lastfreezeTime = lastfreezeTime;
  }

  public Date getLastfreezeDay() {
    return lastfreezeDay;
  }

  public void setLastfreezeDay(Date lastfreezeDay) {
    this.lastfreezeDay = lastfreezeDay;
  }

  public Date getLastfreezeMon() {
    return lastfreezeMon;
  }

  public void setLastfreezeMon(Date lastfreezeMon) {
    this.lastfreezeMon = lastfreezeMon;
  }

  @Override
  public Date getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public Date getModifyTime() {
    return modifyTime;
  }

  @Override
  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public Integer getMeters() {
    return meters;
  }

  public void setMeters(Integer meters) {
    this.meters = meters;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Date getLastStateChangeTime() {
    return lastStateChangeTime;
  }

  public void setLastStateChangeTime(Date lastStateChangeTime) {
    this.lastStateChangeTime = lastStateChangeTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public HaArea getHaArea() {
    return haArea;
  }

  public void setHaArea(HaArea haArea) {
    this.haArea = haArea;
  }

    public Integer getHaCentorCount() {
        return haCentorCount;
    }

    public void setHaCentorCount(Integer haCentorCount) {
        this.haCentorCount = haCentorCount;
    }
}
