package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.sql.Date;
import java.sql.Timestamp;

public class HaRgn extends BaseEntity {

    private String id;
    private String name;
    private String shortName;
    private String zCode;
    private Date createTime;
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

    private String keyWord;


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

    public String getzCode() {
        return zCode;
    }

    public void setzCode(String zCode) {
        this.zCode = zCode;
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
}
