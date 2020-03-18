package com.keji.pojo.baseMessage;


import lombok.Data;

import javax.persistence.*;

@Table(name = "t_goods")
public class Good {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String helpNum;
  @Column(name = "class")
  private String gClass;
  private String className;
  private String type;
  private String size;
  private String name;
  private String unit;
  private Integer max;
  private Integer min;
  private Integer prePrice;
  private Double cost;
  private Integer remark;
  private long state;
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getHelpNum() {
    return helpNum;
  }

  public void setHelpNum(String helpNum) {
    this.helpNum = helpNum;
  }

  public String getgClass() {
    return gClass;
  }

  public void setgClass(String gClass) {
    this.gClass = gClass;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }

  public Integer getPrePrice() {
    return prePrice;
  }

  public void setPrePrice(Integer prePrice) {
    this.prePrice = prePrice;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Integer getRemark() {
    return remark;
  }

  public void setRemark(Integer remark) {
    this.remark = remark;
  }

  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }
}
