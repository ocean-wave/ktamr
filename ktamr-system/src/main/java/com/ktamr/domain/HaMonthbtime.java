package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;


public class HaMonthbtime extends BaseEntity {

  @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  private Date startTime;
  @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  private Date endTime;
  private Integer areaId;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
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
