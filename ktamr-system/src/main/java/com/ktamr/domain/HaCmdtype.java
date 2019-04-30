package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaCmdtype extends BaseEntity {

  private Integer id;
  private String name;
  private String cmdFormat;
  private String rcvType;
  private Integer rcvRecordLength;
  private String description;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public Integer getRcvRecordLength() {
    return rcvRecordLength;
  }

  public void setRcvRecordLength(Integer rcvRecordLength) {
    this.rcvRecordLength = rcvRecordLength;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
