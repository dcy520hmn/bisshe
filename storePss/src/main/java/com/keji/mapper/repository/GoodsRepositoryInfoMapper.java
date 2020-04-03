package com.keji.mapper.repository;

import com.github.pagehelper.Page;
import com.keji.pojo.repository.GoodRepositoryInfo;
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
public interface GoodsRepositoryInfoMapper {
    Page<GoodRepositoryInfo>  findGoodsRepositoryInfo(@Param("rId") Integer rId,
                                                      @Param("posId")Integer posId,
                                                      @Param("gName") String gName,
                                                      @Param("gHelpName") String gHelpName);
}
