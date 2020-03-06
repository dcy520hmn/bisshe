package com.keji.pojo.baseMessage;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TProvider")
public class TProvider implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long pId;
  private String pAttribute;
  private long pAreaId;
  private String pAreaName;
  private String pName;
  private String pShortName;
  private String pMessagerPhone;
  private String pMessageName;
  private String pAddress;
  private String pBank;
  private String pAccount;
  private String pPresent;
  private String pPostcode;
  private String pEmail;
  private long state;


  public long getPId() {
    return pId;
  }

  public void setPId(long pId) {
    this.pId = pId;
  }


  public String getPAttribute() {
    return pAttribute;
  }

  public void setPAttribute(String pAttribute) {
    this.pAttribute = pAttribute;
  }


  public long getPAreaId() {
    return pAreaId;
  }

  public void setPAreaId(long pAreaId) {
    this.pAreaId = pAreaId;
  }


  public String getPAreaName() {
    return pAreaName;
  }

  public void setPAreaName(String pAreaName) {
    this.pAreaName = pAreaName;
  }


  public String getPName() {
    return pName;
  }

  public void setPName(String pName) {
    this.pName = pName;
  }


  public String getPShortName() {
    return pShortName;
  }

  public void setPShortName(String pShortName) {
    this.pShortName = pShortName;
  }


  public String getPMessagerPhone() {
    return pMessagerPhone;
  }

  public void setPMessagerPhone(String pMessagerPhone) {
    this.pMessagerPhone = pMessagerPhone;
  }


  public String getPMessageName() {
    return pMessageName;
  }

  public void setPMessageName(String pMessageName) {
    this.pMessageName = pMessageName;
  }


  public String getPAddress() {
    return pAddress;
  }

  public void setPAddress(String pAddress) {
    this.pAddress = pAddress;
  }


  public String getPBank() {
    return pBank;
  }

  public void setPBank(String pBank) {
    this.pBank = pBank;
  }


  public String getPAccount() {
    return pAccount;
  }

  public void setPAccount(String pAccount) {
    this.pAccount = pAccount;
  }


  public String getPPresent() {
    return pPresent;
  }

  public void setPPresent(String pPresent) {
    this.pPresent = pPresent;
  }


  public String getPPostcode() {
    return pPostcode;
  }

  public void setPPostcode(String pPostcode) {
    this.pPostcode = pPostcode;
  }


  public String getPEmail() {
    return pEmail;
  }

  public void setPEmail(String pEmail) {
    this.pEmail = pEmail;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
