package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.List;

public class HaRoom extends BaseEntity {

  private Integer roomId;
  private Integer buildingId;
  private String name;
  private String descripTion;

  private HaMeter haMeter;
  private HaCustom haCustom;


  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Integer getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(Integer buildingId) {
    this.buildingId = buildingId;
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

  public HaMeter getHaMeter() {
    return haMeter;
  }

  public void setHaMeter(HaMeter haMeter) {
    this.haMeter = haMeter;
  }

  public HaCustom getHaCustom() {
    return haCustom;
  }

  public void setHaCustom(HaCustom haCustom) {
    this.haCustom = haCustom;
  }
}
