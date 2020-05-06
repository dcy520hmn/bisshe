package com.keji.controller.repository;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.repository.GoodStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RestController
@RequestMapping("/goodStockInfo")
public class GoodStockInfoController extends BaseController {

    @Autowired
    private GoodStockInfoService goodsRepositoryService;


    @RequestMapping("/query")
    public String  queryGoodsRepositoryInfo(@RequestBody Map params){
        PageInfo<GoodStockInfo> pageInfo = goodsRepositoryService.queryGoodsRepository(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    @RequestMapping(value = "/queryGoodsRepositoryByEmp")
    public String queryGoodsRepositoryByEmp(@RequestParam Map params){
        GoodStockInfo goodStockInfo = goodsRepositoryService.queryGoodsRepositoryByUser(params);
        return dealQueryResult(goodStockInfo,goodStockInfo);
    }
}
