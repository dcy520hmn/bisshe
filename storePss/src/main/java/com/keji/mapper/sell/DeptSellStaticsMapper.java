package com.keji.mapper.sell;

import com.keji.pojo.sell.DeptSellStatics;
import com.keji.pojo.sell.SellOrderStatics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptSellStaticsMapper {
    List<DeptSellStatics> queryDeptSellStatics(@Param("deptId") Integer deptId, @Param("year") String year);
}
