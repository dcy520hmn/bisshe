package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.Dept;
import com.keji.pojo.Emp;
import com.keji.pojo.SalaryBills;
import com.keji.service.DeptService;
import com.keji.service.SalaryBillsService;
import com.keji.service.imp.SalaryBillsServiceImpl;
import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 成雨齐
 * @date 2019/9/8 11:27
 */
@RestController
@RequestMapping("/salary")
public class SalaryBillsController extends BaseController {
    SalaryBills salary = new SalaryBills();
    SalaryBills salaryBills2 = new SalaryBills();
    @Autowired
    private DeptService deptService;
    @Autowired
    private SalaryBillsService salaryBillsService;

    /**
     * 根据部门id查询出部门下的所有员工信息，包含绩效职务名称
     *  这些在底层进行了封装
     * @param deptId 部门编号
     * @param date 日期
     * @return
     */
    @RequestMapping("/findAllEmpByDeptId")
    public String findAllEmpByDeptId(Integer deptId,String date) throws ParseException {
         String[] da = date.split("-");
        String beginDate0 = da[0].replace("/","-");
        String endDate0 = da[1].replace("/","-");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date beginDate = simpleDateFormat.parse(beginDate0);
        Date endDate = simpleDateFormat.parse(endDate0);
         List<Emp> empList =  salaryBillsService.findTheDeptAllEmp(deptId,beginDate,endDate);
        return dealQueryResult(empList,empList);
    }

    /**
     * 查询部门信息用来渲染下拉框
     * @return
     */
    @RequestMapping("/getDeptName")
    public String getDeptNameList(){
       List<Dept> deptList =  deptService.findAllDepts(1,100).getList();
       return dealQueryResult(deptList,deptList);
    }

    /**
     *  向工资表中添加工资单
     * @param empNumber
     * @param empPosition
     * @param basicSalary
     * @param baoxian
     * @param jixiao
     * @param bonus
     * @param kuangGong
     * @param jiaBan
     * @param salaryBills
     * @param date
     * @throws ParseException
     */
    @RequestMapping("/addSalaryBills")
    public void addSalaryBills(
            Integer empNumber,String empPosition,BigDecimal basicSalary,
            BigDecimal baoxian,BigDecimal jixiao,BigDecimal bonus,Integer kuangGong,
            int jiaBan,BigDecimal salaryBills,String date   ) throws ParseException {
            String[] da = date.split("-");
            String beginDate0 = da[0].replace("/","-");
            String salaryData = beginDate0.substring(0,7);// 格式是 2019-9
             salary.setEmpNumber(empNumber);
             salary.setPositionName(empPosition);
             salary.setBasicSalary(basicSalary);
             salary.setInsurance(baoxian);
             salary.setPerformance(jixiao);
            salary.setBonus(bonus);
            salary.setLate(kuangGong);
            salary.setOverTime(jiaBan);
            salary.setSalary(salaryBills);
            salary.setData(salaryData);
            int rows =  salaryBillsService.addSalary(salary);

    }

    /**
     * 查询工资
     * @param empNumber
     * @param date
     * @return
     */
    @RequestMapping("/findSalaryBIllsByEmpId")
    public String findSalaryBills(Integer empNumber,String date){
        SalaryBills salaryBills =  salaryBillsService.findSalaryBillsByEmpId(empNumber,date);
        return dealQueryResult(salaryBills,salaryBills);
    }

    /**
     * 处理提交的有异议的工资单
     * @param empNumber
     * @param positionName
     * @param basicSalary
     * @param insurance
     * @param performance
     * @param bonus
     * @param late
     * @param overTime
     * @param salary
     * @param data2
     * @param yiyiText
     * @return
     */
    @RequestMapping("/yiyi")
    public String dealYiYi(
             Integer empNumber,
            String positionName,
            BigDecimal basicSalary,
           BigDecimal insurance,
            BigDecimal performance,
            BigDecimal bonus,
            Integer late,
           Integer overTime,
            BigDecimal salary,
           String data2,
            String yiyiText
    ){

        salaryBills2.setEmpNumber(empNumber);
        salaryBills2.setPositionName(positionName);
        salaryBills2.setBasicSalary(basicSalary);
        salaryBills2.setInsurance(insurance);
        salaryBills2.setPerformance(performance);
        salaryBills2.setBonus(bonus);
        salaryBills2.setLate(late);
        salaryBills2.setOverTime(overTime);
        salaryBills2.setSalary(salary);
        salaryBills2.setData(data2);
        salaryBills2.setYiyiText(yiyiText);
        return "提交成功！";
    }

    /**
     * 异议处理页面查询异议的 post 请求
     * @return 返回有争议的工资单信息
     */
    @RequestMapping("/findYiYi")
    public String  findYiYi(){
        return dealQueryResult(salaryBills2,salaryBills2);
    }
}
