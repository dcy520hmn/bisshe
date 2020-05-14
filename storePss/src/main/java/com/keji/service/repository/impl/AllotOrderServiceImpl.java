package com.keji.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.DateUtil;
import com.keji.common.utils.OrderIdUtil;
import com.keji.mapper.purchase.PurchaseOrderDetailMapper;
import com.keji.mapper.repository.AllotOrderDetailMapper;
import com.keji.mapper.repository.AllotOrderMapper;
import com.keji.mapper.repository.GoodStockInfoMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.pojo.purchase.PurchaseOrderDetail;
import com.keji.pojo.stock.AllotOrder;
import com.keji.pojo.stock.AllotOrderDetail;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.repository.AllotOrderService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AllotOrderServiceImpl implements AllotOrderService {

    @Autowired
    private AllotOrderMapper allotOrderMapper;

    @Autowired
    private AllotOrderDetailMapper allotOrderDetailMapper;

    @Autowired
    private GoodStockInfoMapper goodStockInfoMapper;

    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Override
    public PageInfo<AllotOrder> queryAllotOrder(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        String orderId = MapUtils.getString(params, "orderIdCondition");
        Integer orderState = MapUtils.getInteger(params, "selectOrderStateCondition");
        Boolean isMySelf = MapUtils.getBoolean(params, "isMySelf");
        Integer myselfId = null;
        if(isMySelf!=null&&isMySelf){
            UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
            myselfId = userInfo.getEmpId();
        }
        Page<AllotOrder> allotOrderPage = allotOrderMapper.queryAllotOrder(orderId,orderState,myselfId);
        PageInfo<AllotOrder> allotOrderPageInfo = new PageInfo<>(allotOrderPage);
        return allotOrderPageInfo;
    }

    @Override
    public int insertAllot(Map params) {
        int ret = -1;
        try{
            AllotOrder allotOrder = new AllotOrder();
            List<AllotOrderDetail> allotOrderDetailList = new ArrayList<>();
            //设置pojo
            SetAllotPojo(params,allotOrder,allotOrderDetailList);
            allotOrderMapper.insert(allotOrder);
            for (AllotOrderDetail allotOrderDetail : allotOrderDetailList) {
                allotOrderDetailMapper.insert(allotOrderDetail);
            }
            ret =  1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int updatePurchaseOrder(Map params) {
        int ret = -1;
        try{
            AllotOrder allotOrder = new AllotOrder();
            List<AllotOrderDetail> allotOrderDetailList = new ArrayList<>();
            //设置pojo
            SetAllotPojo(params,allotOrder,allotOrderDetailList);
            allotOrderMapper.updateByPrimaryKey(allotOrder);
            for (AllotOrderDetail allotOrderDetail : allotOrderDetailList) {
                allotOrderDetailMapper.updateByPrimaryKey(allotOrderDetail);
            }
            ret =  1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int deleteAllotOrder(String[] ids) {
        int ret = -1;
        try {
            for (int i = 0; i < ids.length; i++) {
                allotOrderMapper.deleteByPrimaryKey(ids[i]);
            }
            ret = 1;
        } catch (Exception e) {
            e.printStackTrace();
            ret = -1;
        }
        return ret;
    }



    @Override
    public int updatePurchaseOrderState(Map params) {
        int ret = -1;
        try{
            //查询对应的订单
            Map orderMap = new HashMap();
            orderMap.put("pageNum", 1);
            orderMap.put("pageSize", 10);
            orderMap.put("orderIdCondition", MapUtils.getString(params, "id"));
            PageInfo<AllotOrder> orderPageInfo = this.queryAllotOrder(orderMap);
            //遍历订单详情
            AllotOrder allotOrderSystem = orderPageInfo.getList().get(0);
            List<AllotOrderDetail> allotOrderDetailListSystem = allotOrderSystem.getAllotOrderDetail();

            for (AllotOrderDetail allotOrderDetail : allotOrderDetailListSystem) {
                //进行出入库操作
                Page<GoodStockInfo>  outRep = goodStockInfoMapper.findGoodStockInfo(allotOrderSystem.getOutRepId(),null,allotOrderDetail.getGood().getId(),null,null,null);
                Page<GoodStockInfo>  inRep = goodStockInfoMapper.findGoodStockInfo(allotOrderSystem.getInRepId(),null,allotOrderDetail.getGood().getId(),null,null,null);
                List<GoodStockInfo> outRepList = outRep.getResult();
                List<GoodStockInfo> inRepList = inRep.getResult();

                //调出仓库库存减少
                GoodStockInfo  outGoodStockInfo = outRepList.get(0);
                outGoodStockInfo.setNumber(outGoodStockInfo.getNumber()-allotOrderDetail.getGooNum());
                goodStockInfoMapper.updateStock(outGoodStockInfo.getId(),outGoodStockInfo.getRepository().getId(),outGoodStockInfo.getGood().getId(),outGoodStockInfo.getNumber());
                if(inRepList.size() <=0 ){//不存在商品信息，向库存中添加该商品
                    GoodStockInfo goodStockInfo = new GoodStockInfo();
                    goodStockInfo.setGooId(allotOrderDetail.getGood().getId());
                    goodStockInfo.setNumber(allotOrderDetail.getGooNum());
                    goodStockInfo.setRepId(allotOrderSystem.getInRepId());
                    goodStockInfo.setPosId(-1);
                    goodStockInfoMapper.insert(goodStockInfo);
                }else{//库存数量调整
                    GoodStockInfo  inGoodStockInfo = inRepList.get(0);
                    inGoodStockInfo.setNumber(inGoodStockInfo.getNumber()+allotOrderDetail.getGooNum());
                    goodStockInfoMapper.updateStock(inGoodStockInfo.getId(),inGoodStockInfo.getRepository().getId(),inGoodStockInfo.getGood().getId(),inGoodStockInfo.getNumber());
                }
            }
            allotOrderSystem.setState(1);
            allotOrderMapper.updateByPrimaryKey(allotOrderSystem);
            ret = 1;
        }catch (Exception e){
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 设置pojo
     */
    private void SetAllotPojo(Map params,AllotOrder allotOrder,List<AllotOrderDetail> allotOrderDetailList){
        String id = MapUtils.getString(params,"id");
        if(!StringUtils.isNotEmpty(id)){
            id = OrderIdUtil.getId();
        }
        allotOrder.setId(id);
        allotOrder.setInDeptId(MapUtils.getInteger(params,"inDeptId"));
        allotOrder.setOutDeptId(MapUtils.getInteger(params,"outDeptId"));
        allotOrder.setInRepId(MapUtils.getInteger(params,"inRepId"));
        allotOrder.setOutRepId(MapUtils.getInteger(params,"outRepId"));
        allotOrder.setEmpId(MapUtils.getInteger(params,"empId"));
        allotOrder.setState(0);
        allotOrder.setCreateDate(DateUtil.getCurrentDateTime());
        allotOrder.setRemark(MapUtils.getString(params,"remark"));
        List<LinkedMap> allotOrderDetailMapList = (List) MapUtils.getObject(params,"allotOrderDetail");
        for (Map allotOrderDetailMap : allotOrderDetailMapList) {
            AllotOrderDetail allotOrderDetail = new AllotOrderDetail();
            Map goodMap =  MapUtils.getMap(allotOrderDetailMap,"good");
            Integer gooId = MapUtils.getInteger(goodMap,"id");
            String detailId  = MapUtils.getString(allotOrderDetailMap,"id");
            if(detailId != null && !detailId.equals("")){
                allotOrderDetail.setId(Integer.parseInt(detailId));
            }
            allotOrderDetail.setAoId(id);
            allotOrderDetail.setGooId(gooId);
            allotOrderDetail.setGooNum(MapUtils.getInteger(allotOrderDetailMap,"gooNum"));
            allotOrderDetail.setRemark(MapUtils.getString(allotOrderDetailMap,"remark"));
            allotOrderDetailList.add(allotOrderDetail);
        }
    }

}
