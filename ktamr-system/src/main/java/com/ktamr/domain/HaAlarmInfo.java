package com.ktamr.domain;


public class HaAlarmInfo {

  private String id;
  private String level;
  private String type;
  private java.sql.Timestamp tm;
  private String modId;
  private String rem;
  private java.sql.Timestamp procTm;
  private String procStatus;
  private String procRem;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public java.sql.Timestamp getTm() {
    return tm;
  }

  public void setTm(java.sql.Timestamp tm) {
    this.tm = tm;
  }


  public String getModId() {
    return modId;
  }

  public void setModId(String modId) {
    this.modId = modId;
  }


  public String getRem() {
    return rem;
  }

  public void setRem(String rem) {
    this.rem = rem;
  }


  public java.sql.Timestamp getProcTm() {
    return procTm;
  }

  public void setProcTm(java.sql.Timestamp procTm) {
    this.procTm = procTm;
  }


  public String getProcStatus() {
    return procStatus;
  }

  public void setProcStatus(String procStatus) {
    this.procStatus = procStatus;
  }


  public String getProcRem() {
    return procRem;
  }

  public void setProcRem(String procRem) {
    this.procRem = procRem;
  }

}
