package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.ProvideServiceMapper;
import com.keji.pojo.baseMessage.TProvider;
import com.keji.service.baseMessage.TProviderService;
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
public class TProviderServiceImpl implements TProviderService {

    @Autowired
    private ProvideServiceMapper tProviderServiceMapper;


    /**
     * 查询供应商
     * @param params
     * @return
     * @
     */
    @Override
    public PageInfo<TProvider> queryProvider(Map params)  {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Example example = new Example(TProvider.class);
        Integer id = MapUtils.getInteger(params,"providerId");
        String shortName = MapUtils.getString(params,"shortName");
        if(StringUtils.isNotEmpty(id)){
            example.createCriteria().andEqualTo("id",id);
        }
        if(StringUtils.isNotEmpty(shortName)){
            example.createCriteria().andLike("shortName",shortName);
        }
        example.createCriteria().andEqualTo("state",1);
        Page<TProvider> providerPage = (Page<TProvider>) tProviderServiceMapper.selectByExample(example);
        PageInfo<TProvider> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public List<TProvider> queryProviderByNoPage() {
        Example example = new Example(TProvider.class);
        example.createCriteria().andEqualTo("state",1);
        List<TProvider> ret = tProviderServiceMapper.selectByExample(example);
        return ret;
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
                TProvider tProvider = new  TProvider();
                tProvider.setState(0);
                Example example = new Example(TProvider.class);
                example.createCriteria().andEqualTo("id",id);
                result = tProviderServiceMapper.updateByExampleSelective(tProvider,example);
            }
        }
        return result;
    }

    @Override
    public int updateProvider(TProvider tProvider)  {
        return tProviderServiceMapper.updateByPrimaryKey(tProvider);
    }
}
