package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.OrderDetail;
import com.keji.service.OrderDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/9 15:05
 */
@RestController
@RequestMapping("/orderDetailController")
public class OrderDetailController extends BaseController {

    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping("/findCustOrderDetail")
    public String findCustOrderDetail(String orderId){
        List<OrderDetail> list= orderDetailService.findCustOrderDetail(orderId);
        String result= dealQueryResult(list,list);
        System.out.println(result);
        return result;
    }
}
