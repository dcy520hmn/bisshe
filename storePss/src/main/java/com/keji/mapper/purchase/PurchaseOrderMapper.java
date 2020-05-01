package com.keji.mapper.purchase;

import com.github.pagehelper.Page;
import com.keji.pojo.purchase.PurchaseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Repository
public interface PurchaseOrderMapper extends Mapper<PurchaseOrder> {

    /**
     *
     * @param orderId 订单 id
     * @param state 状态
     * @param orderType 订单类型
     * @param myselfId 是否查询自己的订单
     * @return
     */
    Page<PurchaseOrder> queryPurchaseOrder(@Param("orderId") String orderId,
                                           @Param("orderState") Integer state,
                                           @Param("orderType") Integer orderType,
                                           @Param("myselfId") Integer myselfId);

    //添加订单
    int insertPurchaseOrder(@Param("purchaseOrder") PurchaseOrder purchaseOrder);

    //更新订单状态
    int updatePurchaseOrderState(@Param("orderId") String orderId,@Param("orderState") Integer state);
}
