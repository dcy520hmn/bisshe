package com.keji.service.purcahse.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.DateUtil;
import com.keji.common.utils.MapUtil;
import com.keji.common.utils.OrderIdUtil;
import com.keji.mapper.baseMessage.RepositoryMapper;
import com.keji.mapper.purchase.PurchaseOrderDetailMapper;
import com.keji.mapper.purchase.PurchaseOrderMapper;
import com.keji.mapper.repository.GoodStockInfoMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.*;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.pojo.purchase.PurchaseOrderDetail;
import com.keji.pojo.stock.GoodStockInfo;
import com.keji.service.purcahse.PurchaseOrderService;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
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
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Autowired
    private GoodStockInfoMapper goodStockInfoMapper;

    @Override
    public PageInfo<PurchaseOrder> queryPurchaseOrder(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        String orderId = MapUtils.getString(params, "orderIdCondition");
        Integer orderState = MapUtils.getInteger(params, "selectOrderStateCondition");
        Integer orderType = MapUtils.getInteger(params, "orderType");
        Boolean isMySelf = MapUtils.getBoolean(params, "isMySelf");
        Integer myselfId = null;
        if(isMySelf!=null&&isMySelf){
            UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
            myselfId = userInfo.getEmpId();
        }
        Page<PurchaseOrder> purchaseOrderPage = purchaseOrderMapper.queryPurchaseOrder(orderId, orderState,orderType,myselfId);
        PageInfo<PurchaseOrder> purchaseOrderPageInfo = new PageInfo<>(purchaseOrderPage);
        return purchaseOrderPageInfo;
    }

    @Override
    public int insertPurchaseOrder(Map params) {
        int result = 0;
        try {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList();
            this.setPojo(params, purchaseOrder, purchaseOrderDetailList);
            purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailList) {
                purchaseOrderDetailMapper.insertPurchaseOrderDetail(purchaseOrderDetail);
            }
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }

        return result;
    }

    @Override
    public int deletePurchaseOrder(String[] ids) {
        int ret = -1;
        try {
            for (int i = 0; i < ids.length; i++) {
                purchaseOrderMapper.deleteByPrimaryKey(ids[i]);
            }
            ret = 1;
        } catch (Exception e) {
            e.printStackTrace();
            ret = -1;
        }
        return ret;
    }

    @Override
    public int updatePurchaseOrder(Map params) {
        //删除该订单的 所有订单详情
        Map orderMap = new HashMap();
        orderMap.put("pageNum", 1);
        orderMap.put("pageSize", 10);
        orderMap.put("orderIdCondition", MapUtils.getString(params, "id"));
        orderMap.put("orderType", MapUtils.getString(params, "type"));
        PageInfo<PurchaseOrder> orderPageInfo = this.queryPurchaseOrder(orderMap);
        PurchaseOrder purchaseOrderSystem = orderPageInfo.getList().get(0);
        List<PurchaseOrderDetail> purchaseOrderDetailListSystem = purchaseOrderSystem.getPurchaseOrderDetailList();
        for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailListSystem) {
            purchaseOrderDetailMapper.deleteByPrimaryKey(purchaseOrderDetail);
        }
        //重新添加、更新订单信息
        int ret = -1;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList();
        this.setPojo(params, purchaseOrder, purchaseOrderDetailList);
        try {
            purchaseOrderMapper.updateByPrimaryKey(purchaseOrder);
            //重新增加订单详情
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailList) {
                purchaseOrderDetailMapper.insertPurchaseOrderDetail(purchaseOrderDetail);
            }
            ret = 1;
        } catch (Exception e) {
            e.printStackTrace();
            ret = 0;
        }
        return ret;
    }

    @Override
    public int updatePurchaseOrderState(Map params) {
        String orderId = MapUtils.getString(params,"orderId");
        Integer orderState = MapUtils.getInteger(params,"orderState");
        return purchaseOrderMapper.updatePurchaseOrderState(orderId,orderState);
    }


    /**
     * 订单处理完成
     * @param params
     * @return
     */
    @Override
    public int orderOver(Map params) {
        int ret = -1;
        try{
            //查询对应的订单
            Map orderMap = new HashMap();
            orderMap.put("pageNum", 1);
            orderMap.put("pageSize", 10);
            orderMap.put("orderIdCondition", MapUtils.getString(params, "id"));
            orderMap.put("selectOrderStateCondition", MapUtils.getString(params, "selectOrderStateCondition"));
            orderMap.put("orderType", MapUtils.getString(params, "orderType"));
            PageInfo<PurchaseOrder> orderPageInfo = this.queryPurchaseOrder(orderMap);
            //遍历订单详情
            PurchaseOrder purchaseOrderSystem = orderPageInfo.getList().get(0);
            List<PurchaseOrderDetail> purchaseOrderDetailListSystem = purchaseOrderSystem.getPurchaseOrderDetailList();
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailListSystem) {
                //进行入库操作
                Page<GoodStockInfo>  goodStockInfoPage = goodStockInfoMapper.findGoodStockInfo(purchaseOrderDetail.getRepository().getId(),null,purchaseOrderDetail.getGood().getId(),null,null,null);
                GoodStockInfo  goodStockInfo = goodStockInfoPage.getResult().get(0);
                if(purchaseOrderSystem.getType()==0){//进货订单
                    goodStockInfo.setNumber(goodStockInfo.getNumber()+purchaseOrderDetail.getGooNum());
                    goodStockInfoMapper.updateStock(goodStockInfo.getId(),goodStockInfo.getRepository().getId(),goodStockInfo.getGood().getId(),goodStockInfo.getNumber());
                }else if(purchaseOrderSystem.getType()==1){//退货订单
                    goodStockInfo.setNumber(goodStockInfo.getNumber()-purchaseOrderDetail.getGooNum());
                    goodStockInfoMapper.updateStock(goodStockInfo.getId(),goodStockInfo.getRepository().getId(),goodStockInfo.getGood().getId(),goodStockInfo.getNumber());
                }
            }
            //订单完成
            ret = 1;
            purchaseOrderMapper.updatePurchaseOrderState(purchaseOrderSystem.getId(),1);
        }catch (Exception e){
            ret = -1;
            e.printStackTrace();
        }
        return ret;
    }


    /**
     * @param params                  前端传来参数
     * @param purchaseOrder           订单
     * @param purchaseOrderDetailList 订单明细集合
     */
    private void setPojo(Map params, PurchaseOrder purchaseOrder, List purchaseOrderDetailList) {
        String orderId = MapUtils.getString(params, "id");
        if (orderId == null || orderId == "") {
            orderId = OrderIdUtil.getId();
        }

        purchaseOrder.setId(orderId);
        purchaseOrder.setType(MapUtils.getInteger(params, "type"));
        purchaseOrder.setCreateDate(DateUtil.getCurrentDateTime());
        if(purchaseOrder.getType()==1){
            purchaseOrder.setSate(2);
        }else{
            purchaseOrder.setSate(-1);
        }
        TProvider provider = new TProvider();

        //设置供应商
        Map providerMap = MapUtils.getMap(params, "provider");
        Integer pId = MapUtils.getInteger(providerMap, "id");
        provider.setId(pId);
        purchaseOrder.setProvider(provider);
        purchaseOrder.setProviderId(pId);

        //设置经手人
        Emp operationEmp = new Emp();
        Map operationEmpMap = MapUtils.getMap(params, "operationEmp");
        operationEmp.setId(MapUtils.getInteger(operationEmpMap, "id"));
        purchaseOrder.setOperationEmp(operationEmp);
        purchaseOrder.setoEmpId(operationEmp.getId());

        purchaseOrder.setPrice(MapUtils.getInteger(params, "price"));
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        //创建人
        Emp createEmp = new Emp();
        createEmp.setId(userInfo.getEmpId());
        purchaseOrder.setCreateEmp(createEmp);
        purchaseOrder.setRemark(MapUtils.getString(params, "remark"));
        purchaseOrder.setcEmpId(createEmp.getId());

        //设置订单详情
        List purchaseOrderDetailListMap = (ArrayList) MapUtils.getObject(params, "purchaseOrderDetailList");
        for (int i = 0; i < purchaseOrderDetailListMap.size(); i++) {
            Map ret = (Map) purchaseOrderDetailListMap.get(i);
            PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
            purchaseOrderDetail.setTpoId(orderId);
            //设置库存信息
            Map repositoryMap = (Map) ret.get("repository");
            Repository repository = new Repository();
            repository.setId(MapUtils.getInteger(repositoryMap, "id"));
            purchaseOrderDetail.setRepository(repository);
            //设置商品信息
            Map goodMap = (Map) ret.get("good");
            Good good = new Good();
            good.setId(MapUtils.getInteger(goodMap, "id"));
            purchaseOrderDetail.setGood(good);

            purchaseOrderDetail.setGooNum(MapUtils.getInteger(ret, "gooNum"));
            purchaseOrderDetail.setGooTax(MapUtils.getDouble(ret, "gooTax"));
            purchaseOrderDetail.setGooTaxPrc(MapUtils.getDouble(ret, "gooTaxPrc"));
            purchaseOrderDetail.setGooOtherPrice(MapUtils.getDouble(ret, "gooOtherPrice"));
            purchaseOrderDetail.setGooTotalPrice(MapUtils.getDouble(ret, "gooTotalPrice"));
            purchaseOrderDetail.setGooRemark(MapUtils.getString(ret, "gooRemark"));
            purchaseOrderDetailList.add(purchaseOrderDetail);
        }
    }


}
