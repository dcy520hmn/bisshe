package com.keji.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.baseMessage.EmpMapper;
import com.keji.mapper.repository.GoodStockInfoMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.Emp;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Repository;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.baseMessage.GoodService;
import com.keji.service.baseMessage.RepositoryService;
import com.keji.service.repository.GoodStockInfoService;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private GoodService goodService;
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

    /**
     * 查询员工搜在部门某商品的库存信息
     * @param params
     * @return
     */
    @Override
    public GoodStockInfo queryGoodsRepositoryByUser(Map params) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Emp emp = empMapper.findUserByConditions(null,userInfo.getEmpId()).get(0);
        Map reMap = new LinkedHashMap();
        reMap.put("pageNum",1);
        reMap.put("pageSize",10);
        reMap.put("deptId",emp.getDeptId());
        Repository repository = repositoryService.queryRepository(reMap).getList().get(0);
        String helpNum = MapUtils.getString(params,"helpNum");
        Integer rId = repository.getId();
        Page<GoodStockInfo> goodStockInfoPage = goodsRepositoryInfoMapper.findGoodStockInfo(rId,
                null,null,null,helpNum,null);
        GoodStockInfo  goodStockInfo = goodStockInfoPage.getResult().get(0);
        return goodStockInfo;
    }
}
