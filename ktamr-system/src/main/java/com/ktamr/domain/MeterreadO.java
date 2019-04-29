package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class MeterreadO extends BaseEntity {

  private String mrCode;
  private String mryCode;
  private String mrboxNo;
  private Date mrrDate;
  private double mrsCode;
  private double mreCode;
  private String mrFace;
  private Date mrDate;
  private String mrsFlag;
  private Date mrsDate;
  private String mrMonth;


  public String getMrCode() {
    return mrCode;
  }

  public void setMrCode(String mrCode) {
    this.mrCode = mrCode;
  }

  public String getMryCode() {
    return mryCode;
  }

  public void setMryCode(String mryCode) {
    this.mryCode = mryCode;
  }

  public String getMrboxNo() {
    return mrboxNo;
  }

  public void setMrboxNo(String mrboxNo) {
    this.mrboxNo = mrboxNo;
  }

  public Date getMrrDate() {
    return mrrDate;
  }

  public void setMrrDate(Date mrrDate) {
    this.mrrDate = mrrDate;
  }

  public double getMrsCode() {
    return mrsCode;
  }

  public void setMrsCode(double mrsCode) {
    this.mrsCode = mrsCode;
  }

  public double getMreCode() {
    return mreCode;
  }

  public void setMreCode(double mreCode) {
    this.mreCode = mreCode;
  }

  public String getMrFace() {
    return mrFace;
  }

  public void setMrFace(String mrFace) {
    this.mrFace = mrFace;
  }

  public Date getMrDate() {
    return mrDate;
  }

  public void setMrDate(Date mrDate) {
    this.mrDate = mrDate;
  }

  public String getMrsFlag() {
    return mrsFlag;
  }

  public void setMrsFlag(String mrsFlag) {
    this.mrsFlag = mrsFlag;
  }

  public Date getMrsDate() {
    return mrsDate;
  }

  public void setMrsDate(Date mrsDate) {
    this.mrsDate = mrsDate;
  }

  public String getMrMonth() {
    return mrMonth;
  }

  public void setMrMonth(String mrMonth) {
    this.mrMonth = mrMonth;
  }
}
