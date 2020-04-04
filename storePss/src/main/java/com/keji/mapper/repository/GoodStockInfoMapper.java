package com.keji.mapper.repository;

import com.github.pagehelper.Page;
import com.keji.pojo.stock.GoodStockInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Repository
public interface GoodStockInfoMapper {
    Page<GoodStockInfo>  findGoodStockInfo(@Param("rId") Integer rId,
                                           @Param("posId")Integer posId,
                                           @Param("gName") String gName,
                                           @Param("gHelpName") String gHelpName,
                                           @Param("selectStockState") Integer selectStockState);
}
