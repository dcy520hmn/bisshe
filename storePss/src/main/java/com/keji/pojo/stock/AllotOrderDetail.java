package com.keji.pojo.stock;

import com.keji.common.utils.DateUtil;
import com.keji.pojo.baseMessage.Dept;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Repository;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_allot_order_detail")
public class AllotOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_aodId")
    private  Integer id;

    @Column(name = "t_aoid")
    private String aoId;

    @Column(name = "t_gooId")
    private Integer gooId;

    @Column(name = "t_gooNum")
    private Integer gooNum;

    @Column(name = "t_remark")
    private String remark;

    @Transient
    private Good good;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAoId() {
        return aoId;
    }

    public void setAoId(String aoId) {
        this.aoId = aoId;
    }

    public Integer getGooId() {
        return gooId;
    }

    public void setGooId(Integer gooId) {
        this.gooId = gooId;
    }

    public Integer getGooNum() {
        return gooNum;
    }

    public void setGooNum(Integer gooNum) {
        this.gooNum = gooNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
