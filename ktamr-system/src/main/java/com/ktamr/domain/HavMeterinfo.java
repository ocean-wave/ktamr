package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HavMeterinfo extends BaseEntity {

  private Integer meterid;
  private Integer areaid;
  private String areano;
  private String ds;
  private Integer buildingid;
  private Integer roomid;
  private Integer centorid;
  private Integer deviceid;
  private String centorno;
  private String addr;
  private Integer custid;
  private Integer pricestandId;
  private String userNo;//用户号
  private Integer meterNumber;//表号
  private String maddr;//表地址
  private String userName;//用户名
  private String areaName;//小区名
  private String userDs;//用户地址
  private double thNumber;//最近度数
  private double lfNumber;//上期度数
  private double sNumber;//本期用量
  private String thRTime;//抄表时间
  private String lfTime;//上期抄收时间
  private String state;//状态

    public String getMaddr() {
        return maddr;
    }

    public void setMaddr(String maddr) {
        this.maddr = maddr;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(Integer meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserDs() {
        return userDs;
    }

    public void setUserDs(String userDs) {
        this.userDs = userDs;
    }

    public double getThNumber() {
        return thNumber;
    }

    public void setThNumber(double thNumber) {
        this.thNumber = thNumber;
    }

    public double getLfNumber() {
        return lfNumber;
    }

    public void setLfNumber(double lfNumber) {
        this.lfNumber = lfNumber;
    }

    public double getsNumber() {
        return sNumber;
    }

    public void setsNumber(double sNumber) {
        this.sNumber = sNumber;
    }

    public String getThRTime() {
        return thRTime;
    }

    public void setThRTime(String thRTime) {
        this.thRTime = thRTime;
    }

    public String getLfTime() {
        return lfTime;
    }

    public void setLfTime(String lfTime) {
        this.lfTime = lfTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMeterid() {
        return meterid;
    }

    public void setMeterid(Integer meterid) {
        this.meterid = meterid;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreano() {
        return areano;
    }

    public void setAreano(String areano) {
        this.areano = areano;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getCentorid() {
        return centorid;
    }

    public void setCentorid(Integer centorid) {
        this.centorid = centorid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getCentorno() {
        return centorno;
    }

    public void setCentorno(String centorno) {
        this.centorno = centorno;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getPricestandId() {
        return pricestandId;
    }

    public void setPricestandId(Integer pricestandId) {
        this.pricestandId = pricestandId;
    }
}
