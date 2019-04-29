package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.util.Date;

public class HaConfig   extends BaseEntity {

  private String S;
  private String K;
  private String kname;
  private String V;
  private Date lastTime;
  private String uid;
  private double pos;



  public String getS() {
    return S;
  }

  public void setS(String s) {
    S = s;
  }

  public String getK() {
    return K;
  }

  public void setK(String k) {
    K = k;
  }

  public String getKname() {
    return kname;
  }

  public void setKname(String kname) {
    this.kname = kname;
  }

  public String getV() {
    return V;
  }

  public void setV(String v) {
    V = v;
  }

  public Date getLastTime() {
    return lastTime;
  }

  public void setLastTime(Date lastTime) {
    this.lastTime = lastTime;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public double getPos() {
    return pos;
  }

  public void setPos(double pos) {
    this.pos = pos;
  }
}
