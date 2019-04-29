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
    private HaCentor haCentor;
    private HaCollector haCollector;
    private HaPricestandard haPricestandard;
    private HaBuilding haBuilding;
    private HaArea haArea;
    private String uname;
    private Integer areaid;

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

    public HaCentor getHaCentor() {
        return haCentor;
    }

    public void setHaCentor(HaCentor haCentor) {
        this.haCentor = haCentor;
    }

    public HaCollector getHaCollector() {
        return haCollector;
    }

    public void setHaCollector(HaCollector haCollector) {
        this.haCollector = haCollector;
    }

    public HaPricestandard getHaPricestandard() {
        return haPricestandard;
    }

    public void setHaPricestandard(HaPricestandard haPricestandard) {
        this.haPricestandard = haPricestandard;
    }

    public HaBuilding getHaBuilding() {
        return haBuilding;
    }

    public void setHaBuilding(HaBuilding haBuilding) {
        this.haBuilding = haBuilding;
    }

    public HaArea getHaArea() {
        return haArea;
    }

    public void setHaArea(HaArea haArea) {
        this.haArea = haArea;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }
}
