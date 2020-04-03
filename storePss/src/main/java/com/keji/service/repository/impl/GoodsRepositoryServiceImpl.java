package com.keji.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.repository.GoodsRepositoryInfoMapper;
import com.keji.pojo.repository.GoodRepositoryInfo;
import com.keji.service.repository.GoodsRepositoryService;
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
public class GoodsRepositoryServiceImpl implements GoodsRepositoryService {

    @Autowired
    private GoodsRepositoryInfoMapper goodsRepositoryInfoMapper;

    @Override
    public PageInfo<GoodRepositoryInfo> queryGoodsRepository(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        Integer rId = MapUtils.getIntValue(params, "rId");
        Integer posId = MapUtils.getIntValue(params, "posId");
        String gName = MapUtils.getString(params, "gName");
        String gHelpName = MapUtils.getString(params, "gHelpName");
        Page<GoodRepositoryInfo> GoodsRepositoryInfoPage =  goodsRepositoryInfoMapper.findGoodsRepositoryInfo(rId, posId,gName,gHelpName);
        PageInfo<GoodRepositoryInfo> pageInfo = new PageInfo<>(GoodsRepositoryInfoPage);
        return pageInfo;
    }
}
