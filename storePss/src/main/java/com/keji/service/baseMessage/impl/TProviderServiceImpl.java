package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.baseMessage.TProviderServiceMapper;
import com.keji.pojo.baseMessage.TProvider;
import com.keji.service.baseMessage.TProviderService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Service
public class TProviderServiceImpl implements TProviderService {

    @Autowired
    private TProviderServiceMapper tProviderServiceMapper;

    /**
     * 查询供应商
     * @param params
     * @return
     * @ 
     */
    @Override
    public PageInfo<TProvider> queryProvider(Map params)  {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Page<TProvider> providerPage = (Page<TProvider>) tProviderServiceMapper.selectAll();
        PageInfo<TProvider> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public int insertProvider(TProvider tProvider)  {
        return tProviderServiceMapper.insert(tProvider);
    }

    @Override
    public int deleteProvider(Integer[] ids)  {
        int result = 0;
        if(ids != null){
            for (Integer id : ids) {
                result =  tProviderServiceMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    public int updateProvider(TProvider tProvider)  {
        return tProviderServiceMapper.updateByPrimaryKey(tProvider);
    }
}
