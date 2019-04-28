package com.ktamr.domain;


public class HaMetertype {

  private long metertypeid;
  private String name;
  private String icon;
  private String description;
  private long pricestandId;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp modifytime;


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


  public long getPricestandId() {
    return pricestandId;
  }

  public void setPricestandId(long pricestandId) {
    this.pricestandId = pricestandId;
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

}
