package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaCmd extends BaseEntity {

  private Integer id;
  private String cmd;
  private String parms;
  private Integer centorid;
  private String uid;
  private Date createTime;
  private String state;
  private Integer tryTimes;
  private Date lastEndTime;
  private Date lastBeginTime;
  private String processing;
  private Integer interCmdid;

  private HaCentor haCentor;

  public Integer getTryTimes() {
    return tryTimes;
  }

  public void setTryTimes(Integer tryTimes) {
    this.tryTimes = tryTimes;
  }

  public Date getLastBeginTime() {
    return lastBeginTime;
  }

  public void setLastBeginTime(Date lastBeginTime) {
    this.lastBeginTime = lastBeginTime;
  }

  public HaCentor getHaCentor() {
    return haCentor;
  }

  public void setHaCentor(HaCentor haCentor) {
    this.haCentor = haCentor;
  }

  public Date getLastEndTime() {
    return lastEndTime;
  }

  public void setLastEndTime(Date lastEndTime) {
    this.lastEndTime = lastEndTime;
  }

  @Override
  public Date getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCmd() {
    return cmd;
  }

  public void setCmd(String cmd) {
    this.cmd = cmd;
  }

  public String getParms() {
    return parms;
  }

  public void setParms(String parms) {
    this.parms = parms;
  }

  public Integer getCentorid() {
    return centorid;
  }

  public void setCentorid(Integer centorid) {
    this.centorid = centorid;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }

  public Integer getInterCmdid() {
    return interCmdid;
  }

  public void setInterCmdid(Integer interCmdid) {
    this.interCmdid = interCmdid;
  }
}
