package com.keji.pojo.baseMessage;

import javax.persistence.*;

@Table(name = "t_repository")
public class Repository {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rId")
  private long id;
  @Column(name = "rName")
  private String name;
  @Column(name = "rCode")
  private String code;
  @Column(name = "rRemark")
  private String remark;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
