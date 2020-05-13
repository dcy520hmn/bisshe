package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.RepositoryMapper;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Repository;
import com.keji.service.baseMessage.RepositoryService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
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
        Integer id = MapUtils.getInteger(params,"id");
        Integer deptId = MapUtils.getInteger(params,"deptId");
        if(StringUtils.isNotEmpty(code)){
            example.createCriteria().andLike("rCode",code);
        }
        if(StringUtils.isNotEmpty(id)){
            example.createCriteria().andEqualTo("id",id);
        }
        if(StringUtils.isNotEmpty(deptId)){
            example.createCriteria().andEqualTo("deptId",deptId);
        }
        example.createCriteria().andEqualTo("state",1);
        Page<Repository> providerPage = (Page<Repository>) repositoryMapper.selectByExample(example);
        PageInfo<Repository> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public List<Repository> queryRepositoryByNoPage(Map params) {
        Example example = new Example(Repository.class);
        String code = MapUtils.getString(params,"code");
        Integer id = MapUtils.getInteger(params,"id");
        Integer deptId = MapUtils.getInteger(params,"deptId");
        if(StringUtils.isNotEmpty(code)){
            example.createCriteria().andLike("rCode",code);
        }
        if(StringUtils.isNotEmpty(id)){
            example.createCriteria().andEqualTo("id",id);
        }
        if(StringUtils.isNotEmpty(deptId)){
            example.createCriteria().andEqualTo("deptId",deptId);
        }
        example.createCriteria().andEqualTo("state",1);
        return repositoryMapper.selectByExample(example);
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
                Repository repository = new Repository();
                repository.setState(0);
                Example example = new Example(Repository.class);
                example.createCriteria().andEqualTo("id",id);
                result =  repositoryMapper.updateByExampleSelective(repository,example);
            }
        }
        return result;
    }

    @Override
    public int updateRepository(Repository repository) {
        return repositoryMapper.updateByPrimaryKey(repository);
    }
}
