package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.pojo.baseMessage.TProvider;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface TProviderService {
    PageInfo<TProvider> queryProvider(Map params);

    int insertProvider(TProvider tProvider);

    int deleteProvider(Integer[] id);

    int updateProvider(TProvider tProvider);
}
