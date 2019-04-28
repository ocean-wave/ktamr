package com.ktamr.domain;


public class HaRecords {

  private Integer itemId;
  private long meterid;
  private double rate;
  private String lfNumber;
  private java.sql.Timestamp lfTime;
  private String thNumber;
  private java.sql.Timestamp thTime;
  private String delta;
  private String state;
  private long cmdid;

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
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


  public java.sql.Timestamp getLfTime() {
    return lfTime;
  }

  public void setLfTime(java.sql.Timestamp lfTime) {
    this.lfTime = lfTime;
  }


  public String getThNumber() {
    return thNumber;
  }

  public void setThNumber(String thNumber) {
    this.thNumber = thNumber;
  }


  public java.sql.Timestamp getThTime() {
    return thTime;
  }

  public void setThTime(java.sql.Timestamp thTime) {
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


  public long getCmdid() {
    return cmdid;
  }

  public void setCmdid(long cmdid) {
    this.cmdid = cmdid;
  }

}
