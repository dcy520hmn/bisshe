package com.keji.service.purcahse.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.DateUtil;
import com.keji.common.utils.MapUtil;
import com.keji.common.utils.OrderIdUtil;
import com.keji.mapper.purchase.PurchaseOrderDetailMapper;
import com.keji.mapper.purchase.PurchaseOrderMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.*;
import com.keji.pojo.purchase.PurchaseOrder;
import com.keji.pojo.purchase.PurchaseOrderDetail;
import com.keji.service.purcahse.PurchaseOrderService;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
    private PurchaseOrderMapper purchaseOrderMapper ;

    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Override
    public PageInfo<PurchaseOrder> queryPurchaseOrder(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Page<PurchaseOrder> purchaseOrderPage = purchaseOrderMapper.queryPurchaseOrder();
        PageInfo<PurchaseOrder> purchaseOrderPageInfo = new PageInfo<>(purchaseOrderPage);
        return purchaseOrderPageInfo;
    }

    @Override
    public int insertPurchaseOrder(Map  params) {
        int result = 0;
        try{
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            String orderId = OrderIdUtil.getId();
            purchaseOrder.setId(orderId);
            purchaseOrder.setCreateDate(DateUtil.getCurrentDateTime());
            TProvider provider = new TProvider();
            //设置供应商
            Map providerMap = MapUtils.getMap(params,"provider");
            provider.setId(MapUtils.getInteger(providerMap,"id"));
            purchaseOrder.setProvider(provider);
            //设置经手人
            Emp operationEmp = new Emp();
            Map operationEmpMap = MapUtils.getMap(params,"operationEmp");
            operationEmp.setId(MapUtils.getInteger(operationEmpMap,"id"));
            purchaseOrder.setOperationEmp(operationEmp);

            purchaseOrder.setPrice(MapUtils.getInteger(params,"price"));
            UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
            Emp createEmp = new Emp();
            createEmp.setId(userInfo.getEmpId());
            purchaseOrder.setCreateEmp(createEmp);
            purchaseOrder.setRemark(MapUtils.getString(params,"remark"));
            purchaseOrder.setSate(0);
            purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);

            List purchaseOrderDetailList = (ArrayList)MapUtils.getObject(params,"purchaseOrderDetailList");
            for (int i = 0; i < purchaseOrderDetailList.size(); i++) {
                Map ret = (Map)purchaseOrderDetailList.get(i);
                PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
                purchaseOrderDetail.setId(orderId);
                //设置库存信息
                Map repositoryMap = (Map) ret.get("repository");
                Repository repository = new Repository();
                repository.setId(MapUtils.getInteger(repositoryMap,"id"));
                purchaseOrderDetail.setRepository(repository);
                //设置商品信息
                Map goodMap = (Map)ret.get("good");
                Good good = new Good();
                good.setId(MapUtils.getInteger(goodMap,"id"));
                purchaseOrderDetail.setGood(good);

                purchaseOrderDetail.setGooNum(MapUtils.getInteger(ret,"gooNum"));
                purchaseOrderDetail.setGooTax(MapUtils.getDouble(ret,"gooTax"));
                purchaseOrderDetail.setGooTaxPrc(MapUtils.getDouble(ret,"gooTaxPrc"));
                purchaseOrderDetail.setGooOtherPrice(MapUtils.getDouble(ret,"gooOtherPrice"));
                purchaseOrderDetail.setGooTotalPrice(MapUtils.getDouble(ret,"gooTotalPrice"));
                purchaseOrderDetail.setGooRemark(MapUtils.getString(ret,"gooRemark"));
                purchaseOrderDetailMapper.insertPurchaseOrderDetail(purchaseOrderDetail);
            }
            result =  1;
        }catch (Exception e){
            e.printStackTrace();
            result = 0;
        }

        return result;
    }

    @Override
    public int deletePurchaseOrder(Integer[] id) {
        return 0;
    }

    @Override
    public int updatePurchaseOrder(PurchaseOrder good) {
        return 0;
    }
}
