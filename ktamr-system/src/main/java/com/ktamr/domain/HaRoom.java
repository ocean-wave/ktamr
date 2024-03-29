package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaRoom extends BaseEntity {

    private Integer roomId;
    private Integer custId;
    private Integer buildingId;
    private String name;
    private String description;

    private HaMeter haMeter;
    private HaCustom haCustom;
    private HaCentor haCentor;
    private HaCollector haCollector;
    private HaPricestandard haPricestandard;
    private HaBuilding haBuilding;
    private HaArea haArea;
    private HaMetertype haMetertype;
    private String uname;
    private Integer areaid;
    private String keyWord;
    private String roommeterId;
    private String typeName;

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

    public HaMetertype getHaMetertype() {
        return haMetertype;
    }

    public void setHaMetertype(HaMetertype haMetertype) {
        this.haMetertype = haMetertype;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getRoommeterId() {
        return roommeterId;
    }

    public void setRoommeterId(String roommeterId) {
        this.roommeterId = roommeterId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
