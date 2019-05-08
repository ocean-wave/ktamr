package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HatMetersrecordimport extends BaseEntity {

  private Integer id;
  private String usercode;
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
  private String check;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date importTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
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

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }
}
