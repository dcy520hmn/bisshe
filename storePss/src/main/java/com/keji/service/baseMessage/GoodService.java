package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Good;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:商品服务层
 * @author: runoob
 * @date:
 */
public interface GoodService {
    PageInfo<Good> queryGood(Map params);

    List<Good> queryGoodByNoPage(Map params);

    int insertGood(Good good);

    int deleteGood(Integer[] id);

    int updateGood(Good good);
}
