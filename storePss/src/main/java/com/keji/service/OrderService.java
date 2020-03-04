package com.keji.service;

import com.keji.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 李天笑
 * @date 2019/9/9 8:42
 * 订单业务层
 */
public interface OrderService {
    /**
     * 添加订单
     */
    /**
     *
     * @param arr 保存批量数据的数组
     * @param order 订单
     * @return
     */
    int addOrder(String [] arr, Order order, int select);

    /**
     * 修改押金
     * @param yajin
     * @param orderId
     * @return
     */
    int updateOrder(int yajin,String orderId);

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    List<Order> findOrder(String orderId);

    /**
     * 修改订单为全款
     */
    int updateFullPayment(String orderId);

    /**
     * 查询售后订单
     * @param orderId
     * @return
     */
    Order findRefundOrder(String orderId);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int delOrder(String orderId);
}
