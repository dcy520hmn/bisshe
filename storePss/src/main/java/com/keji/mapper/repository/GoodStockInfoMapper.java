package com.keji.mapper.repository;

import com.github.pagehelper.Page;
import com.keji.pojo.stock.GoodStockInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Repository
public interface GoodStockInfoMapper extends Mapper<GoodStockInfo> {
    Page<GoodStockInfo>  findGoodStockInfo(@Param("rId") Integer rId,
                                           @Param("deptId") Integer deptId,
                                           @Param("posId")Integer posId,
                                           @Param("gooId")Integer gooId,
                                           @Param("gName") String gName,
                                           @Param("gHelpName") String gHelpName,
                                           @Param("selectStockState") Integer selectStockState);

    /**
     * 更新库存
     * @param id
     * @param rId
     * @param gooId
     * @param number
     * @return
     */
    int updateStock(
            @Param("id") Integer id,
            @Param("rId") Integer rId,
            @Param("gooId") Integer gooId,
            @Param("number") Integer number);
}
