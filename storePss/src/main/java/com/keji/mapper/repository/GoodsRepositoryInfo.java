package com.keji.mapper.repository;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface GoodsRepositoryInfo {
    Page<GoodsRepositoryInfo>  findGoodsRepositoryInfo(@Param("rId") Integer rId,
                                                       @Param("posId")Integer posId,
                                                       @Param("gName") String gName,
                                                       @Param("gHelpName") String gHelpName);
}
