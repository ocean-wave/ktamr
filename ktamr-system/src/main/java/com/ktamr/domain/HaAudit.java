package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaAudit extends BaseEntity {

  private long auditId;
  private long areaId;
  private Date auditDay;
  private long sumN;
  private long audN;
  private long audCount;
  private String result;
  private String descripTion;
  private Date doDate;

  public long getAuditId() {
    return auditId;
  }

  public void setAuditId(long auditId) {
    this.auditId = auditId;
  }

  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }

  public Date getAuditDay() {
    return auditDay;
  }

  public void setAuditDay(Date auditDay) {
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

  public String getDescripTion() {
    return descripTion;
  }

  public void setDescripTion(String descripTion) {
    this.descripTion = descripTion;
  }

  public Date getDoDate() {
    return doDate;
  }

  public void setDoDate(Date doDate) {
    this.doDate = doDate;
  }
}
