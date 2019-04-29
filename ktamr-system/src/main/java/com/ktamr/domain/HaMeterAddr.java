package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaMeterAddr extends BaseEntity {

  private Integer id;
  private Integer cmdId;
  private Integer centorId;
  private Integer centorIdD;
  private Integer ccrId;
  private Integer meterId;
  private Integer ccrnoD;
  private Integer ccrnoR;
  private String meterNumber;
  private String state;

  private HaCmd haCmd;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCmdId() {
    return cmdId;
  }

  public void setCmdId(Integer cmdId) {
    this.cmdId = cmdId;
  }

  public Integer getCentorId() {
    return centorId;
  }

  public void setCentorId(Integer centorId) {
    this.centorId = centorId;
  }

  public Integer getCentorIdD() {
    return centorIdD;
  }

  public void setCentorIdD(Integer centorIdD) {
    this.centorIdD = centorIdD;
  }

  public Integer getCcrId() {
    return ccrId;
  }

  public void setCcrId(Integer ccrId) {
    this.ccrId = ccrId;
  }

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Integer getCcrnoD() {
    return ccrnoD;
  }

  public void setCcrnoD(Integer ccrnoD) {
    this.ccrnoD = ccrnoD;
  }

  public Integer getCcrnoR() {
    return ccrnoR;
  }

  public void setCcrnoR(Integer ccrnoR) {
    this.ccrnoR = ccrnoR;
  }

  public String getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(String meterNumber) {
    this.meterNumber = meterNumber;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public HaCmd getHaCmd() {
    return haCmd;
  }

  public void setHaCmd(HaCmd haCmd) {
    this.haCmd = haCmd;
  }
}
