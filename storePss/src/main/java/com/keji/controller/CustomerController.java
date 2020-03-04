package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.CustomerMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Dept;
import com.keji.service.CustomerService;
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
 * @program: sale
 * @description: 客户表现层
 * @author: lxh
 * @create: 2019-09-08 09:45
 **/

@RestController
@RequestMapping("/customerController")
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询所有客户信息
     * @return
     */
    @RequestMapping("/findAllCustomer")
    public String findAllCustomer(int page) {
        PageInfo<Customer> customerPageInfo  = customerService.findAllCustomer(page,5);
        String customer = dealQueryResult(customerPageInfo, customerPageInfo);
        return customer;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(Customer customer, Principal principal,String BirthdayDate)throws ParseException {
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/

        //将前端页面的日期转储进数据库要进行的日期转换
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = format.parse(BirthdayDate);
        customer.setCustomerDate(date);
        int row=customerService.addCustomer(customer);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }
@PostMapping("/findCustomerById")
    public String findCustomerById(int customerId){
        Customer customer=customerMapper.findCustomerById(customerId);
        String json=dealQueryResult(customer,customer);
        return json;
    }

    @PostMapping("/updateCustomerById")
   public String updateCustomerById(Customer customer){
        int row=customerMapper.updateCustomerById(customer);
       if(row==0){
           return dealSuccessResutl("修改信息失败",null);
       }
       return dealSuccessResutl("修改信息成功",null);
   }

   @PostMapping("/deleteCustomerById")
    public String deleteCustomerById(int customerId){
        int row=customerMapper.delCustomerById(customerId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }
}
