package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaMonfreeze extends BaseEntity {

  private Integer meterId;
  private Integer meterNumber;
  private Integer centorId;
  private Integer collectorId;
  private Date fDay;
  private Date lDay;
  private Date readTime;
  private String state;
  private Integer tRead;
  private Integer lRead;
  private Integer aMount;


  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Integer getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(Integer meterNumber) {
    this.meterNumber = meterNumber;
  }

  public Integer getCentorId() {
    return centorId;
  }

  public void setCentorId(Integer centorId) {
    this.centorId = centorId;
  }

  public Integer getCollectorId() {
    return collectorId;
  }

  public void setCollectorId(Integer collectorId) {
    this.collectorId = collectorId;
  }

  public Date getfDay() {
    return fDay;
  }

  public void setfDay(Date fDay) {
    this.fDay = fDay;
  }

  public Date getlDay() {
    return lDay;
  }

  public void setlDay(Date lDay) {
    this.lDay = lDay;
  }

  public Date getReadTime() {
    return readTime;
  }

  public void setReadTime(Date readTime) {
    this.readTime = readTime;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer gettRead() {
    return tRead;
  }

  public void settRead(Integer tRead) {
    this.tRead = tRead;
  }

  public Integer getlRead() {
    return lRead;
  }

  public void setlRead(Integer lRead) {
    this.lRead = lRead;
  }

  public Integer getaMount() {
    return aMount;
  }

  public void setaMount(Integer aMount) {
    this.aMount = aMount;
  }
}
