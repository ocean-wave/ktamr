package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

public class HaBuilding extends BaseEntity {

  private Integer buildingId;
  private Integer areaId;
  private String name;
  private String descripTion;
  private String areaNo;
  private String buildingNo;
  private Date createTime;
  private Date modifyTime;

  private HaRoom haRoom;


  public Integer getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(Integer buildingId) {
    this.buildingId = buildingId;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescripTion() {
    return descripTion;
  }

  public void setDescripTion(String descripTion) {
    this.descripTion = descripTion;
  }

  public String getAreaNo() {
    return areaNo;
  }

  public void setAreaNo(String areaNo) {
    this.areaNo = areaNo;
  }

  public String getBuildingNo() {
    return buildingNo;
  }

  public void setBuildingNo(String buildingNo) {
    this.buildingNo = buildingNo;
  }

  @Override
  public Date getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public Date getModifyTime() {
    return modifyTime;
  }

  @Override
  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public HaRoom getHaRoom() {
    return haRoom;
  }

  public void setHaRoom(HaRoom haRoom) {
    this.haRoom = haRoom;
  }
}
