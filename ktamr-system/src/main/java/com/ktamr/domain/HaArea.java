package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class HaArea extends BaseEntity {

    private Integer areaId;
    private String name;
    private String description;
    private Date lastcheckTime;
    private String state;
    private String reserved;
    private String areaNo;
    private String shortName;
    private String addr;
    private String sumDay;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastsumDay;
    private String ds;
    private Date createTime;
    private Date modifyTime;
    private Date auditDay;
    private String auditResult;
    private String registeredNo;

    private String monthType;
    private Integer haAreaCount;
    private String rgn;
    private String rgnIds;


    //开始存
    private HaMeter haMeter;
    private HaRgn haRgn;
    private HavMeterinfo havMeterinfo;
    private HaBuilding haBuilding;

    //定义接收
    private Integer atnNumber;//不良表数
    private Integer countAreaNo;//2级菜单多少子的小区名称记录数
    private String cmdName;//定义别名类型接收
    private String keyWord; //ssss
    //方便用areaid中in的范围查询
    List<Integer> idsList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastcheckTime() {
        return lastcheckTime;
    }

    public void setLastcheckTime(Date lastcheckTime) {
        this.lastcheckTime = lastcheckTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSumDay() {
        return sumDay;
    }

    public void setSumDay(String sumDay) {
        this.sumDay = sumDay;
    }

    public Date getLastsumDay() {
        return lastsumDay;
    }

    public void setLastsumDay(Date lastsumDay) {
        this.lastsumDay = lastsumDay;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
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

    public Date getAuditDay() {
        return auditDay;
    }

    public void setAuditDay(Date auditDay) {
        this.auditDay = auditDay;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo;
    }

    public HaMeter getHaMeter() {
        return haMeter;
    }

    public void setHaMeter(HaMeter haMeter) {
        this.haMeter = haMeter;
    }

    public HaRgn getHaRgn() {
        return haRgn;
    }

    public void setHaRgn(HaRgn haRgn) {
        this.haRgn = haRgn;
    }

    public HavMeterinfo getHavMeterinfo() {
        return havMeterinfo;
    }

    public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
        this.havMeterinfo = havMeterinfo;
    }

    public HaBuilding getHaBuilding() {
        return haBuilding;
    }

    public void setHaBuilding(HaBuilding haBuilding) {
        this.haBuilding = haBuilding;
    }

    public Integer getAtnNumber() {
        return atnNumber;
    }

    public void setAtnNumber(Integer atnNumber) {
        this.atnNumber = atnNumber;
    }

    public Integer getCountAreaNo() {
        return countAreaNo;
    }

    public void setCountAreaNo(Integer countAreaNo) {
        this.countAreaNo = countAreaNo;
    }

    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<Integer> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Integer> idsList) {
        this.idsList = idsList;
    }

    public String getMonthType() {
        return monthType;
    }

    public void setMonthType(String monthType) {
        this.monthType = monthType;
    }

    public Integer getHaAreaCount() {
        return haAreaCount;
    }

    public void setHaAreaCount(Integer haAreaCount) {
        this.haAreaCount = haAreaCount;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getRgnIds() {
        return rgnIds;
    }

    public void setRgnIds(String rgnIds) {
        this.rgnIds = rgnIds;
    }
}
