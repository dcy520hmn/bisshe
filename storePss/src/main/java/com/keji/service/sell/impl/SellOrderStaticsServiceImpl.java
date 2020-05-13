package com.keji.service.sell.impl;

import com.keji.mapper.sell.SellOrderStaticsMapper;
import com.keji.pojo.sell.SellOrderStatics;
import com.keji.pojo.sell.SellOrderStaticsRet;
import com.keji.service.sell.SellOrderStaticsService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SellOrderStaticsServiceImpl implements SellOrderStaticsService {

    @Autowired
    private SellOrderStaticsMapper sellOrderStaticsMapper;

    @Override
    public List<SellOrderStaticsRet> querySellOrderStatics(Map params) {
        Integer deptId = MapUtils.getInteger(params,"deptId");
        Integer empId =  MapUtils.getInteger(params,"empId");
        String beginDate =  MapUtils.getString(params,"beginDate");
        String endDate =  MapUtils.getString(params,"endDate");
        List<SellOrderStatics> midRet = sellOrderStaticsMapper.querySellOrderStatics(deptId,empId,beginDate,endDate);
        Map<Integer,List<SellOrderStatics>> retMap = midRet.stream().collect(Collectors.groupingBy(SellOrderStatics::getEmpId));
        List<SellOrderStaticsRet> ret = new ArrayList<>();//最终结果
        for (Map.Entry<Integer,List<SellOrderStatics>> retMidMap : retMap.entrySet()){//遍历每个员工
            SellOrderStaticsRet sellOrderStaticsRet = new SellOrderStaticsRet();//最终结果的状态：姓名、当月销售业绩数组。
            List<SellOrderStatics> sellOrderStaticsList = retMidMap.getValue();//该员工当月销售有业绩
            String empName = null;
            double[] totalNumOfMonth = new double[31];
            //当月销售业绩
            for (SellOrderStatics sellOrderStatics : sellOrderStaticsList) {//遍历每个员工的每天的销售业绩
                Date data = sellOrderStatics.getCreateDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(data);
                Integer month  = calendar.get(Calendar.DATE);
                for (int i = 0; i < totalNumOfMonth.length; i++) {//设置每天的销售有业绩。没有销售则为0；
                    if(i == month-1){
                        totalNumOfMonth[i] = sellOrderStatics.getTotalNum();
                    }
                }
                empName  = sellOrderStatics.getEmpName();
            }
            sellOrderStaticsRet.setTotalNumOfMonth(totalNumOfMonth);
            sellOrderStaticsRet.setName(empName);
            ret.add(sellOrderStaticsRet);
        }
        return ret;
    }

}
