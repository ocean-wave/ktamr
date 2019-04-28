package com.ktamr.domain;


public class HaReplacerecords {

  private long recordid;
  private long meterid;
  private double oldmeternumber;
  private double newmeternumber;
  private double finalread;
  private double finaluse;
  private String finalstate;
  private double oriread;
  private String replaceman;
  private java.sql.Timestamp replacedate;
  private String explain;


  public long getRecordid() {
    return recordid;
  }

  public void setRecordid(long recordid) {
    this.recordid = recordid;
  }


  public long getMeterid() {
    return meterid;
  }

  public void setMeterid(long meterid) {
    this.meterid = meterid;
  }


  public double getOldmeternumber() {
    return oldmeternumber;
  }

  public void setOldmeternumber(double oldmeternumber) {
    this.oldmeternumber = oldmeternumber;
  }


  public double getNewmeternumber() {
    return newmeternumber;
  }

  public void setNewmeternumber(double newmeternumber) {
    this.newmeternumber = newmeternumber;
  }


  public double getFinalread() {
    return finalread;
  }

  public void setFinalread(double finalread) {
    this.finalread = finalread;
  }


  public double getFinaluse() {
    return finaluse;
  }

  public void setFinaluse(double finaluse) {
    this.finaluse = finaluse;
  }


  public String getFinalstate() {
    return finalstate;
  }

  public void setFinalstate(String finalstate) {
    this.finalstate = finalstate;
  }


  public double getOriread() {
    return oriread;
  }

  public void setOriread(double oriread) {
    this.oriread = oriread;
  }


  public String getReplaceman() {
    return replaceman;
  }

  public void setReplaceman(String replaceman) {
    this.replaceman = replaceman;
  }


  public java.sql.Timestamp getReplacedate() {
    return replacedate;
  }

  public void setReplacedate(java.sql.Timestamp replacedate) {
    this.replacedate = replacedate;
  }


  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }

}
