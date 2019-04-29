package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaSystemstate extends BaseEntity {

  private Date thisTime;


  public Date getThisTime() {
    return thisTime;
  }

  public void setThisTime(Date thisTime) {
    this.thisTime = thisTime;
  }
}
