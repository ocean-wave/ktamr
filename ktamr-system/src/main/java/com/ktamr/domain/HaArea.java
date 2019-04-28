package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

public class HaArea extends BaseEntity {

  private Integer areaId;
  private String name;
  private String description;
  private Date lastchecktime;
  private String state;
  private String reserved;
  private String areaNo;
  private String shortname;
  private String addr;
  private String sumday;
  @JsonFormat( pattern = "yyyy-MM-dd HH:MM:SS")
  private Date lastsumday;
  private String ds;
  private Date createtime;
  private Date modifytime;
  private Date auditDay;
  private String auditResult;
  private String registeredno;

  private HaMeter meter;

  //开始存
  private HaMeter haMeter;
  private HaRgn haRgn;
  private HavMeterinfo havMeterinfo;
  private HaBuilding haBuilding;

  //定义接收
  private  Integer atnNumber;//不良表数
  private Integer countAreaNo;//2级菜单多少子的小区名称记录数
  private String cmdName;//定义别名类型接收

  //方便用areaid中in的范围查询
  List<Integer> idsList;

  public List<Integer> getIdsList() {
    return idsList;
  }

  public void setIdsList(List<Integer> idsList) {
    this.idsList = idsList;
  }

  public HaMeter getHaMeter() {
    return haMeter;
  }

  public void setHaMeter(HaMeter haMeter) {
    this.haMeter = haMeter;
  }

  public HaRgn getHaRgn() {
    return haRgn;
  }

  public void setHaRgn(HaRgn haRgn) {
    this.haRgn = haRgn;
  }

  public HavMeterinfo getHavMeterinfo() {
    return havMeterinfo;
  }

  public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
    this.havMeterinfo = havMeterinfo;
  }

  public HaBuilding getHaBuilding() {
    return haBuilding;
  }

  public void setHaBuilding(HaBuilding haBuilding) {
    this.haBuilding = haBuilding;
  }

  public Integer getAtnNumber() {
    return atnNumber;
  }

  public void setAtnNumber(Integer atnNumber) {
    this.atnNumber = atnNumber;
  }

  public Integer getCountAreaNo() {
    return countAreaNo;
  }

  public void setCountAreaNo(Integer countAreaNo) {
    this.countAreaNo = countAreaNo;
  }

  public String getCmdName() {
    return cmdName;
  }

  public void setCmdName(String cmdName) {
    this.cmdName = cmdName;
  }

  public String getAreaNo() {
    return areaNo;
  }

  public void setAreaNo(String areaNo) {
    this.areaNo = areaNo;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public HaMeter getMeter() {
    return meter;
  }

  public void setMeter(HaMeter meter) {
    this.meter = meter;
  }

  public Date getLastchecktime() {
    return lastchecktime;
  }

  public void setLastchecktime(Date lastchecktime) {
    this.lastchecktime = lastchecktime;
  }

  public Date getLastsumday() {
    return lastsumday;
  }

  public void setLastsumday(Date lastsumday) {
    this.lastsumday = lastsumday;
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

  public Date getAuditDay() {
    return auditDay;
  }

  public void setAuditDay(Date auditDay) {
    this.auditDay = auditDay;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReserved() {
    return reserved;
  }

  public void setReserved(String reserved) {
    this.reserved = reserved;
  }

  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getSumday() {
    return sumday;
  }

  public void setSumday(String sumday) {
    this.sumday = sumday;
  }

  public String getDs() {
    return ds;
  }

  public void setDs(String ds) {
    this.ds = ds;
  }

  public String getAuditResult() {
    return auditResult;
  }

  public void setAuditResult(String auditResult) {
    this.auditResult = auditResult;
  }

  public String getRegisteredno() {
    return registeredno;
  }

  public void setRegisteredno(String registeredno) {
    this.registeredno = registeredno;
  }

}
