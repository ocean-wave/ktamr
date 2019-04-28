package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

import java.sql.Date;
import java.sql.Timestamp;

public class HaRgn extends BaseEntity {

  private String id;
  private String name;
  private String shortName;
  private String zCode;
  private Date createTime;
  private Date modifyTime;

  //存
  private HaArea haArea;

  /**
   * 小区表数量
   */
  private Integer haAreaCount;

  /**
   * 集中器数量
   */
  private Integer haCentorCount;
  /**
   * 采集器数量
   */
  private Integer haCollectorCount;
  /**
   * 表具资料表数量
   */
  private Integer haMeterCount;

  public Integer getHaAreaCount() {
    return haAreaCount;
  }

  public void setHaAreaCount(Integer haAreaCount) {
    this.haAreaCount = haAreaCount;
  }

  public Integer getHaCentorCount() {
    return haCentorCount;
  }

  public void setHaCentorCount(Integer haCentorCount) {
    this.haCentorCount = haCentorCount;
  }

  public Integer getHaCollectorCount() {
    return haCollectorCount;
  }

  public void setHaCollectorCount(Integer haCollectorCount) {
    this.haCollectorCount = haCollectorCount;
  }

  public Integer getHaMeterCount() {
    return haMeterCount;
  }

  public void setHaMeterCount(Integer haMeterCount) {
    this.haMeterCount = haMeterCount;
  }

  public HaArea getHaArea() {
    return haArea;
  }

  public void setHaArea(HaArea haArea) {
    this.haArea = haArea;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getzCode() {
    return zCode;
  }

  public void setzCode(String zCode) {
    this.zCode = zCode;
  }

  @Override
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }
}
