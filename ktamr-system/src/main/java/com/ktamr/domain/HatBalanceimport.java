package com.ktamr.domain;


public class HatBalanceimport {

  private long id;
  private String usercode;
  private String username;
  private double meternumber;
  private double balance;
  private long userid;
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


  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
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
