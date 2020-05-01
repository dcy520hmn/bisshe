package com.keji.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.repository.GoodStockInfoMapper;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.repository.GoodStockInfoService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Service
public class GoodStockInfoServiceImpl implements GoodStockInfoService {

    @Autowired
    private GoodStockInfoMapper goodsRepositoryInfoMapper;

    @Override
    public PageInfo<GoodStockInfo> queryGoodsRepository(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        Integer rId = MapUtils.getIntValue(params, "rId");
        Integer posId = MapUtils.getIntValue(params, "posId");
        String gName = MapUtils.getString(params, "gName");
        Integer gooId = MapUtils.getInteger(params, "gooId");
        String gHelpName = MapUtils.getString(params, "gHelpName");
        Integer selectStockState = MapUtils.getInteger(params, "selectStockState");
        Page<GoodStockInfo> GoodsRepositoryInfoPage =  goodsRepositoryInfoMapper.findGoodStockInfo(rId, posId,gooId,gName,gHelpName,selectStockState);
        PageInfo<GoodStockInfo> pageInfo = new PageInfo<>(GoodsRepositoryInfoPage);
        return pageInfo;
    }
}
