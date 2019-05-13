package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaBillrecords extends BaseEntity {

  private Integer bid;
  private Integer custId;
  private String operaTion;
  private double charge;
  private double currentBalance;
  private Date optTime;
  private String optMan;

  private String optType;

  //存对象
  private HaCustom haCustom;
  private String caoZuoRen;
  private String OtherName;

  //存查询时用到的对象
  private String  nodeType;
  private String nodeIds;
  private Object kaiShi;
  private Object JieShu;

  public Integer getBid() {
    return bid;
  }

  public void setBid(Integer bid) {
    this.bid = bid;
  }

  public Integer getCustId() {
    return custId;
  }

  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  public String getOperaTion() {
    return operaTion;
  }

  public void setOperaTion(String operaTion) {
    this.operaTion = operaTion;
  }

  public double getCharge() {
    return charge;
  }

  public void setCharge(double charge) {
    this.charge = charge;
  }

  public double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
  }

  public Date getOptTime() {
    return optTime;
  }

  public void setOptTime(Date optTime) {
    this.optTime = optTime;
  }

  public String getOptMan() {
    return optMan;
  }

  public void setOptMan(String optMan) {
    this.optMan = optMan;
  }

  public String getOptType() {
    return optType;
  }

  public void setOptType(String optType) {
    this.optType = optType;
  }

  public HaCustom getHaCustom() {
    return haCustom;
  }

  public void setHaCustom(HaCustom haCustom) {
    this.haCustom = haCustom;
  }

  public String getCaoZuoRen() {
    return caoZuoRen;
  }

  public void setCaoZuoRen(String caoZuoRen) {
    this.caoZuoRen = caoZuoRen;
  }

  public String getOtherName() {
    return OtherName;
  }

  public void setOtherName(String otherName) {
    OtherName = otherName;
  }

  public String getNodeType() {
    return nodeType;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public String getNodeIds() {
    return nodeIds;
  }

  public void setNodeIds(String nodeIds) {
    this.nodeIds = nodeIds;
  }

  public Object getKaiShi() {
    return kaiShi;
  }

  public void setKaiShi(Object kaiShi) {
    this.kaiShi = kaiShi;
  }

  public Object getJieShu() {
    return JieShu;
  }

  public void setJieShu(Object jieShu) {
    JieShu = jieShu;
  }
}
