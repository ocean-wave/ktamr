package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;


public class HaMonthbtime extends BaseEntity {

  private Date startTime;
  private Date endTime;
  private Integer areaId;

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }
}
