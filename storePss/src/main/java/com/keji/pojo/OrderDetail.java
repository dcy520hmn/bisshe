package com.keji.pojo;

/**
 * @author 李天笑
 * @date 2019/9/7 19:09
 * 订单详情
 */


import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private String orderId;
    private String orderGooId;
    private BigDecimal orderPrice;
    private BigDecimal orderPiscounts;
    private int orderAmount;
    private String orderRemark;
    private Date orderCreateDate;
    private Date orderUpdateDate;
    private Integer orderModifier;
    private Order order=new Order();
    private Product product=new Product();


    public OrderDetail(String orderId, String orderGooId, BigDecimal orderPrice, BigDecimal orderPiscounts, int orderAmount, String orderRemark, Date orderCreateDate, Date orderUpdateDate, Integer orderModifier) {
        this.orderId = orderId;
        this.orderGooId = orderGooId;
        this.orderPrice = orderPrice;
        this.orderPiscounts = orderPiscounts;
        this.orderAmount = orderAmount;
        this.orderRemark = orderRemark;
        this.orderCreateDate = orderCreateDate;
        this.orderUpdateDate = orderUpdateDate;
        this.orderModifier = orderModifier;
    }



    public OrderDetail() {
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderGooId() {
        return orderGooId;
    }

    public void setOrderGooId(String orderGooId) {
        this.orderGooId = orderGooId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderPiscounts() {
        return orderPiscounts;
    }

    public void setOrderPiscounts(BigDecimal orderPiscounts) {
        this.orderPiscounts = orderPiscounts;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public Date getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(Date orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }

    public Integer getOrderModifier() {
        return orderModifier;
    }

    public void setOrderModifier(Integer orderModifier) {
        this.orderModifier = orderModifier;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", orderGooId='" + orderGooId + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderPiscounts=" + orderPiscounts +
                ", orderAmount=" + orderAmount +
                ", orderRemark='" + orderRemark + '\'' +
                ", orderCreateDate=" + orderCreateDate +
                ", orderUpdateDate=" + orderUpdateDate +
                ", orderModifier=" + orderModifier +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
