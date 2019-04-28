package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaCollector extends BaseEntity {

  private Integer collectorId;
  private String addr;
  private String ver;
  private Integer oconf;
  private Integer nconf;
  private String state;
  private java.sql.Timestamp lastdoTime;
  private long lastState;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp modifytime;
  private String routers;
  private long meters;

  private HaCentor haCentor;

  public HaCentor getHaCentor() {
    return haCentor;
  }

  public void setHaCentor(HaCentor haCentor) {
    this.haCentor = haCentor;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public java.sql.Timestamp getLastdoTime() {
    return lastdoTime;
  }

  public void setLastdoTime(java.sql.Timestamp lastdoTime) {
    this.lastdoTime = lastdoTime;
  }


  public long getLastState() {
    return lastState;
  }

  public void setLastState(long lastState) {
    this.lastState = lastState;
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


  public String getRouters() {
    return routers;
  }

  public void setRouters(String routers) {
    this.routers = routers;
  }

  public long getMeters() {
    return meters;
  }

  public void setMeters(long meters) {
    this.meters = meters;
  }

}
