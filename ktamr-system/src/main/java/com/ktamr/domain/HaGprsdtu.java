package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaGprsdtu extends BaseEntity {

    private String uId;
    private String telNubmer;
    private String addr;
    private Integer centors;
    private String state;
    private String dscrp;
    private Date oplastTime;
    private Integer idle;

    private HaCentor haCentor;
    private HaArea haArea;


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getTelNubmer() {
        return telNubmer;
    }

    public void setTelNubmer(String telNubmer) {
        this.telNubmer = telNubmer;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getCentors() {
        return centors;
    }

    public void setCentors(Integer centors) {
        this.centors = centors;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDscrp() {
        return dscrp;
    }

    public void setDscrp(String dscrp) {
        this.dscrp = dscrp;
    }

    public Date getOplastTime() {
        return oplastTime;
    }

    public void setOplastTime(Date oplastTime) {
        this.oplastTime = oplastTime;
    }

    public Integer getIdle() {
        return idle;
    }

    public void setIdle(Integer idle) {
        this.idle = idle;
    }

    public HaCentor getHaCentor() {
        return haCentor;
    }

    public void setHaCentor(HaCentor haCentor) {
        this.haCentor = haCentor;
    }

    public HaArea getHaArea() {
        return haArea;
    }

    public void setHaArea(HaArea haArea) {
        this.haArea = haArea;
    }
}
