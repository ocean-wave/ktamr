package com.ktamr.domain;


import java.util.List;

public class HaRoom {

  private Integer roomId;
  private Integer buildingId;
  private String name;
  private String description;

  private HaMeter meter;
  private HaCustom custom;

  public HaMeter getMeter() {
    return meter;
  }

  public void setMeter(HaMeter meter) {
    this.meter = meter;
  }

  public HaCustom getCustom() {
    return custom;
  }

  public void setCustom(HaCustom custom) {
    this.custom = custom;
  }

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


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
