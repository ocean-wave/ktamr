package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class HaPaylog extends BaseEntity {

  private String billId;
  private Integer custId;
  private String custName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date planTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date payTime;
  private double sum;
  private String bank;
  private String account;
  private String state;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date mbtime;
  private double lastarrear;
  private double receipt;

  //存对象
  private  HaFreeze haFreeze;
  private  HavMeterinfo havMeterinfo;
  private  HaPricestandard haPricestandard;

  //第二波
  private  HaMeter haMeter;
  private  HaMetertype haMetertype;
  private  HaCustom haCustom;
  //方便用areaid中in的范围查询
  private  List<Integer> idsList;
  //方便查询根据日期查询
  private Date KaiShiTime;//别名开始时间
  private Date JieShuTime;//别名结束时间0
  private Integer areaId;//别名小区id
  private List<String> billIdsList;//定义缴费单号的id List集合方便查询多个id时


  public List<String> getBillIdsList() {
    return billIdsList;
  }

  public void setBillIdsList(List<String> billIdsList) {
    this.billIdsList = billIdsList;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Date getKaiShiTime() {
    return KaiShiTime;
  }

  public void setKaiShiTime(Date kaiShiTime) {
    KaiShiTime = kaiShiTime;
  }

  public Date getJieShuTime() {
    return JieShuTime;
  }

  public void setJieShuTime(Date jieShuTime) {
    JieShuTime = jieShuTime;
  }

  public HaCustom getHaCustom() {
    return haCustom;
  }

  public void setHaCustom(HaCustom haCustom) {
    this.haCustom = haCustom;
  }

  public List<Integer> getIdsList() {
    return idsList;
  }

  public void setIdsList(List<Integer> idsList) {
    this.idsList = idsList;
  }

  public String getBillId() {
    return billId;
  }

  public void setBillId(String billId) {
    this.billId = billId;
  }

  public Integer getCustId() {
    return custId;
  }

  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public Date getPlanTime() {
    return planTime;
  }

  public void setPlanTime(Date planTime) {
    this.planTime = planTime;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public double getSum() {
    return sum;
  }

  public void setSum(double sum) {
    this.sum = sum;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Date getMbtime() {
    return mbtime;
  }

  public void setMbtime(Date mbtime) {
    this.mbtime = mbtime;
  }

  public double getLastarrear() {
    return lastarrear;
  }

  public void setLastarrear(double lastarrear) {
    this.lastarrear = lastarrear;
  }

  public double getReceipt() {
    return receipt;
  }

  public void setReceipt(double receipt) {
    this.receipt = receipt;
  }

  public HaFreeze getHaFreeze() {
    return haFreeze;
  }

  public void setHaFreeze(HaFreeze haFreeze) {
    this.haFreeze = haFreeze;
  }

  public HavMeterinfo getHavMeterinfo() {
    return havMeterinfo;
  }

  public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
    this.havMeterinfo = havMeterinfo;
  }

  public HaPricestandard getHaPricestandard() {
    return haPricestandard;
  }

  public void setHaPricestandard(HaPricestandard haPricestandard) {
    this.haPricestandard = haPricestandard;
  }

  public HaMeter getHaMeter() {
    return haMeter;
  }

  public void setHaMeter(HaMeter haMeter) {
    this.haMeter = haMeter;
  }

  public HaMetertype getHaMetertype() {
    return haMetertype;
  }

  public void setHaMetertype(HaMetertype haMetertype) {
    this.haMetertype = haMetertype;
  }
}
