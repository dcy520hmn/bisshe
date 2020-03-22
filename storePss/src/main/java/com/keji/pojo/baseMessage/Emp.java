package com.keji.pojo.baseMessage;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_emp")
public class Emp {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;
  private String name;
  private String gender;
  private Date birthday;
  private String identity;
  private String phone;
  private String address;
  @Column(name = "areaCode")
  private String areaCode;
  @Column(name = "hiredate")
  private Date hireDate;
  @Column(name = "deptId")
  private long deptId;
  private Double salary;
  private long sate;

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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public long getSate() {
    return sate;
  }

  public void setSate(long sate) {
    this.sate = sate;
  }
}
