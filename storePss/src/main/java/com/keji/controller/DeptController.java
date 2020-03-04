package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.DeptMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Dept;
import com.keji.pojo.Position;
import com.keji.pojo.Supplier;
import com.keji.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

/**
 * @program: sale_System
 * @description: 部门表现层
 * @author: 李东升
 * @create: 2019-09-08 09:33
 **/
@RestController
@RequestMapping("/deptController")
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private  DeptMapper deptMapper;
    /**
     * 查询所有部门信息
     * @return
     */
    @RequestMapping("/findAllDepts")
    public String findAllDepts(int page) {
       PageInfo<Dept> deptPageInfo =deptService.findAllDepts(page,2);
       String dept =dealQueryResult(deptPageInfo,deptPageInfo);
       return dept;
    }

    @PostMapping("/addDept")
    public String addDept(Dept dept, Principal principal)throws ParseException {
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/
        int row=deptService.addDept(dept);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }

    /**
     * 根据id查找一条部门信息
     * @param deptId
     * @return
     */
    @PostMapping("/findDeptById")
    public String findDeptById(int deptId){
        Dept dept=deptMapper.findDeptById(deptId);
        String json = dealQueryResult(dept,dept);
        return json;
    }

    @PostMapping("/updateDeptById")
    public String updateDeptById(Dept dept){
        int row=deptMapper.updateDeptById(dept);
        if(row==0){
            return dealSuccessResutl("修改信息失败",null);
        }
        return dealSuccessResutl("修改信息成功",null);
    }
    @PostMapping("/deleteDeptById")
    public String deleteDeptById(int deptId){
        int row=deptMapper.deleteDeptById(deptId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);
    }


}
