package com.keji.controller.sell;

import com.keji.common.web.BaseController;
import com.keji.pojo.sell.SellOrderStatics;
import com.keji.pojo.sell.SellOrderStaticsRet;
import com.keji.service.sell.SellOrderStaticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sellOrderStatics")
public class SellOrderStaticsController extends BaseController {

    @Autowired
    private SellOrderStaticsService sellOrderStaticsService;

    @RequestMapping("/query")
    public String querySellOrderStatics(@RequestBody Map params) {
        List<SellOrderStaticsRet> ret = sellOrderStaticsService.querySellOrderStatics(params);
        return dealQueryResult(ret, ret);
    }

}
