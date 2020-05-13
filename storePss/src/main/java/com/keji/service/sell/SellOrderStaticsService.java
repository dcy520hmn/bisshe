package com.keji.service.sell;

import com.keji.pojo.sell.SellOrderStatics;
import com.keji.pojo.sell.SellOrderStaticsRet;

import java.util.List;
import java.util.Map;

public interface SellOrderStaticsService {

    List<SellOrderStaticsRet> querySellOrderStatics(Map params);
}
