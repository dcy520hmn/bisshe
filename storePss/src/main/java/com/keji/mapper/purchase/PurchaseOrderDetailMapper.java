package com.keji.mapper.purchase;

import com.keji.pojo.purchase.PurchaseOrderDetail;
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
public interface PurchaseOrderDetailMapper extends Mapper<PurchaseOrderDetail> {
    int insertPurchaseOrderDetail(@Param("purchaseOrderDetail")  PurchaseOrderDetail purchaseOrderDetail);
}
