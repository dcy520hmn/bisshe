package com.keji.pojo.sell;

import com.keji.common.utils.DateUtil;

import java.util.Date;

public class DeptSellStatics {
    private Double totalNum;
    private String deptName;
    private String everyTimeStr;
    private Date everyTime;
    private Integer deptId;

    public String getEveryTimeStr() {
        return everyTimeStr;
    }

    public void setEveryTimeStr(String everyTimeStr) {
        this.everyTimeStr = everyTimeStr;
        this.setEveryTime(DateUtil.stringToDate(everyTimeStr,"yyyyMM"));
    }

    public Double getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Double totalNum) {
        this.totalNum = totalNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getEveryTime() {
        return everyTime;
    }

    public void setEveryTime(Date everyTime) {
        this.everyTime = everyTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
