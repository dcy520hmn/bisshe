package com.keji.controller;


import com.keji.common.utils.OrderCodeFactory;
import com.keji.common.web.BaseController;
import com.keji.pojo.*;
import com.keji.service.CustomerService;
import com.keji.service.OrderService;
import com.keji.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * @author 李天笑
 * @date 2019/9/8 15:41
 * 订单类
 */

@RestController
@RequestMapping("/orderController")
public class OrderController extends BaseController {

    @Resource
    private CustomerService customerService;

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    /**
     * 生成订单顺便添加用户
     * @param name
     * @param phone
     * @param select
     * @param json
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(String name, String phone, int select, String [] json){
        Object o = SecurityUtils.getSubject().getPrincipal();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        //shiro获取登录用户
        Order order = new Order();

        /**
         * 添加用户
         */
        //-------------------
        order.setOrderCusId(1);
        Customer customer=new Customer();
        customer.setCustomerCreatDate(new Date());
        customer.setCustomerSex("1");
        customer.setCustomerName(name);
        customer.setCustomerTelephone(phone);
        if(customerService.findCustPhone(phone).size()>0){
            order.setOrderCusId(customerService.findCustPhone(phone).get(0).getCustomerId());
            System.out.println("用户已经存在无需添加");
        }else {
            customerService.addCustomer(customer);
            order.setOrderCusId(customerService.findCustPhone(phone).get(0).getCustomerId());
        }
        //查询客户id
        // spring security获取登录用户
        UserInfo user = userService.findUserByUserName(userInfo.getUserName());
        //添加员工编号
        order.setOrderEmpId(user.getId());
        //生成订单编号
        String orderId= OrderCodeFactory.getOrderCode((long)user.getId());
        System.out.println("订单编号"+orderId);
        //添加订单编号
        order.setOrderId(orderId);
        //添加订单创建日期
        order.setOrderCreateDate(new Date());
        /**
         * 李天专属自制批量上传数据
         * */
        String str="";
        for(int i=0;i<json.length;i++){
            str+=json[i]+",";
        }
        System.out.println(str);
        String subData = str.substring(str.indexOf("[") + 1, str.lastIndexOf("],"));
        System.out.println(subData);
        String upData= subData.replaceAll("},\\{","}!{");
        System.out.println(upData);
        String [] arr =upData.split("!");
       /* for(int i=0;i<arr.length;i++){
            System.out.println("这是"+arr[i]);
            JSONObject jsonObject = JSONObject.parseObject(arr[i]);
            Set<Map.Entry<String,Object>> set=jsonObject.entrySet();
            Iterator<Map.Entry<String,Object>> iterator= set.iterator();
                while(iterator.hasNext()){
                    Map.Entry<String,Object> map=iterator.next();
                    //System.out.println(map.getKey()+" "+map.getValue());
                }
        }*/
        orderService.addOrder(arr,order,select);
        System.out.println(dealQueryResult(orderId,orderId));
        return dealQueryResult(orderId,orderId);
    }


    @RequestMapping("/updateYaJin")
    public String updateYaJin(int yajin,String orderId){
        int row= orderService.updateOrder(yajin,orderId);
        System.out.println(row);
        return dealSuccessResutl("修改成功",null);
    }

    @RequestMapping("/findOrder")
    public String findOrder(String orderId){
        List<Order> list= orderService.findOrder(orderId);
        String result= dealQueryResult(list,list);
        System.out.println(result);
        return result;
    }
}
