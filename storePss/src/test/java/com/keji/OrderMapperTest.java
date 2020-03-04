package com.keji;


import com.keji.mapper.OrderMapper;
import com.keji.mapper.ProductMapper;
import com.keji.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dcy
 * @date 2019/8/27 19:19
 * @description 订单测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StorePssApplication.class)
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;


    @Test
    public void testFindUserByUserName() {
        System.out.println(orderMapper.addOrder(new Order("120190909114004157917793", 1, new BigDecimal(99), 0, new Date(), new Date(), 0, 0, 0, null, null)));
    }

    @Test
    public void t() {
        System.out.println(orderMapper.findOrder("120190909114004157917793"));
    }

    @Test
    public void tt(){
        System.out.println(orderMapper.findRefundOrder("120190909123839978917794"));
    }

}
