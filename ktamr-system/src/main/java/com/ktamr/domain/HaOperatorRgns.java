package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaOperatorRgns extends BaseEntity {

  private String operatorCode;
  private String rgnCode;


  public String getOperatorCode() {
    return operatorCode;
  }

  public void setOperatorCode(String operatorCode) {
    this.operatorCode = operatorCode;
  }

  public String getRgnCode() {
    return rgnCode;
  }

  public void setRgnCode(String rgnCode) {
    this.rgnCode = rgnCode;
  }
}
