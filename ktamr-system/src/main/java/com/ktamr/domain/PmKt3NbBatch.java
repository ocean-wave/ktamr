package com.ktamr.domain;


public class PmKt3NbBatch {

  private long id;
  private String deviceType;
  private String company;
  private java.sql.Timestamp workDay;
  private String precode;
  private long planAmount;
  private long realAmount;
  private long okAmount;
  private long dupAmount;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


  public java.sql.Timestamp getWorkDay() {
    return workDay;
  }

  public void setWorkDay(java.sql.Timestamp workDay) {
    this.workDay = workDay;
  }


  public String getPrecode() {
    return precode;
  }

  public void setPrecode(String precode) {
    this.precode = precode;
  }


  public long getPlanAmount() {
    return planAmount;
  }

  public void setPlanAmount(long planAmount) {
    this.planAmount = planAmount;
  }


  public long getRealAmount() {
    return realAmount;
  }

  public void setRealAmount(long realAmount) {
    this.realAmount = realAmount;
  }


  public long getOkAmount() {
    return okAmount;
  }

  public void setOkAmount(long okAmount) {
    this.okAmount = okAmount;
  }


  public long getDupAmount() {
    return dupAmount;
  }

  public void setDupAmount(long dupAmount) {
    this.dupAmount = dupAmount;
  }

}
