package com.keji.service.authority.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.mapper.authority.AuthorityMapper;
import com.keji.pojo.authority.Authority;
import com.keji.pojo.authority.Role;
import com.keji.service.authority.AuthorityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author dcy
 * @date 2019/9/15 11:39
 * @description
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    /**
     * 查询出模块对应的权限
     * @return 权限的集合
     */
    @Override
    public PageInfo<Authority> findAllAuthority(int pageNum, int pageSize,int id) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Authority> authorityPage = authorityMapper.findAllAuthority(id);
        PageInfo<Authority> pageInfo =  new PageInfo<>(authorityPage);
        return pageInfo;
    }


    /**
     * 查询所有的权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Authority> findAuthority(int pageNum, int pageSize,String authName,Integer parentId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Authority>  authPage = authorityMapper.findAuthority(authName,parentId);
        PageInfo<Authority> rolePageInfo = new PageInfo<>(authPage);
        return rolePageInfo;
    }

    @Override
    public int addAuth(Authority authority) {
        int result = 0;
        if(authority != null){
            result = authorityMapper.insert(authority);
        }
        return result;
    }

    @Override
    public int deleteAuth(Integer[] ids) {
        int result = 0;
        if(ids != null){
            for (Integer id : ids) {
                result =  authorityMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    public int modifyAuth(Authority authority) {
        int result = 0;
        if(authority != null){
            result =  authorityMapper.updateByPrimaryKey(authority);
        }
        return result;
    }
}
