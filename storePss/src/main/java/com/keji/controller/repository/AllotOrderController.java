package com.keji.controller.repository;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.common.web.BaseController;
import com.keji.pojo.stock.AllotOrder;
import com.keji.service.repository.AllotOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/allotOrder")
public class AllotOrderController extends BaseController {

    @Autowired
    private AllotOrderService allotOrderService;

    @RequestMapping("/insert")
    public String insertAllot(@RequestBody Map params){
        int ret = allotOrderService.insertAllot(params);
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/query")
    public String queryAllot(@RequestBody Map params){
        PageInfo<AllotOrder> ret = allotOrderService.queryAllotOrder(params);
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/delete")
    public String deleteAllot(@RequestBody String[] ids){
        int ret =  allotOrderService.deleteAllotOrder(ids);
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/update")
    public String updateAllot(@RequestBody Map params){
        int ret =  allotOrderService.updatePurchaseOrder(params);
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/deal")
    public String dealAllot(@RequestBody Map params){
        int ret =  allotOrderService.updatePurchaseOrderState(params);
        return dealQueryResult(ret,ret);
    }

}
