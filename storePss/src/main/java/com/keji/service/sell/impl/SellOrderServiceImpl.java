package com.keji.service.sell.impl;

import com.github.pagehelper.Page;
import com.keji.common.utils.DateUtil;
import com.keji.common.utils.OrderIdUtil;
import com.keji.mapper.baseMessage.EmpMapper;
import com.keji.mapper.repository.GoodStockInfoMapper;
import com.keji.mapper.sell.SellOrderDetailMapper;
import com.keji.mapper.sell.SellOrderMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.Emp;
import com.keji.pojo.baseMessage.Repository;
import com.keji.pojo.sell.SellOrder;
import com.keji.pojo.sell.SellOrderDetail;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.baseMessage.EmpService;
import com.keji.service.baseMessage.RepositoryService;
import com.keji.service.sell.SellOrderService;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellOrderServiceImpl implements SellOrderService {

    @Autowired
    private SellOrderMapper sellOrderMapper;
    @Autowired
    private SellOrderDetailMapper sellOrderDetailMapper;
    @Autowired
    private GoodStockInfoMapper goodStockInfoMapper;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private EmpMapper empMapper;
    //新增销售订单
    @Override
    public int insertSellOrder(Map params) {
        int ret =  -1;
        try{
            //设置订单
            SellOrder sellOrder = new SellOrder();
            String orderId = OrderIdUtil.getId();
            sellOrder.setId(orderId);
            sellOrder.setCreateDate(DateUtil.getCurrentDateTime());
            sellOrder.setTotalNum(MapUtils.getDouble(params,"totalNum"));
            //查询对应的用户
            UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
            Emp emp = empMapper.findUserByConditions(null,userInfo.getEmpId()).get(0);
            //增加订单
            sellOrder.setEmpId(userInfo.getEmpId());
            sellOrder.setDeptId(emp.getDept().getId());
            sellOrderMapper.insert(sellOrder);
            //设置订单详情。
            List<Map> allGoods = (List<Map>) params.get("sellOrder");
            for (Map allGood : allGoods) {
                SellOrderDetail sellOrderDetail = new SellOrderDetail();
                sellOrderDetail.setGooId(MapUtils.getInteger(allGood,"id"));
                sellOrderDetail.setOrderId(orderId);
                sellOrderDetail.setSellNum(MapUtils.getInteger(allGood,"buyNum"));
                sellOrderDetail.setTotalNum(MapUtils.getDouble(allGood,"prePrice")*MapUtils.getInteger(allGood,"buyNum"));
                sellOrderDetailMapper.insert(sellOrderDetail);
                //更新仓库库存信息。
                Map reMap = new LinkedHashMap();
                reMap.put("pageNum",1);
                reMap.put("pageSize",10);
                reMap.put("deptId",emp.getDeptId());
                Repository repository = repositoryService.queryRepository(reMap).getList().get(0);
                Page<GoodStockInfo> goodStockInfoPage = goodStockInfoMapper.findGoodStockInfo(repository.getId(),null,MapUtils.getInteger(allGood,"id"),null,null,null);
                GoodStockInfo  goodStockInfo = goodStockInfoPage.getResult().get(0);
                goodStockInfo.setNumber(goodStockInfo.getNumber()-MapUtils.getInteger(allGood,"buyNum"));
                goodStockInfoMapper.updateStock(goodStockInfo.getId(),goodStockInfo.getRepository().getId(),goodStockInfo.getGood().getId(),goodStockInfo.getNumber());
            }
            ret = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

}
