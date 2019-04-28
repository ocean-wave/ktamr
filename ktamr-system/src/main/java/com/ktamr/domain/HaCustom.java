package com.ktamr.domain;


import com.ktamr.common.core.domain.BaseEntity;

public class HaCustom extends BaseEntity {

  private Integer custId;
  private String custNo;
  private String name;
  private String sex;
  private String idnumber;
  private String idname;
  private String tel;
  private String mobil;
  private String addr;
  private String zip;
  private String bank;
  private String account;
  private String lastbillid;
  private String billid;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp modifytime;
  private Integer balance;
  private double expense;
  private java.sql.Timestamp paidtime;
  private double recharge;
  private java.sql.Timestamp rechargetime;
  private java.sql.Timestamp posttime;

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public Integer getCustId() {
    return custId;
  }

  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  public String getCustNo() {
    return custNo;
  }

  public void setCustNo(String custNo) {
    this.custNo = custNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getIdnumber() {
    return idnumber;
  }

  public void setIdnumber(String idnumber) {
    this.idnumber = idnumber;
  }


  public String getIdname() {
    return idname;
  }

  public void setIdname(String idname) {
    this.idname = idname;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getMobil() {
    return mobil;
  }

  public void setMobil(String mobil) {
    this.mobil = mobil;
  }


  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }


  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getLastbillid() {
    return lastbillid;
  }

  public void setLastbillid(String lastbillid) {
    this.lastbillid = lastbillid;
  }


  public String getBillid() {
    return billid;
  }

  public void setBillid(String billid) {
    this.billid = billid;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public java.sql.Timestamp getModifytime() {
    return modifytime;
  }

  public void setModifytime(java.sql.Timestamp modifytime) {
    this.modifytime = modifytime;
  }

  public double getExpense() {
    return expense;
  }

  public void setExpense(double expense) {
    this.expense = expense;
  }


  public java.sql.Timestamp getPaidtime() {
    return paidtime;
  }

  public void setPaidtime(java.sql.Timestamp paidtime) {
    this.paidtime = paidtime;
  }


  public double getRecharge() {
    return recharge;
  }

  public void setRecharge(double recharge) {
    this.recharge = recharge;
  }


  public java.sql.Timestamp getRechargetime() {
    return rechargetime;
  }

  public void setRechargetime(java.sql.Timestamp rechargetime) {
    this.rechargetime = rechargetime;
  }


  public java.sql.Timestamp getPosttime() {
    return posttime;
  }

  public void setPosttime(java.sql.Timestamp posttime) {
    this.posttime = posttime;
  }

}
