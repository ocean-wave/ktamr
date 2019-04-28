package com.ktamr.domain;


public class HaMonthbtime {

  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long areaid;


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getAreaid() {
    return areaid;
  }

  public void setAreaid(long areaid) {
    this.areaid = areaid;
  }

}
