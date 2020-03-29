package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.RepositoryMapper;
import com.keji.pojo.baseMessage.Repository;
import com.keji.service.baseMessage.RepositoryService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Override
    public PageInfo<Repository> queryRepository(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Example example = new Example(Repository.class);
        String code = MapUtils.getString(params,"code");
        if(StringUtils.isNotEmpty(code)){
            example.createCriteria().andLike("rCode",code);
        }
        Page<Repository> providerPage = (Page<Repository>) repositoryMapper.selectByExample(example);
        PageInfo<Repository> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public int insertRepository(Repository repository) {
        return repositoryMapper.insert(repository);
    }

    @Override
    public int deleteRepository(Integer[] ids) {
        int result = 0;
        if(ids != null){
            for (Integer id : ids) {
                result =  repositoryMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    public int updateRepository(Repository repository) {
        return repositoryMapper.updateByPrimaryKey(repository);
    }
}
