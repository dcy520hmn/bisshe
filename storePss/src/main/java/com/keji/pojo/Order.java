package com.keji.pojo;

/**
 * @author 李天笑
 * @date 2019/9/7 17:03
 * 订单表
 */

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    //订单编号
    private String orderId;
    //客户编号（引用（t_customer表）cus_id）
    private Integer orderCusId;
    //总金额
    private BigDecimal orderAggregateAmount;
    //员工编号（引用（t_emp表）emp_id）
    private Integer orderEmpId;
    //创建日期
    private Date orderCreateDate;
    //修改日期
    private Date orderUpdateDate;
    //（状态）是否已删除，取值为0和1默认为0。
    private int orderState;
    //是否已交押金，取值为0和1默认为0
    private int orderDeposit;
    //是否已交全款，取值为0和1默认为0 当交完全款以后表示订单完成
    private int orderFullPayment;
    //备注
    private String orderRemark;
    //押金
    private BigDecimal orderCashPledge;

    private Customer customer=new Customer();

    private UserInfo userInfo=new UserInfo();


    public Order() {
    }

    public Order(String orderId, Integer orderCusId, BigDecimal orderAggregateAmount, Integer orderEmpId, Date orderCreateDate, Date orderUpdateDate, int orderState, int orderDeposit, int orderFullPayment, String orderRemark, BigDecimal orderCashPledge) {
        this.orderId = orderId;
        this.orderCusId = orderCusId;
        this.orderAggregateAmount = orderAggregateAmount;
        this.orderEmpId = orderEmpId;
        this.orderCreateDate = orderCreateDate;
        this.orderUpdateDate = orderUpdateDate;
        this.orderState = orderState;
        this.orderDeposit = orderDeposit;
        this.orderFullPayment = orderFullPayment;
        this.orderRemark = orderRemark;
        this.orderCashPledge = orderCashPledge;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderCusId() {
        return orderCusId;
    }

    public void setOrderCusId(Integer orderCusId) {
        this.orderCusId = orderCusId;
    }

    public BigDecimal getOrderAggregateAmount() {
        return orderAggregateAmount;
    }

    public void setOrderAggregateAmount(BigDecimal orderAggregateAmount) {
        this.orderAggregateAmount = orderAggregateAmount;
    }

    public Integer getOrderEmpId() {
        return orderEmpId;
    }

    public void setOrderEmpId(Integer orderEmpId) {
        this.orderEmpId = orderEmpId;
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

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getOrderDeposit() {
        return orderDeposit;
    }

    public void setOrderDeposit(int orderDeposit) {
        this.orderDeposit = orderDeposit;
    }

    public int getOrderFullPayment() {
        return orderFullPayment;
    }

    public void setOrderFullPayment(int orderFullPayment) {
        this.orderFullPayment = orderFullPayment;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public BigDecimal getOrderCashPledge() {
        return orderCashPledge;
    }

    public void setOrderCashPledge(BigDecimal orderCashPledge) {
        this.orderCashPledge = orderCashPledge;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderCusId=" + orderCusId +
                ", orderAggregateAmount=" + orderAggregateAmount +
                ", orderEmpId=" + orderEmpId +
                ", orderCreateDate=" + orderCreateDate +
                ", orderUpdateDate=" + orderUpdateDate +
                ", orderState=" + orderState +
                ", orderDeposit=" + orderDeposit +
                ", orderFullPayment=" + orderFullPayment +
                ", orderRemark='" + orderRemark + '\'' +
                ", orderCashPledge=" + orderCashPledge +
                ", customer=" + customer +
                ", userInfo=" + userInfo +
                '}';
    }
}
