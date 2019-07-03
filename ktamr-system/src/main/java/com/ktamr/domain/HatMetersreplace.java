package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HatMetersreplace extends BaseEntity {

  private Integer id;
  private double orimeterNumber;
  private Integer orimeterId;
  private Integer orimeterRead;
  private double newmeterNumber;
  private Integer newmeterRead;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date replaceTime;
  private String replaceMan;
  private String reMark;
  private String check;
  private Integer hasDayFreeze;
  private Integer hasMonFreeze;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date importTime;
  private String userCode;
  private HavMeterinfo havMeterinfo;
  private String fileName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public double getOrimeterNumber() {
    return orimeterNumber;
  }

  public void setOrimeterNumber(double orimeterNumber) {
    this.orimeterNumber = orimeterNumber;
  }

  public Integer getOrimeterId() {
    return orimeterId;
  }

  public void setOrimeterId(Integer orimeterId) {
    this.orimeterId = orimeterId;
  }

  public Integer getOrimeterRead() {
    return orimeterRead;
  }

  public void setOrimeterRead(Integer orimeterRead) {
    this.orimeterRead = orimeterRead;
  }

  public double getNewmeterNumber() {
    return newmeterNumber;
  }

  public void setNewmeterNumber(double newmeterNumber) {
    this.newmeterNumber = newmeterNumber;
  }

  public Integer getNewmeterRead() {
    return newmeterRead;
  }

  public void setNewmeterRead(Integer newmeterRead) {
    this.newmeterRead = newmeterRead;
  }

  public Date getReplaceTime() {
    return replaceTime;
  }

  public void setReplaceTime(Date replaceTime) {
    this.replaceTime = replaceTime;
  }

  public String getReplaceMan() {
    return replaceMan;
  }

  public void setReplaceMan(String replaceMan) {
    this.replaceMan = replaceMan;
  }

  public String getReMark() {
    return reMark;
  }

  public void setReMark(String reMark) {
    this.reMark = reMark;
  }

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  public Integer getHasDayFreeze() {
    return hasDayFreeze;
  }

  public void setHasDayFreeze(Integer hasDayFreeze) {
    this.hasDayFreeze = hasDayFreeze;
  }

  public Integer getHasMonFreeze() {
    return hasMonFreeze;
  }

  public void setHasMonFreeze(Integer hasMonFreeze) {
    this.hasMonFreeze = hasMonFreeze;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

    public HavMeterinfo getHavMeterinfo() {
        return havMeterinfo;
    }

    public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
        this.havMeterinfo = havMeterinfo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
