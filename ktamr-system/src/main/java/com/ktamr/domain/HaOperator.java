package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaOperator extends BaseEntity {

  private String operatorCode;
  private String operatorName;
  private String operatorPwd;
  private String operatorSex;
  private String operatorMobile;
  private String operatorRemark;
  private String operatorUpper;
  private String operatorLevel;
  private String operatorRgnType;
  private String operatorState;
  private Date operatorCreatTime;
  private String operatorCompany;


  public String getOperatorCode() {
    return operatorCode;
  }

  public void setOperatorCode(String operatorCode) {
    this.operatorCode = operatorCode;
  }

  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(String operatorName) {
    this.operatorName = operatorName;
  }

  public String getOperatorPwd() {
    return operatorPwd;
  }

  public void setOperatorPwd(String operatorPwd) {
    this.operatorPwd = operatorPwd;
  }

  public String getOperatorSex() {
    return operatorSex;
  }

  public void setOperatorSex(String operatorSex) {
    this.operatorSex = operatorSex;
  }

  public String getOperatorMobile() {
    return operatorMobile;
  }

  public void setOperatorMobile(String operatorMobile) {
    this.operatorMobile = operatorMobile;
  }

  public String getOperatorRemark() {
    return operatorRemark;
  }

  public void setOperatorRemark(String operatorRemark) {
    this.operatorRemark = operatorRemark;
  }

  public String getOperatorUpper() {
    return operatorUpper;
  }

  public void setOperatorUpper(String operatorUpper) {
    this.operatorUpper = operatorUpper;
  }

  public String getOperatorLevel() {
    return operatorLevel;
  }

  public void setOperatorLevel(String operatorLevel) {
    this.operatorLevel = operatorLevel;
  }

  public String getOperatorRgnType() {
    return operatorRgnType;
  }

  public void setOperatorRgnType(String operatorRgnType) {
    this.operatorRgnType = operatorRgnType;
  }

  public String getOperatorState() {
    return operatorState;
  }

  public void setOperatorState(String operatorState) {
    this.operatorState = operatorState;
  }

  public Date getOperatorCreatTime() {
    return operatorCreatTime;
  }

  public void setOperatorCreatTime(Date operatorCreatTime) {
    this.operatorCreatTime = operatorCreatTime;
  }

  public String getOperatorCompany() {
    return operatorCompany;
  }

  public void setOperatorCompany(String operatorCompany) {
    this.operatorCompany = operatorCompany;
  }
}
