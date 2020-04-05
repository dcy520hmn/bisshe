package com.keji.mapper.purchase;

import com.github.pagehelper.Page;
import com.keji.pojo.purchase.PurchaseOrder;
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
    Page<PurchaseOrder> queryPurchaseOrder();
}
