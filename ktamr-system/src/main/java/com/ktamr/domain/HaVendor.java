package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaVendor extends BaseEntity {

  private Integer vendorId;
  private String name;
  private String code;
  private String url;
  private String descripTion;


  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescripTion() {
    return descripTion;
  }

  public void setDescripTion(String descripTion) {
    this.descripTion = descripTion;
  }
}
