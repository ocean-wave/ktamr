package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

public class HaPaylog extends BaseEntity {

  private String billId;
  private Integer custId;
  private String custName;
  private Date planTime;
  private Date payTime;
  private double sum;
  private String bank;
  private String account;
  private String state;
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
  //方便用areaid中in的范围查询
  private  List<Integer> idsList;

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
