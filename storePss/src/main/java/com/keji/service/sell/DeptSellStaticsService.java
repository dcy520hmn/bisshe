package com.keji.service.sell;

import com.keji.pojo.sell.SellOrderStaticsRet;

import java.util.List;
import java.util.Map;

public interface DeptSellStaticsService {

    List<SellOrderStaticsRet> queryDeptSellStatics(Map params);
}
