package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaAudit extends BaseEntity {

  private Integer auditId;
  private Integer areaId;
  private Date auditDay;
  private Integer sumN;
  private Integer audN;
  private Integer audCount;
  private String result;
  private String descripTion;
  private Date doDate;

  public Integer getAuditId() {
    return auditId;
  }

  public void setAuditId(Integer auditId) {
    this.auditId = auditId;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Date getAuditDay() {
    return auditDay;
  }

  public void setAuditDay(Date auditDay) {
    this.auditDay = auditDay;
  }

  public Integer getSumN() {
    return sumN;
  }

  public void setSumN(Integer sumN) {
    this.sumN = sumN;
  }

  public Integer getAudN() {
    return audN;
  }

  public void setAudN(Integer audN) {
    this.audN = audN;
  }

  public Integer getAudCount() {
    return audCount;
  }

  public void setAudCount(Integer audCount) {
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
