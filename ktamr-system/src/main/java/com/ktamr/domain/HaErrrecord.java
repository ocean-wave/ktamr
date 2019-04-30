package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaErrrecord extends BaseEntity {

  private Integer itemId;
  private Integer meterNumber;
  private Integer cmdId;
  private Integer N;
  private String state;
  private Date readTime;
  private Integer rawCentorId;
  private Integer rawCollectorId;
  private Integer meterId;
  private Integer recCentorId;
  private Integer recCollectorId;
  private String errType;
  private String description;
  private String procStatus;
  private String procRem;
  private Date procTm;

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(Integer meterNumber) {
    this.meterNumber = meterNumber;
  }

  public Integer getCmdId() {
    return cmdId;
  }

  public void setCmdId(Integer cmdId) {
    this.cmdId = cmdId;
  }

  public Integer getN() {
    return N;
  }

  public void setN(Integer n) {
    N = n;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Date getReadTime() {
    return readTime;
  }

  public void setReadTime(Date readTime) {
    this.readTime = readTime;
  }

  public Integer getRawCentorId() {
    return rawCentorId;
  }

  public void setRawCentorId(Integer rawCentorId) {
    this.rawCentorId = rawCentorId;
  }

  public Integer getRawCollectorId() {
    return rawCollectorId;
  }

  public void setRawCollectorId(Integer rawCollectorId) {
    this.rawCollectorId = rawCollectorId;
  }

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Integer getRecCentorId() {
    return recCentorId;
  }

  public void setRecCentorId(Integer recCentorId) {
    this.recCentorId = recCentorId;
  }

  public Integer getRecCollectorId() {
    return recCollectorId;
  }

  public void setRecCollectorId(Integer recCollectorId) {
    this.recCollectorId = recCollectorId;
  }

  public String getErrType() {
    return errType;
  }

  public void setErrType(String errType) {
    this.errType = errType;
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

  public Date getProcTm() {
    return procTm;
  }

  public void setProcTm(Date procTm) {
    this.procTm = procTm;
  }
}
