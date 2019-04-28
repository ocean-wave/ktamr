package com.ktamr.domain;


public class HaDayfreeze {

  private long meterid;
  private long meternumber;
  private long centorid;
  private long collectorid;
  private java.sql.Timestamp fday;
  private java.sql.Timestamp lday;
  private java.sql.Timestamp readtime;
  private String state;
  private long tRead;
  private long lRead;
  private long amount;


  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
    this.meterid = meterid;
  }


  public long getMeternumber() {
    return meternumber;
  }

  public void setMeternumber(long meternumber) {
    this.meternumber = meternumber;
  }


  public long getCentorid() {
    return centorid;
  }

  public void setCentorid(long centorid) {
    this.centorid = centorid;
  }


  public long getCollectorid() {
    return collectorid;
  }

  public void setCollectorid(long collectorid) {
    this.collectorid = collectorid;
  }


  public java.sql.Timestamp getFday() {
    return fday;
  }

  public void setFday(java.sql.Timestamp fday) {
    this.fday = fday;
  }


  public java.sql.Timestamp getLday() {
    return lday;
  }

  public void setLday(java.sql.Timestamp lday) {
    this.lday = lday;
  }


  public java.sql.Timestamp getReadtime() {
    return readtime;
  }

  public void setReadtime(java.sql.Timestamp readtime) {
    this.readtime = readtime;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public long getTRead() {
    return tRead;
  }

  public void setTRead(long tRead) {
    this.tRead = tRead;
  }


  public long getLRead() {
    return lRead;
  }

  public void setLRead(long lRead) {
    this.lRead = lRead;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

}
