package com.keji.pojo.stock;

import com.keji.common.utils.DateUtil;
import com.keji.pojo.baseMessage.Dept;
import com.keji.pojo.baseMessage.Emp;
import com.keji.pojo.baseMessage.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_allot_order")
public class AllotOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_aoid")
    private  String id;

    @Column(name = "t_inDeptId")
    private Integer inDeptId;

    @Column(name = "t_outDeptId")
    private Integer outDeptId;

    @Column(name = "t_inRepId")
    private Integer inRepId;

    @Column(name = "t_outRepId")
    private Integer outRepId;

    @Column(name = "t_empId")
    private Integer empId;

    @Column(name = "t_state")
    private Integer state;

    @Column(name = "t_remark")
    private String remark;

    @Column(name = "t_create_date")
    private Date createDate;

    @Transient
    private String createDateStr;
    @Transient
    private Dept inDept;
    @Transient
    private Dept outDept;
    @Transient
    private Repository inRep;
    @Transient
    private Repository outRep;
    @Transient
    private Emp emp;
    @Transient
    private List<AllotOrderDetail> allotOrderDetail;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<AllotOrderDetail> getAllotOrderDetail() {
        return allotOrderDetail;
    }

    public void setAllotOrderDetail(List<AllotOrderDetail> allotOrderDetail) {
        this.allotOrderDetail = allotOrderDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInDeptId() {
        return inDeptId;
    }

    public void setInDeptId(Integer inDeptId) {
        this.inDeptId = inDeptId;
    }

    public Integer getOutDeptId() {
        return outDeptId;
    }

    public void setOutDeptId(Integer outDeptId) {
        this.outDeptId = outDeptId;
    }

    public Integer getInRepId() {
        return inRepId;
    }

    public void setInRepId(Integer inRepId) {
        this.inRepId = inRepId;
    }

    public Integer getOutRepId() {
        return outRepId;
    }

    public void setOutRepId(Integer outRepId) {
        this.outRepId = outRepId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        setCreateDateStr(DateUtil.dateToString(createDate,DateUtil.DATETIMEPATTERN24H));
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public Dept getInDept() {
        return inDept;
    }

    public void setInDept(Dept inDept) {
        this.inDept = inDept;
    }

    public Dept getOutDept() {
        return outDept;
    }

    public void setOutDept(Dept outDept) {
        this.outDept = outDept;
    }

    public Repository getInRep() {
        return inRep;
    }

    public void setInRep(Repository inRep) {
        this.inRep = inRep;
    }

    public Repository getOutRep() {
        return outRep;
    }

    public void setOutRep(Repository outRep) {
        this.outRep = outRep;
    }
}
