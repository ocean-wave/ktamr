package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HatSum extends BaseEntity {

  private Integer meterId;
  private Integer meterNumber;
  private Date dt;
  private Date dl;
  private Integer N;
  private double S;
  private double s1;
  private double s2;


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

  public Date getDt() {
    return dt;
  }

  public void setDt(Date dt) {
    this.dt = dt;
  }

  public Date getDl() {
    return dl;
  }

  public void setDl(Date dl) {
    this.dl = dl;
  }

  public Integer getN() {
    return N;
  }

  public void setN(Integer n) {
    N = n;
  }

  public double getS() {
    return S;
  }

  public void setS(double s) {
    S = s;
  }

  public double getS1() {
    return s1;
  }

  public void setS1(double s1) {
    this.s1 = s1;
  }

  public double getS2() {
    return s2;
  }

  public void setS2(double s2) {
    this.s2 = s2;
  }
}
