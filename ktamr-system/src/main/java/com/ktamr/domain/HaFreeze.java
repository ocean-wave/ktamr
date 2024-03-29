package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class HaFreeze extends BaseEntity {

  private Integer itemId;
  private Integer meterId;
  private Date lfTime;
  private String lfNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date thTime;
  private String tfNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date rTime;
  private String delta;
  private Integer priceStandId;
  private double price;
  private String pay;
  private String billId;

  //开启存别名
  private Integer areaId;//***重要
  private String opType;//点击哪个功能的功能名称

  //开始存对象
  private HaMeter haMeter;
  private HaPricestandard haPricestandard;
  private HaMetertype haMetertype;
  private List<String> billIdsList;//定义缴费单号的id List集合方便查询多个id时


  public List<String> getBillIdsList() {
    return billIdsList;
  }

  public void setBillIdsList(List<String> billIdsList) {
    this.billIdsList = billIdsList;
  }

  public HaMeter getHaMeter() {
    return haMeter;
  }

  public void setHaMeter(HaMeter haMeter) {
    this.haMeter = haMeter;
  }

  public HaPricestandard getHaPricestandard() {
    return haPricestandard;
  }

  public void setHaPricestandard(HaPricestandard haPricestandard) {
    this.haPricestandard = haPricestandard;
  }

  public HaMetertype getHaMetertype() {
    return haMetertype;
  }

  public void setHaMetertype(HaMetertype haMetertype) {
    this.haMetertype = haMetertype;
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public Date getLfTime() {
    return lfTime;
  }

  public void setLfTime(Date lfTime) {
    this.lfTime = lfTime;
  }

  public String getLfNumber() {
    return lfNumber;
  }

  public void setLfNumber(String lfNumber) {
    this.lfNumber = lfNumber;
  }

  public Date getThTime() {
    return thTime;
  }

  public void setThTime(Date thTime) {
    this.thTime = thTime;
  }

  public String getTfNumber() {
    return tfNumber;
  }

  public void setTfNumber(String tfNumber) {
    this.tfNumber = tfNumber;
  }

  public Date getrTime() {
    return rTime;
  }

  public void setrTime(Date rTime) {
    this.rTime = rTime;
  }

  public String getDelta() {
    return delta;
  }

  public void setDelta(String delta) {
    this.delta = delta;
  }

  public Integer getPriceStandId() {
    return priceStandId;
  }

  public void setPriceStandId(Integer priceStandId) {
    this.priceStandId = priceStandId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getPay() {
    return pay;
  }

  public void setPay(String pay) {
    this.pay = pay;
  }

  public String getBillId() {
    return billId;
  }

  public void setBillId(String billId) {
    this.billId = billId;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public String getOpType() {
    return opType;
  }

  public void setOpType(String opType) {
    this.opType = opType;
  }
}
