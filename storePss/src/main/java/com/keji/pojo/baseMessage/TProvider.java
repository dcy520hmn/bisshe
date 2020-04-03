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

}
