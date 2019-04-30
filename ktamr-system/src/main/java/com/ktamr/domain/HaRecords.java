package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaRecords extends BaseEntity {

  private Integer itemId;
  private Integer meterid;
  private double rate;
  private String lfNumber;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date lfTime;
  private String thNumber;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date thTime;
  private String delta;
  private String state;
  private Integer cmdid;
  private HavMeterinfo havMeterinfo;

  public HavMeterinfo getHavMeterinfo() {
    return havMeterinfo;
  }

  public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
    this.havMeterinfo = havMeterinfo;
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getMeterid() {
    return meterid;
  }

  public void setMeterid(Integer meterid) {
    this.meterid = meterid;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String getLfNumber() {
    return lfNumber;
  }

  public void setLfNumber(String lfNumber) {
    this.lfNumber = lfNumber;
  }

  public Date getLfTime() {
    return lfTime;
  }

  public void setLfTime(Date lfTime) {
    this.lfTime = lfTime;
  }

  public String getThNumber() {
    return thNumber;
  }

  public void setThNumber(String thNumber) {
    this.thNumber = thNumber;
  }

  public Date getThTime() {
    return thTime;
  }

  public void setThTime(Date thTime) {
    this.thTime = thTime;
  }

  public String getDelta() {
    return delta;
  }

  public void setDelta(String delta) {
    this.delta = delta;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getCmdid() {
    return cmdid;
  }

  public void setCmdid(Integer cmdid) {
    this.cmdid = cmdid;
  }
}
