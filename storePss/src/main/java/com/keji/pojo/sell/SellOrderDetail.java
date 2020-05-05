package com.keji.pojo.sell;

import com.keji.common.utils.DateUtil;
import com.keji.pojo.baseMessage.Emp;
import com.keji.pojo.baseMessage.Good;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Table(name = "t_sell_detail")
public class    SellOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_sdid")
    private Integer id;
    @Column(name = "t_sId")
    private String orderId;
    @Column(name = "t_s_gooId")
    private Integer gooId;
    @Column(name = "t_sNum")
    private Integer sellNum;
    @Column(name = "t_totalNum")
    private Double totalNum;

    @Transient
    private Good good;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGooId() {
        return gooId;
    }

    public void setGooId(Integer gooId) {
        this.gooId = gooId;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Double getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Double totalNum) {
        this.totalNum = totalNum;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

}
