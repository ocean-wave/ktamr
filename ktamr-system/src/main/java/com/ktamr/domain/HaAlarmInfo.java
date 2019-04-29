package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaAlarmInfo extends BaseEntity {

  /**
   * 小可爱改的实体类
   */
  private String id;
  private String level;
  private String type;
  private Date tm;
  private String modId;
  private String rem;
  private Date procTm;
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

  public Date getTm() {
    return tm;
  }

  public void setTm(Date tm) {
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

  public Date getProcTm() {
    return procTm;
  }

  public void setProcTm(Date procTm) {
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
