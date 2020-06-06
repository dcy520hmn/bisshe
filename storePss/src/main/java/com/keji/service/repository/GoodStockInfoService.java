package com.keji.service.repository;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.stock.GoodStockInfo;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface GoodStockInfoService {
    PageInfo<GoodStockInfo> queryGoodsRepository(Map params);


    int queryGoodsRepositoryByUser(Map params);
}
