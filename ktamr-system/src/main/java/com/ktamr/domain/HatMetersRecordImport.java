package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HatMetersRecordImport extends BaseEntity {

  private Integer id;
  private String userCode;
  private String userName;
  private double meterNumber;
  private String state;
  private double readNumber;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date readTime;
  private Integer meterId;
  private Integer hasdayFreeze;
  private Integer hasmonFreeze;
  private String checkResult;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date importTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public double getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(double meterNumber) {
    this.meterNumber = meterNumber;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public double getReadNumber() {
    return readNumber;
  }

  public void setReadNumber(double readNumber) {
    this.readNumber = readNumber;
  }

  public Date getReadTime() {
    return readTime;
  }

  public void setReadTime(Date readTime) {
    this.readTime = readTime;
  }

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Integer getHasdayFreeze() {
    return hasdayFreeze;
  }

  public void setHasdayFreeze(Integer hasdayFreeze) {
    this.hasdayFreeze = hasdayFreeze;
  }

  public Integer getHasmonFreeze() {
    return hasmonFreeze;
  }

  public void setHasmonFreeze(Integer hasmonFreeze) {
    this.hasmonFreeze = hasmonFreeze;
  }

  public String getCheckResult() {
    return checkResult;
  }

  public void setCheckResult(String checkResult) {
    this.checkResult = checkResult;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }
}
