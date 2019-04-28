package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HaBillrecords {

  private long bid;
  private long custid;
  private String operation;
  private double charge;
  private double currentbalance;
  private Date opttime;
  private String optman;

  private String optType;

  //存对象
  private HaCustom haCustom;
  private String caoZuoRen;
  private String OtherName;

  //存查询时用到的对象
  private String  nodeType;
  private String nodeIds;
  @JsonFormat(pattern = " yyyy-MM-dd HH:mm:ss ")
  private Date kaiShi;
  @JsonFormat(pattern = " yyyy-MM-dd HH:mm:ss ")
  private Date JieShu;

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

  public Date getKaiShi() {
    return kaiShi;
  }

  public void setKaiShi(Date kaiShi) {
    this.kaiShi = kaiShi;
  }

  public Date getJieShu() {
    return JieShu;
  }

  public void setJieShu(Date jieShu) {
    JieShu = jieShu;
  }

  public Date getOpttime() {
    return opttime;
  }

  public void setOpttime(Date opttime) {
    this.opttime = opttime;
  }

  public long getBid() {
    return bid;
  }

  public void setBid(long bid) {
    this.bid = bid;
  }


  public long getCustid() {
    return custid;
  }

  public void setCustid(long custid) {
    this.custid = custid;
  }


  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }


  public double getCharge() {
    return charge;
  }

  public void setCharge(double charge) {
    this.charge = charge;
  }


  public double getCurrentbalance() {
    return currentbalance;
  }

  public void setCurrentbalance(double currentbalance) {
    this.currentbalance = currentbalance;
  }

  public String getOptman() {
    return optman;
  }

  public void setOptman(String optman) {
    this.optman = optman;
  }

}
