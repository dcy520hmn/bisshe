package com.keji.mapper.sell;

import com.keji.pojo.sell.SellOrderStatics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellOrderStaticsMapper {
    List<SellOrderStatics> querySellOrderStatics(Integer deptId,Integer empId,String beginDate,String endDate);
}
