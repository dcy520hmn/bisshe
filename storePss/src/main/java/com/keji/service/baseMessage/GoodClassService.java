package com.keji.service.baseMessage;

import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.GoodClass;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface GoodClassService {

    //查询商品列表
    List<GoodClass> findGoodClass(Map params);
}
