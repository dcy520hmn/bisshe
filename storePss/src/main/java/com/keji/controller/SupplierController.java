package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.User;
import com.keji.common.web.BaseController;
import com.keji.mapper.SupplierMapper;
import com.keji.pojo.Product;
import com.keji.pojo.Supplier;
import com.keji.pojo.UserInfo;
import com.keji.service.SupplierService;
import com.keji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: sale_System
 * @description: 供货商表现层
 * @author: 李东升
 * @create: 2019-09-08 16:39
 **/
@RestController
@RequestMapping("/supplierController")
public class SupplierController extends BaseController {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllSuppliers")
    public String findAllSuppliers(int page){
        PageInfo<Supplier> pageInfo=supplierService.findAllSuppliers(page,2);
        String supplier =dealQueryResult(pageInfo,pageInfo);
        return supplier;
    }

    @PostMapping("/addAllSuppliers")
    public String addSuppliers(Supplier supplier, Principal principal/*,String supCreat,String supModifie*/) throws ParseException {
/*         String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        supplier.setSupModifier(user.getId());*/
//将前端页面的日期转储进数据库要进行的日期转换
/*        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = format.parse(supCreat);
        Date date1 = format.parse(supModifie);
        supplier.setSupCreatDate(date);
        supplier.setSupModifieDate(date1);*/
        int row = supplierService.addSupplier(supplier);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }

    @PostMapping("/findSupplierById")
    public String findSupById(int supId){
        Supplier supplier = supplierMapper.findSupplierById(supId);
        String json = dealQueryResult(supplier, supplier);
        return json;
    }

    @PostMapping("/updateSup")
    public String updateSup(Supplier supplier){
        int row = supplierService.updateSupplierById(supplier);
        if(row==0){
            return dealSuccessResutl("修改信息失败",null);
        }
        return dealSuccessResutl("修改信息成功",null);
    }

    @PostMapping("/deleteSupplierById")
    public String deleteSupplierById(int supId){
        int row=supplierMapper.deleteSupplierById(supId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }
}
