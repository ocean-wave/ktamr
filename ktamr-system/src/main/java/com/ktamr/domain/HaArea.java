package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.annotation.Excel;
import com.ktamr.common.annotation.Excel.Type;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import sun.security.krb5.internal.crypto.EType;

import java.util.Date;
import java.util.List;

public class HaArea extends BaseEntity {

    private Integer areaId;
    @Excel(name = "小区编号",width = 8)
    private String areaNo;
    @Excel(name = "小区册号",width = 8)
    private String registeredNo;
    @Excel(name = "小区名称",width = 20)
    private String name;
    @Excel(name = "地址",width = 32)
    private String addr;
    @Excel(name = "抄收月份",width = 5)
    private String ds;
    private String description;
    private Date lastcheckTime;
    private String state;
    @Excel(name = "冻结抄收",width = 5)
    private String reserved;
    private String shortName;
    private String sumDay;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auditDay;
    private String auditResult;

    @Excel(name = "总表数",width = 8)
    private Integer sumNumber;
    @Excel(name = "总读数",width = 8)
    private Integer readNumber;
    @Excel(name = "本期总用量",width = 8)
    private Integer sumDosage;
    @Excel(name = "不良表数",width = 8)
    private Integer atnNumber;
    private String monthType;
    private Integer haAreaCount;
    private String rgn;
    private String rgnIds;

    //开始存
    @Excel(name = {"最近抄表时间"}, targetAttr = {"thRTime"},width = {20},dateFormat = "yyyy-MM-dd HH:mm:ss",type = Type.EXPORT)
    private HaMeter haMeter;
    private HaRgn haRgn;
    private HavMeterinfo havMeterinfo;
    private HaBuilding haBuilding;

    //定义接收
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算日期",dateFormat = "yyyy-MM-dd HH:mm:ss",width = 20)
    private Date lastsumDay;
    private Integer countAreaNo;//2级菜单多少子的小区名称记录数
    private String cmdName;//定义别名类型接收
    private String keyWord; //定义从页面接收输入框的值
    private String opertorCode;//定义这个别名方便获取用户会话操作人
    //方便用areaid中in的范围查询
    private List<Integer> idsList;
    private List<String> idsList2;
    private String  haAreaPercentage;//声明HaArea别名百分比


    public String getHaAreaPercentage() {
        return haAreaPercentage;
    }

    public void setHaAreaPercentage(String haAreaPercentage) {
        this.haAreaPercentage = haAreaPercentage;
    }

    public Integer getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(Integer sumNumber) {
        this.sumNumber = sumNumber;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public Integer getSumDosage() {
        return sumDosage;
    }

    public void setSumDosage(Integer sumDosage) {
        this.sumDosage = sumDosage;
    }

    public String getOpertorCode() {
        return opertorCode;
    }

    public void setOpertorCode(String opertorCode) {
        this.opertorCode = opertorCode;
    }

    public List<String> getIdsList2() {
        return idsList2;
    }

    public void setIdsList2(List<String> idsList2) {
        this.idsList2 = idsList2;
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
