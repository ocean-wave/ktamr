package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HaFreeze {

  private Integer itemId;
  private Integer meterId;
  private Date lfTime;
  private String lfNumber;
  @JsonFormat( pattern = "yyyy-MM-dd")
  private Date thTime;
  private String tfNumber;
  private Date rtime;
  private String delta;
  private Integer pricestandId;
  private double price;
  private double pay;
  private String billId;

  //开启存别名
  private Integer areaId;//***重要
  private String opType;//点击哪个功能的功能名称

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

  public Date getRtime() {
    return rtime;
  }

  public void setRtime(Date rtime) {
    this.rtime = rtime;
  }

  public String getDelta() {
    return delta;
  }

  public void setDelta(String delta) {
    this.delta = delta;
  }

  public Integer getPricestandId() {
    return pricestandId;
  }

  public void setPricestandId(Integer pricestandId) {
    this.pricestandId = pricestandId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPay() {
    return pay;
  }

  public void setPay(double pay) {
    this.pay = pay;
  }

  public String getBillId() {
    return billId;
  }

  public void setBillId(String billId) {
    this.billId = billId;
  }
}
