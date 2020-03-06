package com.keji.service.authority;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.pojo.authority.Authority;

/**
 * 权限服务层
 * dcy
 */
public interface AuthorityService {

    /**
     * 查询出模块对应的权限
     * @return 权限的集合
     */
    PageInfo<Authority> findAllAuthority(int pageNum, int pageSize,int id);

    PageInfo<Authority> findAuthority(int pageNum,int pageSize,String authName,Integer parentId);

    int addAuth(Authority authority);

    int deleteAuth(Integer[] id);

    int modifyAuth(Authority authority);
}
