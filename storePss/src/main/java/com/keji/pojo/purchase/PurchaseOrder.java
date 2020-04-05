package com.keji.pojo.purchase;


import com.keji.common.utils.DateUtil;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Table(name = "t_purchase_order")
public class PurchaseOrder {
  @Column(name = "tpoId")
  private Integer id;
  @Column(name = "tpoCreateDate")
  private Date createDate;
  @Column(name = "tpoProvider")
  private Integer provider;
  @Column(name = "tpoOperationEmp")
  private Integer operationEmp;
  @Column(name = "tpoPrice")
  private Double price;
  @Column(name = "tpoCreateEmp")
  private Integer createEmp;
  @Column(name = "tpoRemark")
  private String remark;
  @Column(name = "tpoSate")
  private Integer sate;

  @Transient
  private String createDateStr;
  @Transient
  private List<PurchaseOrderDetail> purchaseOrderDetailList;


  public String getCreateDateStr() {
    return createDateStr;
  }

  public void setCreateDateStr(String createDateStr) {
    this.createDateStr = createDateStr;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
    return purchaseOrderDetailList;
  }

  public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
    purchaseOrderDetailList = purchaseOrderDetailList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
    setCreateDateStr(DateUtil.dateToString(createDate,DateUtil.DATETIMEPATTERN24H));
  }


  public Integer getProvider() {
    return provider;
  }

  public void setProvider(Integer provider) {
    this.provider = provider;
  }


  public Integer getOperationEmp() {
    return operationEmp;
  }

  public void setOperationEmp(Integer operationEmp) {
    this.operationEmp = operationEmp;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public Integer getCreateEmp() {
    return createEmp;
  }

  public void setCreateEmp(Integer createEmp) {
    this.createEmp = createEmp;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public Integer getSate() {
    return sate;
  }

  public void setSate(Integer sate) {
    this.sate = sate;
  }

}
