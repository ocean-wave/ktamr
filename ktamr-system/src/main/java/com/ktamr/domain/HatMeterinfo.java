package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HatMeterinfo extends BaseEntity {

  private Integer meterId;
  private Integer meterNumber;
  private String addr;
  private String userName;
  private String userAddr;

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

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserAddr() {
    return userAddr;
  }

  public void setUserAddr(String userAddr) {
    this.userAddr = userAddr;
  }
}
