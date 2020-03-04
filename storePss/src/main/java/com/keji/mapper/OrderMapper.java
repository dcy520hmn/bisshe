package com.keji.mapper;

import com.keji.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/7 17:12
 * 订单表接口
 */
@Mapper
public interface OrderMapper {
    /**
     * 获取所有订单
     * @return
     */
    List<Order> getAllOrder();


    /**
     * 添加订单
     */
    int addOrder(Order order);


    /**
     * 修改押金
     * @param yajin
     * @param orderId
     * @return
     */
    int updateOrder(@Param("yajin") int yajin,@Param("orderId") String orderId);


    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    List<Order> findOrder(@Param("orderId") String orderId);

    /**
     * 修改订单为全款
     */
    int updateFullPayment(@Param("orderId") String orderId);


    /**
     * 查询售后订单
     * @param orderId
     * @return
     */
    Order findRefundOrder(@Param("orderId")String orderId);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int delOrder(@Param("orderId")String orderId);
}
