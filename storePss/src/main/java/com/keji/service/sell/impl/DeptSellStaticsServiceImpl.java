package com.keji.service.sell.impl;

import com.keji.mapper.sell.DeptSellStaticsMapper;
import com.keji.pojo.sell.DeptSellStatics;
import com.keji.pojo.sell.SellOrderStaticsRet;
import com.keji.service.sell.DeptSellStaticsService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeptSellStaticsServiceImpl implements DeptSellStaticsService {

    @Autowired
    private DeptSellStaticsMapper deptSellStaticsMapper;

    @Override
    public List<SellOrderStaticsRet> queryDeptSellStatics(Map params) {
        Integer deptId = MapUtils.getInteger(params,"deptId");
        String year =  MapUtils.getString(params,"year");
        List<DeptSellStatics> midRet = deptSellStaticsMapper.queryDeptSellStatics(deptId,year);
        Map<Integer,List<DeptSellStatics>> retMap = midRet.stream().collect(Collectors.groupingBy(DeptSellStatics::getDeptId));
        List<SellOrderStaticsRet> ret = new ArrayList<>();//最终结果
        for (Map.Entry<Integer,List<DeptSellStatics>> retMidMap : retMap.entrySet()){//遍历每个员工
            SellOrderStaticsRet deptSellStaticsRet = new SellOrderStaticsRet();//最终结果的状态：姓名、当月销售业绩数组。
            List<DeptSellStatics> DeptSellStaticsList = retMidMap.getValue();//该员工当月销售有业绩
            String deptName = null;
            double[] totalNumOfYear = new double[12];
            //当月销售业绩
            for (DeptSellStatics midDeptSellStatics : DeptSellStaticsList) {//遍历每个员工的每天的销售业绩
                Date data = midDeptSellStatics.getEveryTime();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(data);
                Integer month  = calendar.get(Calendar.MONTH);
                for (int i = 0; i < totalNumOfYear.length; i++) {//设置每天的销售有业绩。没有销售则为0；
                    if(i == month){
                        totalNumOfYear[i] = midDeptSellStatics.getTotalNum();
                    }
                }
                deptName  = midDeptSellStatics.getDeptName();
            }
            deptSellStaticsRet.setTotalNumOfMonth(totalNumOfYear);
            deptSellStaticsRet.setName(deptName);
            ret.add(deptSellStaticsRet);
        }
        return ret;
    }

}
