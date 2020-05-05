package com.keji.controller.sell;

import com.keji.common.web.BaseController;
import com.keji.service.sell.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sellOrder")
public class SellOrderController extends BaseController {

    @Autowired
    private SellOrderService sellOrderService;

    @RequestMapping("/insert")
    public String insertSellOrder(@RequestBody Map params){
        int ret = sellOrderService.insertSellOrder(params);
        return dealQueryResult(ret,ret);
    }
}
