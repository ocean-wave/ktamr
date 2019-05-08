package com.ktamr.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HaReplacerecords extends BaseEntity {

  private Integer recordId;
  private Integer meterId;
  private double oldmeterNumber;
  private double newmeterNumber;
  private double finalRead;
  private double finalUse;
  private String finalState;
  private double oriRead;
  private String replaceMan;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date replaceDate;
  private String exPlain;


  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public Integer getMeterId() {
    return meterId;
  }

  public void setMeterId(Integer meterId) {
    this.meterId = meterId;
  }

  public double getOldmeterNumber() {
    return oldmeterNumber;
  }

  public void setOldmeterNumber(double oldmeterNumber) {
    this.oldmeterNumber = oldmeterNumber;
  }

  public double getNewmeterNumber() {
    return newmeterNumber;
  }

  public void setNewmeterNumber(double newmeterNumber) {
    this.newmeterNumber = newmeterNumber;
  }

  public double getFinalRead() {
    return finalRead;
  }

  public void setFinalRead(double finalRead) {
    this.finalRead = finalRead;
  }

  public double getFinalUse() {
    return finalUse;
  }

  public void setFinalUse(double finalUse) {
    this.finalUse = finalUse;
  }

  public String getFinalState() {
    return finalState;
  }

  public void setFinalState(String finalState) {
    this.finalState = finalState;
  }

  public double getOriRead() {
    return oriRead;
  }

  public void setOriRead(double oriRead) {
    this.oriRead = oriRead;
  }

  public String getReplaceMan() {
    return replaceMan;
  }

  public void setReplaceMan(String replaceMan) {
    this.replaceMan = replaceMan;
  }

  public Date getReplaceDate() {
    return replaceDate;
  }

  public void setReplaceDate(Date replaceDate) {
    this.replaceDate = replaceDate;
  }

  public String getExPlain() {
    return exPlain;
  }

  public void setExPlain(String exPlain) {
    this.exPlain = exPlain;
  }
}
