package com.keji.controller.purchase;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.service.purcahse.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController extends BaseController {
    @Autowired
    private PurchaseOrderService durchaseOrderServiceService;

    @RequestMapping("/findAllPurchaseOrder")
    public String queryAllPurchaseOrder(){
//        List<PurchaseOrder> ret = durchaseOrderServiceService.queryAllPurchaseOrder();
//        return dealQueryResult(ret,ret);
        return null;
    }

    @RequestMapping("/findPurchaseOrder")
    public String findPurchaseOrder(@RequestBody Map params){
        PageInfo<PurchaseOrder> pageInfo = durchaseOrderServiceService.queryPurchaseOrder(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    /**
     * 增加商品信息
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Map params){
        int ret =  durchaseOrderServiceService.updatePurchaseOrder(params);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改商品信息
     * @param purchaseOrder
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody PurchaseOrder purchaseOrder){
        int ret =  durchaseOrderServiceService.updatePurchaseOrder(purchaseOrder);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret =  durchaseOrderServiceService.deletePurchaseOrder(ids);
        return dealQueryResult(ret,ret);
    }
}
