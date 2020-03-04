package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.Order;
import com.keji.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.calendar.BaseCalendar;

import javax.annotation.Resource;

/**
 * @author 李天笑
 * @date 2019/9/10 15:25
 */
@RestController
@RequestMapping("/refundController")
public class RefundController extends BaseController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/findRefundOrder")
    public String findRefundOrder(String orderId){
        Order order= orderService.findRefundOrder(orderId);
        String result =dealQueryResult(order,order);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/delOrder")
    public String delOrder(String orderId){
        orderService.delOrder(orderId);
        return dealSuccessResutl("删除成功",null);
    }
}
