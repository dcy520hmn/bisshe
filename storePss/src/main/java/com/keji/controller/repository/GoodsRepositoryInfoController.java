package com.keji.controller.repository;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.repository.GoodRepositoryInfo;
import com.keji.service.repository.GoodsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RequestMapping("/goodsRepositoryInfo")
public class GoodsRepositoryInfoController extends BaseController {

    @Autowired
    private GoodsRepositoryService goodsRepositoryService;


    @RequestMapping("/query")
    public String  queryGoodsRepositoryInfo(@RequestBody Map params){
        PageInfo<GoodRepositoryInfo> pageInfo = goodsRepositoryService.queryGoodsRepository(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

}
