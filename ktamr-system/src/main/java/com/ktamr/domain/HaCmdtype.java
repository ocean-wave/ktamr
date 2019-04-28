package com.ktamr.domain;


public class HaCmdtype {

  private long id;
  private String name;
  private String cmdFormat;
  private String rcvType;
  private long rcvRecordLength;
  private String description;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCmdFormat() {
    return cmdFormat;
  }

  public void setCmdFormat(String cmdFormat) {
    this.cmdFormat = cmdFormat;
  }


  public String getRcvType() {
    return rcvType;
  }

  public void setRcvType(String rcvType) {
    this.rcvType = rcvType;
  }


  public long getRcvRecordLength() {
    return rcvRecordLength;
  }

  public void setRcvRecordLength(long rcvRecordLength) {
    this.rcvRecordLength = rcvRecordLength;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
