package com.keji.pojo.purchase;

import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Repository;

import javax.persistence.*;

@Table(name = "t_purchase_order_detail")
public class PurchaseOrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tpod_id")
  private Integer id;

  @Column(name = "tpo_id")
  private String tpoId;

  @Column(name = "tpod_gooNum")
  private Integer gooNum;
  @Column(name = "tpod_gooTax")
  private Double gooTax;
  @Column(name = "tpod_gooTaxPrc")
  private Double gooTaxPrc;
  @Column(name = "tpod_gooOtherPrice")
  private Double gooOtherPrice;
  @Column(name = "tpod_gooTotalPrice")
  private Double gooTotalPrice;
  @Column(name = "tpod_gooRemark")
  private String gooRemark;
  @Column(name = "tpod_rId")
  private Integer rId;
  @Column(name = "tpod_gooId")
  private Integer gooId;

  @Transient
  private Repository repository;
  @Transient
  private Good good;


  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public Integer getGooId() {
    return gooId;
  }

  public void setGooId(Integer gooId) {
    this.gooId = gooId;
  }

  public Repository getRepository() {
    return repository;
  }

  public void setRepository(Repository repository) {
    this.repository = repository;
  }

  public Good getGood() {
    return good;
  }

  public void setGood(Good good) {
    this.good = good;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTpoId() {
    return tpoId;
  }

  public void setTpoId(String tpoId) {
    this.tpoId = tpoId;
  }

  public Integer getGooNum() {
    return gooNum;
  }

  public void setGooNum(Integer gooNum) {
    this.gooNum = gooNum;
  }


  public Double getGooTax() {
    return gooTax;
  }

  public void setGooTax(Double gooTax) {
    this.gooTax = gooTax;
  }


  public Double getGooTaxPrc() {
    return gooTaxPrc;
  }

  public void setGooTaxPrc(Double gooTaxPrc) {
    this.gooTaxPrc = gooTaxPrc;
  }


  public Double getGooOtherPrice() {
    return gooOtherPrice;
  }

  public void setGooOtherPrice(Double gooOtherPrice) {
    this.gooOtherPrice = gooOtherPrice;
  }


  public Double getGooTotalPrice() {
    return gooTotalPrice;
  }

  public void setGooTotalPrice(Double gooTotalPrice) {
    this.gooTotalPrice = gooTotalPrice;
  }


  public String getGooRemark() {
    return gooRemark;
  }

  public void setGooRemark(String gooRemark) {
    this.gooRemark = gooRemark;
  }

}
