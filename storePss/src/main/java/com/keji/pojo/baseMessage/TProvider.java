package com.keji.pojo.baseMessage;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_provider")
@Data
public class TProvider implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String attribute;
  private long areaId;
  private String areaName;
  private String name;
  private String shortName;
  private String messagePhone;
  private String messageName;
  private String address;
  private String bank;
  private String account;
  private String present;
  private String postcode;
  private String email;
  private long state;

}
