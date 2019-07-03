package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaDayfreeze extends BaseEntity {

    private Integer meterId;
    private Long meterNumber;
    private Integer centorId;
    private Integer collectorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date readTime;
    private String state;
    private Integer tread;
    private Integer lread;
    private Integer amount;

    private HavMeterinfo havMeterinfo;
    private String userDs;

    public String getUserDs() {
        return userDs;
    }

    public void setUserDs(String userDs) {
        this.userDs = userDs;
    }

    public Long getMeterNumber() {
      return meterNumber;
    }

    public void setMeterNumber(Long meterNumber) {
      this.meterNumber = meterNumber;
    }

    public HavMeterinfo getHavMeterinfo() {
      return havMeterinfo;
    }

    public void setHavMeterinfo(HavMeterinfo havMeterinfo) {
      this.havMeterinfo = havMeterinfo;
    }

    public Integer getMeterId() {
      return meterId;
    }

    public void setMeterId(Integer meterId) {
      this.meterId = meterId;
    }

    public Integer getCentorId() {
      return centorId;
    }

    public void setCentorId(Integer centorId) {
      this.centorId = centorId;
    }

    public Integer getCollectorId() {
      return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
      this.collectorId = collectorId;
    }

    public Date getReadTime() {
      return readTime;
    }

    public void setReadTime(Date readTime) {
      this.readTime = readTime;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public Date getFday() {
        return fday;
    }

    public void setFday(Date fday) {
        this.fday = fday;
    }

    public Date getLday() {
        return lday;
    }

    public void setLday(Date lday) {
        this.lday = lday;
    }

    public Integer getTread() {
        return tread;
    }

    public void setTread(Integer tread) {
        this.tread = tread;
    }

    public Integer getLread() {
        return lread;
    }

    public void setLread(Integer lread) {
        this.lread = lread;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
