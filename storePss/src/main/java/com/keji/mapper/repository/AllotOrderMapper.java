package com.keji.mapper.repository;

import com.github.pagehelper.Page;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.pojo.stock.AllotOrder;
import com.keji.pojo.stock.GoodStockInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AllotOrderMapper extends Mapper<AllotOrder> {
    /**
     *
     * @param orderId 订单 id
     * @param state 状态
     * @param myselfId 是否查询自己的订单
     * @return
     */
    Page<AllotOrder> queryAllotOrder(@Param("orderId") String orderId,
                                           @Param("orderState") Integer state,
                                           @Param("myselfId") Integer myselfId);
}
