package com.keji.pojo.baseMessage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keji.pojo.authority.Role;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Table(name = "t_emp")
public class Emp {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;
  private String name;
  private String gender;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy年MM月dd日", timezone = "GMT+8")
  private Date birthday;
  private String identity;
  private String phone;
  private String address;
  @Column(name = "areaCode")
  private String areaCode;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy年MM月dd日", timezone = "GMT+8")
  @Column(name = "hiredate")
  private Date hireDate;
  @Column(name = "deptId")
  private Integer deptId;
  private Double salary;
  private Integer state;

  @Transient
  private Dept dept;
  @Transient
  private List<Role> roleList;
  @Transient
  private String birthdayStr;
  @Transient
  private String hireDateStr;

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public String getBirthdayStr() {
    return birthdayStr;
  }

  public void setBirthdayStr(String birthdayStr) {
    this.birthdayStr = birthdayStr;
  }

  public String getHireDateStr() {
    return hireDateStr;
  }

  public void setHireDateStr(String hireDateStr) {
    this.hireDateStr = hireDateStr;
  }

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
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
    setBirthdayStr(new SimpleDateFormat("yyyy年MM月dd日").format(birthday));
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
    setHireDateStr(new SimpleDateFormat("yyyy年MM月dd日").format(hireDate));
  }

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Integer getstate() {
    return state;
  }

  public void setstate(Integer state) {
    this.state = state;
  }


}
