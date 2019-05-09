package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class HaPricestandard extends BaseEntity {

    private Integer pricestandId;
    private Integer metertypeId;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date endTime;
    private double jPrice;
    private double fPrice;
    private double pPrice;
    private double gPrice;
    private double sMin;
    private double sMax;
    private Integer sDays;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    private long usagePoint1;
    private long usagePoint2;
    private String chargingMethods;
    private double price1;
    private double price2;
    private double price3;
    private double a1;

    private HaMetertype haMetertype;
    private HaMeter haMeter;
    private HaArea haArea;
    private String keyWord;


    public Integer getPricestandId() {
        return pricestandId;
    }

    public void setPricestandId(Integer pricestandId) {
        this.pricestandId = pricestandId;
    }

    public Integer getMetertypeId() {
        return metertypeId;
    }

    public void setMetertypeId(Integer metertypeId) {
        this.metertypeId = metertypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getjPrice() {
        return jPrice;
    }

    public void setjPrice(double jPrice) {
        this.jPrice = jPrice;
    }

    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    public double getsMin() {
        return sMin;
    }

    public void setsMin(double sMin) {
        this.sMin = sMin;
    }

    public double getsMax() {
        return sMax;
    }

    public void setsMax(double sMax) {
        this.sMax = sMax;
    }

    public Integer getsDays() {
        return sDays;
    }

    public void setsDays(Integer sDays) {
        this.sDays = sDays;
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

    public long getUsagePoint1() {
        return usagePoint1;
    }

    public void setUsagePoint1(long usagePoint1) {
        this.usagePoint1 = usagePoint1;
    }

    public long getUsagePoint2() {
        return usagePoint2;
    }

    public void setUsagePoint2(long usagePoint2) {
        this.usagePoint2 = usagePoint2;
    }

    public String getChargingMethods() {
        return chargingMethods;
    }

    public void setChargingMethods(String chargingMethods) {
        this.chargingMethods = chargingMethods;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public HaMetertype getHaMetertype() {
        return haMetertype;
    }

    public void setHaMetertype(HaMetertype haMetertype) {
        this.haMetertype = haMetertype;
    }

    public HaMeter getHaMeter() {
        return haMeter;
    }

    public void setHaMeter(HaMeter haMeter) {
        this.haMeter = haMeter;
    }

    public HaArea getHaArea() {
        return haArea;
    }

    public void setHaArea(HaArea haArea) {
        this.haArea = haArea;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
