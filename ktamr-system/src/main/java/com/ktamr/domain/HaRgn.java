package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class HaRgn extends BaseEntity {

    private String id;
    private String name;
    private String shortName;
    private String zcode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    //存
    private HaArea haArea;
    private HaCentor haCentor;
    private HaCollector haCollector;

    private HaMeter haMeter;

    /**
     * 小区表数量
     */
    private Integer haAreaCount;

    /**
     * 集中器数量
     */
    private Integer haCentorCount;
    /**
     * 采集器数量
     */
    private Integer haCollectorCount;
    /**
     * 表具资料表数量
     */
    private Integer haMeterCount;
    /**
     * 不良表数量
     */
    private Integer badMeterCount;

    private String keyWord;

    public String getZcode() {
        return zcode;
    }

    public void setZcode(String zcode) {
        this.zcode = zcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public HaArea getHaArea() {
        return haArea;
    }

    public void setHaArea(HaArea haArea) {
        this.haArea = haArea;
    }

    public Integer getHaAreaCount() {
        return haAreaCount;
    }

    public void setHaAreaCount(Integer haAreaCount) {
        this.haAreaCount = haAreaCount;
    }

    public Integer getHaCentorCount() {
        return haCentorCount;
    }

    public void setHaCentorCount(Integer haCentorCount) {
        this.haCentorCount = haCentorCount;
    }

    public Integer getHaCollectorCount() {
        return haCollectorCount;
    }

    public void setHaCollectorCount(Integer haCollectorCount) {
        this.haCollectorCount = haCollectorCount;
    }

    public Integer getHaMeterCount() {
        return haMeterCount;
    }

    public void setHaMeterCount(Integer haMeterCount) {
        this.haMeterCount = haMeterCount;
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

    public HaMeter getHaMeter() {
        return haMeter;
    }

    public void setHaMeter(HaMeter haMeter) {
        this.haMeter = haMeter;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getBadMeterCount() {
        return badMeterCount;
    }

    public void setBadMeterCount(Integer badMeterCount) {
        this.badMeterCount = badMeterCount;
    }
}
