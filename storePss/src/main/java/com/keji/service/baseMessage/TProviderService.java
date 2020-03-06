package com.keji.service.baseMessage;

import com.keji.common.utils.PageResult;
import com.keji.pojo.baseMessage.TProvider;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface TProviderService {
    PageResult<TProvider> queryBrandByPageAndSort(Integer pageNum, Integer pageSize, String messagerName,  String provideName);
}
