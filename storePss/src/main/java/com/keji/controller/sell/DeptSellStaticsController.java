package com.keji.controller.sell;

import com.keji.common.web.BaseController;
import com.keji.pojo.sell.SellOrderStaticsRet;
import com.keji.service.sell.DeptSellStaticsService;
import com.keji.service.sell.SellOrderStaticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deptSellStatics")
public class DeptSellStaticsController extends BaseController {

    @Autowired
    private DeptSellStaticsService deptSellStaticsService;

    @RequestMapping("/query")
    public String querySellOrderStatics(@RequestBody Map params) {
        List<SellOrderStaticsRet> ret = deptSellStaticsService.queryDeptSellStatics(params);
        return dealQueryResult(ret, ret);
    }

}
