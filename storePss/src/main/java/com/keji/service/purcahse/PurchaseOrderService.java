package com.keji.service.purcahse;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.purchase.PurchaseOrder;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface PurchaseOrderService {

    PageInfo<PurchaseOrder> queryPurchaseOrder(Map params);

    int insertPurchaseOrder(Map  params);

    int deletePurchaseOrder(Integer[] id);

    int updatePurchaseOrder(PurchaseOrder good);
}
