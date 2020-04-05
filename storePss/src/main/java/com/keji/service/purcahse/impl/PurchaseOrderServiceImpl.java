package com.keji.service.purcahse.impl;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.service.purcahse.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Override
    public PageInfo<PurchaseOrder> queryPurchaseOrder(Map params) {
        return null;
    }

    @Override
    public int insertPurchaseOrder(PurchaseOrder PurchaseOrder) {
        return 0;
    }

    @Override
    public int deletePurchaseOrder(Integer[] id) {
        return 0;
    }

    @Override
    public int updatePurchaseOrder(PurchaseOrder good) {
        return 0;
    }
}
