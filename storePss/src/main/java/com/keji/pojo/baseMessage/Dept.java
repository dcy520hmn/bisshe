package com.keji.pojo.baseMessage;

import javax.persistence.*;

@Table(name = "t_dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptId")
    private Integer id;

    @Column(name = "deptName")
    private String deptName;

    @Column(name = "deptAddress")
    private String deptAddress;

    @Column(name = "deptAreaCode")
    private String areaCode;

    @Column(name = "deptAreaName")
    private String deptAreaName;
    private Integer state;


    public String getDeptAreaName() {
        return deptAreaName;
    }

    public void setDeptAreaName(String deptAreaName) {
        this.deptAreaName = deptAreaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
