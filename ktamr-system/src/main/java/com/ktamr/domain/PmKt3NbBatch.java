package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class PmKt3NbBatch extends BaseEntity {

  private Integer id;
  private String deviceType;
  private String company;
  private Date workDay;
  private String preCode;
  private Integer planAmount;
  private Integer realAmount;
  private Integer okAmount;
  private Integer dupAmount;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Date getWorkDay() {
    return workDay;
  }

  public void setWorkDay(Date workDay) {
    this.workDay = workDay;
  }

  public String getPreCode() {
    return preCode;
  }

  public void setPreCode(String preCode) {
    this.preCode = preCode;
  }

  public Integer getPlanAmount() {
    return planAmount;
  }

  public void setPlanAmount(Integer planAmount) {
    this.planAmount = planAmount;
  }

  public Integer getRealAmount() {
    return realAmount;
  }

  public void setRealAmount(Integer realAmount) {
    this.realAmount = realAmount;
  }

  public Integer getOkAmount() {
    return okAmount;
  }

  public void setOkAmount(Integer okAmount) {
    this.okAmount = okAmount;
  }

  public Integer getDupAmount() {
    return dupAmount;
  }

  public void setDupAmount(Integer dupAmount) {
    this.dupAmount = dupAmount;
  }
}
