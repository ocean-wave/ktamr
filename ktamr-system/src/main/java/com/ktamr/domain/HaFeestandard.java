package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaFeestandard extends BaseEntity {

  private Integer feeId;
  private Integer pricestandId;
  private String name;
  private double price1;
  private double price2;
  private double price3;


  public Integer getFeeId() {
    return feeId;
  }

  public void setFeeId(Integer feeId) {
    this.feeId = feeId;
  }

  public Integer getPricestandId() {
    return pricestandId;
  }

  public void setPricestandId(Integer pricestandId) {
    this.pricestandId = pricestandId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
