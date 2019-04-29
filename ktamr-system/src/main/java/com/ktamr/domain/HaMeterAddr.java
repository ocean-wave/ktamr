package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaMeterAddr extends BaseEntity {

  private Integer id;
  private Integer cmdId;
  private long centorid;
  private long centoridD;
  private long ccrid;
  private long meterid;
  private long ccrnoD;
  private long ccrnoR;
  private String meterNumber;
  private String state;

  private HaCmd haCmd;

  public String getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(String meterNumber) {
    this.meterNumber = meterNumber;
  }

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

  public HaCmd getHaCmd() {
    return haCmd;
  }

  public void setHaCmd(HaCmd haCmd) {
    this.haCmd = haCmd;
  }

  public long getCentorid() {
    return centorid;
  }

  public void setCentorid(long centorid) {
    this.centorid = centorid;
  }


  public long getCentoridD() {
    return centoridD;
  }

  public void setCentoridD(long centoridD) {
    this.centoridD = centoridD;
  }


  public long getCcrid() {
    return ccrid;
  }

  public void setCcrid(long ccrid) {
    this.ccrid = ccrid;
  }


  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
    this.meterid = meterid;
  }


  public long getCcrnoD() {
    return ccrnoD;
  }

  public void setCcrnoD(long ccrnoD) {
    this.ccrnoD = ccrnoD;
  }


  public long getCcrnoR() {
    return ccrnoR;
  }

  public void setCcrnoR(long ccrnoR) {
    this.ccrnoR = ccrnoR;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
