package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HtiJrJob extends BaseEntity {

  private Integer id;
  private String userId;
  private String userName;
  private String addRess;
  private String tel;
  private String waterTagid;
  private String lineNo;
  private String areaId;
  private String intabManid;
  private double amtabNum;
  private double nmtabNum;
  private double waterMete;
  private double waterPrice;
  private Date cbtDate;
  private String meterState;
  private Integer custId;
  private Date importTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddRess() {
    return addRess;
  }

  public void setAddRess(String addRess) {
    this.addRess = addRess;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getWaterTagid() {
    return waterTagid;
  }

  public void setWaterTagid(String waterTagid) {
    this.waterTagid = waterTagid;
  }

  public String getLineNo() {
    return lineNo;
  }

  public void setLineNo(String lineNo) {
    this.lineNo = lineNo;
  }

  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public String getIntabManid() {
    return intabManid;
  }

  public void setIntabManid(String intabManid) {
    this.intabManid = intabManid;
  }

  public double getAmtabNum() {
    return amtabNum;
  }

  public void setAmtabNum(double amtabNum) {
    this.amtabNum = amtabNum;
  }

  public double getNmtabNum() {
    return nmtabNum;
  }

  public void setNmtabNum(double nmtabNum) {
    this.nmtabNum = nmtabNum;
  }

  public double getWaterMete() {
    return waterMete;
  }

  public void setWaterMete(double waterMete) {
    this.waterMete = waterMete;
  }

  public double getWaterPrice() {
    return waterPrice;
  }

  public void setWaterPrice(double waterPrice) {
    this.waterPrice = waterPrice;
  }

  public Date getCbtDate() {
    return cbtDate;
  }

  public void setCbtDate(Date cbtDate) {
    this.cbtDate = cbtDate;
  }

  public String getMeterState() {
    return meterState;
  }

  public void setMeterState(String meterState) {
    this.meterState = meterState;
  }

  public Integer getCustId() {
    return custId;
  }

  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  public Date getImportTime() {
    return importTime;
  }

  public void setImportTime(Date importTime) {
    this.importTime = importTime;
  }
}
