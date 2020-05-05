package com.keji.pojo.baseMessage;

import javax.persistence.*;

@Table(name = "t_repository")
public class Repository {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rId")
  private Integer id;
  @Column(name = "rName")
  private String name;
  @Column(name = "rCode")
  private String code;
  @Column(name = "rRemark")
  private String remark;
  @Column(name = "state")
  private Integer state;
  @Column(name = "deptId")
  private Integer deptId;

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

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
