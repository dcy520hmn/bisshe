package com.keji.service.repository;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.repository.GoodRepositoryInfo;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface GoodsRepositoryService {
    PageInfo<GoodRepositoryInfo> queryGoodsRepository(Map params);
}
