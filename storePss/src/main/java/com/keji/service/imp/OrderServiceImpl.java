package com.keji.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.keji.mapper.OrderDetailMapper;
import com.keji.mapper.OrderMapper;
import com.keji.mapper.RepositoryMapper;
import com.keji.pojo.Batch;
import com.keji.pojo.Order;
import com.keji.pojo.OrderDetail;
import com.keji.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 李天笑
 * @date 2019/9/9 8:42
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RepositoryMapper repositoryMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int addOrder(String [] arr, Order order, int select) {
        BigDecimal bigDecimal=new BigDecimal(0);
        Batch batch=new Batch();
        int cont=4;
        for(int i=0;i<arr.length;i++) {
            JSONObject jsonObject = JSONObject.parseObject(arr[i]);
            Set<Map.Entry<String, Object>> set = jsonObject.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            System.out.println(set);
            while (iterator.hasNext()) {
                cont++;
                Map.Entry<String, Object> map = iterator.next();
                System.out.println(map.getKey() + " " + map.getValue());
                if (cont % 4 != 0) {
                    if (map.getKey().equals("productId")) {
                        batch.setProductId(String.valueOf(map.getValue()));
                    }
                    if (map.getKey().equals("num")) {
                        batch.setNum(Integer.parseInt((String) map.getValue()));
                    }
                    if (map.getKey().equals("productPrice")) {
                        batch.setProductPrice(new BigDecimal((int) map.getValue()));
                    }
                } else {
                    //修改库存
                    repositoryMapper.updateQuantity(batch.getNum(), batch.getProductId());
                    //增加详情订单
                    orderDetailMapper.addOrderDetail(new OrderDetail(order.getOrderId(), batch.getProductId(), batch.getProductPrice(), new BigDecimal(select), batch.getNum(), null, new Date(), null, null));
                    bigDecimal = bigDecimal.add(new BigDecimal(batch.getNum()).multiply(batch.getProductPrice()));
                    batch = new Batch();
                    if (map.getKey().equals("productId")) {
                        batch.setProductId(String.valueOf(map.getValue()));
                    }
                    if (map.getKey().equals("num")) {
                        batch.setNum(Integer.parseInt((String) map.getValue()));
                    }
                    if (map.getKey().equals("productPrice")) {
                        batch.setProductPrice(new BigDecimal((int) map.getValue()));
                    }
                }
            }
        }
        System.out.println(bigDecimal);
        order.setOrderAggregateAmount(bigDecimal);
        if(select!=0){
            order.setOrderDeposit(0);
            order.setOrderFullPayment(1);
            order.setOrderCashPledge(new BigDecimal(select));
        }else {
            order.setOrderDeposit(1);
            order.setOrderFullPayment(1);
            order.setOrderCashPledge(new BigDecimal(0));
        }
        System.out.println(order);
        return orderMapper.addOrder(order);
    }

    @Override
    public int updateOrder(int yajin, String orderId) {
        return orderMapper.updateOrder(yajin,orderId);
    }

    @Override
    public List<Order> findOrder(String orderId) {
        return orderMapper.findOrder(orderId);
    }

    @Override
    public int updateFullPayment(String orderId) {
        return orderMapper.updateFullPayment(orderId);
    }

    @Override
    public Order findRefundOrder(String orderId) {
        return orderMapper.findRefundOrder(orderId);
    }

    @Override
    public int delOrder(String orderId) {
        orderDetailMapper.delOrderDetail(orderId);
        return orderMapper.delOrder(orderId);
    }
}
