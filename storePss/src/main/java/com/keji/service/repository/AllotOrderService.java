package com.keji.service.repository;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.pojo.stock.AllotOrder;

import java.util.List;
import java.util.Map;

public interface AllotOrderService {

     int insertAllot(Map params);

     PageInfo<AllotOrder> queryAllotOrder(Map params);

     int deleteAllotOrder(String[] ids);

     int updatePurchaseOrder(Map  params);

     int updatePurchaseOrderState(Map params);

}
