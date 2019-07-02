package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaErrrecord extends BaseEntity {

  private Integer itemId;
  private Integer meterNumber;
  private Integer cmdId;
  private Integer n;
  private String state;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date readTime;
  private Integer rawCentorId;
  private String rawCollectorId;
  private Integer meterId;
  private Integer recCentorId;
  private Integer recCollectorId;
  private String errType;
  private String description;
  private String procStatus;
  private String procRem;
  private Date procTm;

  private String yjzqbh;
  private String ddjzqbh;
  private String ddjzqId;

  private HavMeterinfo havMeterinfo;
  private HaCollector haCollector;

  public String getYjzqbh() {
    return yjzqbh;
  }

  public void setYjzqbh(String yjzqbh) {
    this.yjzqbh = yjzqbh;
  }

  public String getDdjzqbh() {
    return ddjzqbh;
  }

  public void setDdjzqbh(String ddjzqbh) {
    this.ddjzqbh = ddjzqbh;
  }

  public String getDdjzqId() {
    return ddjzqId;
  }

  public void setDdjzqId(String ddjzqId) {
    this.ddjzqId = ddjzqId;
  }

  public HaCollector getHaCollector() {
    return haCollector;
  }

  public void setHaCollector(HaCollector haCollector) {
    this.haCollector = haCollector;
  }

  public Integer getN() {
    return n;
  }

  public void setN(Integer n) {
    this.n = n;
  }

  public HavMeterinfo getHavMeterinfo() {
    return havMeterinfo;
  }

  public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
    this.havMeterinfo = havMeterinfo;
  }

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

  public String getRawCollectorId() {
    return rawCollectorId;
  }

  public void setRawCollectorId(String rawCollectorId) {
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
