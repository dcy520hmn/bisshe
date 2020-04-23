package com.keji.pojo.baseMessage;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_provider")
@Data
public class TProvider implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pId")
  private Integer id;
  @Column(name = "pAttribute")
  private String attribute;
  @Column(name = "pAreaId")
  private String areaId;
  @Column(name = "pAreaName")
  private String areaName;
  @Column(name = "pName")
  private String name;
  @Column(name = "pShortName")
  private String shortName;
  @Column(name = "pMessagerPhone")
  private String messagePhone;
  @Column(name = "pMessageName")
  private String messageName;
  @Column(name = "pAddress")
  private String address;
  @Column(name = "pBank")
  private String bank;
  @Column(name = "pAccount")
  private String account;
  @Column(name = "pPresent")
  private String present;
  @Column(name = "pPostcode")
  private String postcode;
  @Column(name = "pEmail")
  private String email;
  @Column(name = "state")
  private Integer state;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
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

  public String getMessagePhone() {
    return messagePhone;
  }

  public void setMessagePhone(String messagePhone) {
    this.messagePhone = messagePhone;
  }

  public String getMessageName() {
    return messageName;
  }

  public void setMessageName(String messageName) {
    this.messageName = messageName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public String getPresent() {
    return present;
  }

  public void setPresent(String present) {
    this.present = present;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }
}
