package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Repository;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:商品服务层
 * @author: runoob
 * @date:
 */
public interface RepositoryService {
    PageInfo<Repository> queryRepository(Map params);

    int insertRepository(Repository good);

    int deleteRepository(Integer[] id);

    int updateRepository(Repository good);
}
