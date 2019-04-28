package com.ktamr.common.parameter;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ParameterInfo {

    private String rgnid;
    private String search;
    private String nd;
    private String sidx;
    private String keyWord;
    private String monthType;
    private Integer areaid;
    private Integer buildingid;
    private String dataType;
    private String startDate;
    private String endDate;
    private Integer meterid;
    private String cmdids;
    private String ids;
    private String cmdName;
    private String wheresql;
    private Integer centorid;
    private String nodeType;
    private String nodeIds;
    private Integer collectorid;
    private String[] dataTypes;

    public String[] getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(String[] dataTypes) {
        this.dataTypes = dataTypes;
    }

    public Integer getCollectorid() {
        return collectorid;
    }

    public void setCollectorid(Integer collectorid) {
        this.collectorid = collectorid;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeIds() {
        return nodeIds;
    }

    public void setNodeIds(String nodeIds) {
        this.nodeIds = nodeIds;
    }

    public Integer getCentorid() {
        return centorid;
    }

    public void setCentorid(Integer centorid) {
        this.centorid = centorid;
    }

    public String getWheresql() {
        return wheresql;
    }

    public void setWheresql(String wheresql) {
        this.wheresql = wheresql;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getCmdids() {
        return cmdids;
    }

    public void setCmdids(String cmdids) {
        this.cmdids = cmdids;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMeterid() {
        return meterid;
    }

    public void setMeterid(Integer meterid) {
        this.meterid = meterid;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public String getRgnid() {
        return rgnid;
    }

    public void setRgnid(String rgnid) {
        this.rgnid = rgnid;
    }

    public String getMonthType() {
        return monthType;
    }

    public void setMonthType(String monthType) {
        this.monthType = monthType;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
