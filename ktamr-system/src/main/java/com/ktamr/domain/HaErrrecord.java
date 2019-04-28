package com.ktamr.domain;


public class HaErrrecord {

  private long itemid;
  private long meternumber;
  private long cmdid;
  private long N;
  private String state;
  private java.sql.Timestamp readtime;
  private long rawCentorid;
  private long rawCollectorid;
  private long meterid;
  private long recCentorid;
  private long recCollectorid;
  private String errtype;
  private String description;
  private String procStatus;
  private String procRem;
  private java.sql.Timestamp procTm;


  public long getItemid() {
    return itemid;
  }

  public void setItemid(long itemid) {
    this.itemid = itemid;
  }


  public long getMeternumber() {
    return meternumber;
  }

  public void setMeternumber(long meternumber) {
    this.meternumber = meternumber;
  }


  public long getCmdid() {
    return cmdid;
  }

  public void setCmdid(long cmdid) {
    this.cmdid = cmdid;
  }


  public long getN() {
    return N;
  }

  public void setN(long N) {
    this.N = N;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public java.sql.Timestamp getReadtime() {
    return readtime;
  }

  public void setReadtime(java.sql.Timestamp readtime) {
    this.readtime = readtime;
  }


  public long getRawCentorid() {
    return rawCentorid;
  }

  public void setRawCentorid(long rawCentorid) {
    this.rawCentorid = rawCentorid;
  }


  public long getRawCollectorid() {
    return rawCollectorid;
  }

  public void setRawCollectorid(long rawCollectorid) {
    this.rawCollectorid = rawCollectorid;
  }


  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
    this.meterid = meterid;
  }


  public long getRecCentorid() {
    return recCentorid;
  }

  public void setRecCentorid(long recCentorid) {
    this.recCentorid = recCentorid;
  }


  public long getRecCollectorid() {
    return recCollectorid;
  }

  public void setRecCollectorid(long recCollectorid) {
    this.recCollectorid = recCollectorid;
  }


  public String getErrtype() {
    return errtype;
  }

  public void setErrtype(String errtype) {
    this.errtype = errtype;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getProcStatus() {
    return procStatus;
  }

  public void setProcStatus(String procStatus) {
    this.procStatus = procStatus;
  }


  public String getProcRem() {
    return procRem;
  }

  public void setProcRem(String procRem) {
    this.procRem = procRem;
  }


  public java.sql.Timestamp getProcTm() {
    return procTm;
  }

  public void setProcTm(java.sql.Timestamp procTm) {
    this.procTm = procTm;
  }

}
