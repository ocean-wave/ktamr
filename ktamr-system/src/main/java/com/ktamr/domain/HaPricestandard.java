package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaPricestandard extends BaseEntity {

  private long pricestandId;
  private long metertypeid;
  private String name;
  private Date starttime;
  private Date endtime;
  private double jPrice;
  private double fPrice;
  private double pPrice;
  private double gPrice;
  private double sMin;
  private double sMax;
  private long sDays;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp modifytime;
  private long usagepoint1;
  private long usagepoint2;
  private String chargingmethods;
  private double price1;
  private double price2;
  private double price3;
  private double a1;

  public Date getStarttime() {
    return starttime;
  }

  public void setStarttime(Date starttime) {
    this.starttime = starttime;
  }

  public Date getEndtime() {
    return endtime;
  }

  public void setEndtime(Date endtime) {
    this.endtime = endtime;
  }

  public long getPricestandId() {
    return pricestandId;
  }

  public void setPricestandId(long pricestandId) {
    this.pricestandId = pricestandId;
  }


  public long getMetertypeid() {
    return metertypeid;
  }

  public void setMetertypeid(long metertypeid) {
    this.metertypeid = metertypeid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getJPrice() {
    return jPrice;
  }

  public void setJPrice(double jPrice) {
    this.jPrice = jPrice;
  }


  public double getFPrice() {
    return fPrice;
  }

  public void setFPrice(double fPrice) {
    this.fPrice = fPrice;
  }


  public double getPPrice() {
    return pPrice;
  }

  public void setPPrice(double pPrice) {
    this.pPrice = pPrice;
  }


  public double getGPrice() {
    return gPrice;
  }

  public void setGPrice(double gPrice) {
    this.gPrice = gPrice;
  }


  public double getSMin() {
    return sMin;
  }

  public void setSMin(double sMin) {
    this.sMin = sMin;
  }


  public double getSMax() {
    return sMax;
  }

  public void setSMax(double sMax) {
    this.sMax = sMax;
  }


  public long getSDays() {
    return sDays;
  }

  public void setSDays(long sDays) {
    this.sDays = sDays;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public java.sql.Timestamp getModifytime() {
    return modifytime;
  }

  public void setModifytime(java.sql.Timestamp modifytime) {
    this.modifytime = modifytime;
  }


  public long getUsagepoint1() {
    return usagepoint1;
  }

  public void setUsagepoint1(long usagepoint1) {
    this.usagepoint1 = usagepoint1;
  }


  public long getUsagepoint2() {
    return usagepoint2;
  }

  public void setUsagepoint2(long usagepoint2) {
    this.usagepoint2 = usagepoint2;
  }


  public String getChargingmethods() {
    return chargingmethods;
  }

  public void setChargingmethods(String chargingmethods) {
    this.chargingmethods = chargingmethods;
  }


  public double getPrice1() {
    return price1;
  }

  public void setPrice1(double price1) {
    this.price1 = price1;
  }


  public double getPrice2() {
    return price2;
  }

  public void setPrice2(double price2) {
    this.price2 = price2;
  }


  public double getPrice3() {
    return price3;
  }

  public void setPrice3(double price3) {
    this.price3 = price3;
  }


  public double getA1() {
    return a1;
  }

  public void setA1(double a1) {
    this.a1 = a1;
  }

}
