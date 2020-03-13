package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Good;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:商品服务层
 * @author: runoob
 * @date:
 */
public interface GoodService {
    PageInfo<Good> queryProvider(Map params);

    int insertProvider(Good good);

    int deleteProvider(Integer[] id);

    int updateProvider(Good good);
}
