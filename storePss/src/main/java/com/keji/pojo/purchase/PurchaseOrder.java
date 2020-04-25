package com.keji.pojo.purchase;


import com.keji.common.utils.DateUtil;
import com.keji.pojo.baseMessage.Emp;
import com.keji.pojo.baseMessage.TProvider;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.keji.pojo.baseMessage.TProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Table(name = "t_purchase_order")
public class PurchaseOrder {
  @Column(name = "tpo_Id")
  private String id;

  @Column(name = "tpo_CreateDate")
  private Date createDate;

  @Column(name = "tpo_Price")
  private Double price;

  @Column(name = "tpo_Remark")
  private String remark;

  @Column(name = "tpo_Sate")
  private Integer sate;

  @Transient
  private TProvider provider;
  @Transient
  private Emp operationEmp;
  @Transient
  private Emp createEmp;
  @Transient
  private String createDateStr;
  @Transient
  private List<PurchaseOrderDetail> purchaseOrderDetailList;


  public TProvider getProvider() {
    return provider;
  }

  public void setProvider(TProvider provider) {
    this.provider = provider;
  }

  public Emp getOperationEmp() {
    return operationEmp;
  }

  public void setOperationEmp(Emp operationEmp) {
    this.operationEmp = operationEmp;
  }

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
    setCreateDateStr(DateUtil.dateToString(createDate,DateUtil.DATETIMEPATTERN24H));
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public Emp getCreateEmp() {
    return createEmp;
  }

  public void setCreateEmp(Emp createEmp) {
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
