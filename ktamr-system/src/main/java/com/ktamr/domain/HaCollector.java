package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaCollector extends BaseEntity {

  private Integer collectorId;
  private String addr;
  private String ver;
  private Integer oconf;
  private Integer nconf;
  private String state;
  private Integer centorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date lastdoTime;
  private long lastState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date modifyTime;
  private String routers;
  private Integer meters;

  private HaCentor haCentor;
  private Integer haCollectorCount;


  public Integer getCollectorId() {
    return collectorId;
  }

  public void setCollectorId(Integer collectorId) {
    this.collectorId = collectorId;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public Integer getOconf() {
    return oconf;
  }

  public void setOconf(Integer oconf) {
    this.oconf = oconf;
  }

  public Integer getNconf() {
    return nconf;
  }

  public void setNconf(Integer nconf) {
    this.nconf = nconf;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

    public Integer getCentorId() {
        return centorId;
    }

    public void setCentorId(Integer centorId) {
        this.centorId = centorId;
    }

    public Date getLastdoTime() {
    return lastdoTime;
  }

  public void setLastdoTime(Date lastdoTime) {
    this.lastdoTime = lastdoTime;
  }

  public long getLastState() {
    return lastState;
  }

  public void setLastState(long lastState) {
    this.lastState = lastState;
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

  public String getRouters() {
    return routers;
  }

  public void setRouters(String routers) {
    this.routers = routers;
  }

  public Integer getMeters() {
    return meters;
  }

  public void setMeters(Integer meters) {
    this.meters = meters;
  }

  public HaCentor getHaCentor() {
    return haCentor;
  }

  public void setHaCentor(HaCentor haCentor) {
    this.haCentor = haCentor;
  }

    public Integer getHaCollectorCount() {
        return haCollectorCount;
    }

    public void setHaCollectorCount(Integer haCollectorCount) {
        this.haCollectorCount = haCollectorCount;
    }
}
