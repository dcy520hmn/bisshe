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
     * 增加订单信息
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Map params){
        int ret =  durchaseOrderServiceService.insertPurchaseOrder(params);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改订单信息
     * @param params
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody Map params ){
        int ret =  durchaseOrderServiceService.updatePurchaseOrder(params);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除订单信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody String[] ids){
        int ret =  durchaseOrderServiceService.deletePurchaseOrder(ids);
        return dealQueryResult(ret,ret);
    }

    /**
     * 更新订单的状态
     * @param params
     * @return
     */
    @RequestMapping("/updateState")
    public String updateState(@RequestBody Map params){
        int ret = durchaseOrderServiceService.updatePurchaseOrderState(params);
        return dealQueryResult(ret,ret);
    }

    /**
     * 处理完成订单进行入库
     * @param params
     * @return
     */
    @RequestMapping("/orderOver")
    public String orderOver(@RequestBody Map params){
        int ret = durchaseOrderServiceService.orderOver(params);
        return dealQueryResult(ret,ret);
    }

}
