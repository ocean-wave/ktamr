package com.ktamr.domain;


public class HaAudit {

  private long auditId;
  private long areaid;
  private java.sql.Timestamp auditDay;
  private long sumN;
  private long audN;
  private long audCount;
  private String result;
  private String description;
  private java.sql.Timestamp doDate;


  public long getAuditId() {
    return auditId;
  }

  public void setAuditId(long auditId) {
    this.auditId = auditId;
  }


  public long getAreaid() {
    return areaid;
  }

  public void setAreaid(long areaid) {
    this.areaid = areaid;
  }


  public java.sql.Timestamp getAuditDay() {
    return auditDay;
  }

  public void setAuditDay(java.sql.Timestamp auditDay) {
    this.auditDay = auditDay;
  }


  public long getSumN() {
    return sumN;
  }

  public void setSumN(long sumN) {
    this.sumN = sumN;
  }


  public long getAudN() {
    return audN;
  }

  public void setAudN(long audN) {
    this.audN = audN;
  }


  public long getAudCount() {
    return audCount;
  }

  public void setAudCount(long audCount) {
    this.audCount = audCount;
  }


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public java.sql.Timestamp getDoDate() {
    return doDate;
  }

  public void setDoDate(java.sql.Timestamp doDate) {
    this.doDate = doDate;
  }

}
