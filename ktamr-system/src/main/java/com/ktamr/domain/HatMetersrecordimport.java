package com.ktamr.domain;


public class HatMetersrecordimport {

  private long id;
  private String usercode;
  private String username;
  private double meternumber;
  private String state;
  private double readnumber;
  private java.sql.Timestamp readtime;
  private long meterid;
  private long hasdayfreeze;
  private long hasmonfreeze;
  private String check;
  private java.sql.Timestamp importtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public double getMeternumber() {
    return meternumber;
  }

  public void setMeternumber(double meternumber) {
    this.meternumber = meternumber;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public double getReadnumber() {
    return readnumber;
  }

  public void setReadnumber(double readnumber) {
    this.readnumber = readnumber;
  }


  public java.sql.Timestamp getReadtime() {
    return readtime;
  }

  public void setReadtime(java.sql.Timestamp readtime) {
    this.readtime = readtime;
  }


  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
    this.meterid = meterid;
  }


  public long getHasdayfreeze() {
    return hasdayfreeze;
  }

  public void setHasdayfreeze(long hasdayfreeze) {
    this.hasdayfreeze = hasdayfreeze;
  }


  public long getHasmonfreeze() {
    return hasmonfreeze;
  }

  public void setHasmonfreeze(long hasmonfreeze) {
    this.hasmonfreeze = hasmonfreeze;
  }


  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }


  public java.sql.Timestamp getImporttime() {
    return importtime;
  }

  public void setImporttime(java.sql.Timestamp importtime) {
    this.importtime = importtime;
  }

}
