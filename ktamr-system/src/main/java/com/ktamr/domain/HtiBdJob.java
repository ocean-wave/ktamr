package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HtiBdJob extends BaseEntity {

  private Integer todojobId;
  private Integer jobdoneId;
  private String sourceId;
  private String paraMeter;
  private Integer meterNumber;
  private Integer handleType;
  private Date createTime;
  private Integer val;
  private Integer valvesState;
  private String meterState;
  private Integer executedResult;
  private Date executedTime;
  private Integer areaId;
  private Integer centorId;
  private Integer collectorId;
  private Integer meterId;
  private Date lastTime;
  private Integer cmdId;


  public Integer getTodojobId() {
    return todojobId;
  }

  public void setTodojobId(Integer todojobId) {
    this.todojobId = todojobId;
  }

  public Integer getJobdoneId() {
    return jobdoneId;
  }

  public void setJobdoneId(Integer jobdoneId) {
    this.jobdoneId = jobdoneId;
  }

  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  public String getParaMeter() {
    return paraMeter;
  }

  public void setParaMeter(String paraMeter) {
    this.paraMeter = paraMeter;
  }

  public Integer getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(Integer meterNumber) {
    this.meterNumber = meterNumber;
  }

  public Integer getHandleType() {
    return handleType;
  }

  public void setHandleType(Integer handleType) {
    this.handleType = handleType;
  }

  @Override
  public Date getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(Integer val) {
    this.val = val;
  }

  public Integer getValvesState() {
    return valvesState;
  }

  public void setValvesState(Integer valvesState) {
    this.valvesState = valvesState;
  }

  public String getMeterState() {
    return meterState;
  }

  public void setMeterState(String meterState) {
    this.meterState = meterState;
  }

  public Integer getExecutedResult() {
    return executedResult;
  }

  public void setExecutedResult(Integer executedResult) {
    this.executedResult = executedResult;
  }

  public Date getExecutedTime() {
    return executedTime;
  }

  public void setExecutedTime(Date executedTime) {
    this.executedTime = executedTime;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
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

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Date getLastTime() {
    return lastTime;
  }

  public void setLastTime(Date lastTime) {
    this.lastTime = lastTime;
  }

  public Integer getCmdId() {
    return cmdId;
  }

  public void setCmdId(Integer cmdId) {
    this.cmdId = cmdId;
  }
}
