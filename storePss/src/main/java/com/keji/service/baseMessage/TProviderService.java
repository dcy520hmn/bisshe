package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.pojo.baseMessage.TProvider;

import java.util.List;
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

    List<TProvider> queryProviderByNoPage();

    int insertProvider(TProvider tProvider);

    int deleteProvider(Integer[] id);

    int updateProvider(TProvider tProvider);
}
