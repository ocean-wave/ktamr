package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaMetertype extends BaseEntity {

  private Integer metertypeid;
  private String name;
  private String icon;
  private String description;
  private Integer pricestandId;
  private Date createtime;
  private Date modifytime;


  public Integer getMetertypeid() {
    return metertypeid;
  }

  public void setMetertypeid(Integer metertypeid) {
    this.metertypeid = metertypeid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPricestandId() {
    return pricestandId;
  }

  public void setPricestandId(Integer pricestandId) {
    this.pricestandId = pricestandId;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Date getModifytime() {
    return modifytime;
  }

  public void setModifytime(Date modifytime) {
    this.modifytime = modifytime;
  }
}
