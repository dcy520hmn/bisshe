package com.keji.pojo.sell;

import com.keji.common.utils.DateUtil;
import com.keji.pojo.baseMessage.Emp;
import lombok.Cleanup;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_sell_order")
public class SellOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_sid")
    private  String id;
    @Column(name = "t_create_date")
    private Date createDate;
    @Column(name = "t_totalNum")
    private Double totalNum;
    @Column(name = "t_empId")
    private Integer empId;
    @Column(name = "t_deptId")
    private Integer deptId;

    @Transient
    private String createDateStr;
    @Transient
    private Emp emp;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
        setCreateDateStr(DateUtil.dateToString(this.createDate,DateUtil.DATETIMEPATTERN24H));
    }

    public Double getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Double totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
