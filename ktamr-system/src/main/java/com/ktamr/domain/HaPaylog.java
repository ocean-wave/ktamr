package com.ktamr.domain;


public class HaPaylog {

  private String billid;
  private long custId;
  private String custName;
  private java.sql.Timestamp plantime;
  private java.sql.Timestamp paytime;
  private double sum;
  private String bank;
  private String account;
  private String state;
  private java.sql.Timestamp mbtime;
  private double lastarrear;
  private double receipt;

  //存对象
  private  HaFreeze haFreeze;
  private  HavMeterinfo havMeterinfo;
  private  HaPricestandard haPricestandard;

  //第二波
  private  HaMeter haMeter;
  private  HaMetertype haMetertype;

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

  public String getBillid() {
    return billid;
  }

  public void setBillid(String billid) {
    this.billid = billid;
  }


  public long getCustId() {
    return custId;
  }

  public void setCustId(long custId) {
    this.custId = custId;
  }


  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }


  public java.sql.Timestamp getPlantime() {
    return plantime;
  }

  public void setPlantime(java.sql.Timestamp plantime) {
    this.plantime = plantime;
  }


  public java.sql.Timestamp getPaytime() {
    return paytime;
  }

  public void setPaytime(java.sql.Timestamp paytime) {
    this.paytime = paytime;
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


  public java.sql.Timestamp getMbtime() {
    return mbtime;
  }

  public void setMbtime(java.sql.Timestamp mbtime) {
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

}
