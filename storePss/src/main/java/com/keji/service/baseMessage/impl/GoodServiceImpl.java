package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.GoodMapper;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Good;
import com.keji.service.baseMessage.GoodService;
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
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodsMapper;

    @Override
    public PageInfo<Good> queryProvider(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Example example = new Example(Good.class);
        Integer id = MapUtils.getInteger(params,"providerId");
        String shortName = MapUtils.getString(params,"shortName");
        if(StringUtils.isNotEmpty(id)){
            example.createCriteria().andEqualTo("id",id);
        }
        if(StringUtils.isNotEmpty(shortName)){
            example.createCriteria().andLike("shortName",shortName);
        }
        Page<Good> providerPage = (Page<Good>) goodsMapper.selectByExample(example);
        PageInfo<Good> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public int insertProvider(Good good) {
        return goodsMapper.insert(good);
    }

    @Override
    public int deleteProvider(Integer[] ids) {
        int result = 0;
        if(ids != null){
            for (Integer id : ids) {
                result =  goodsMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    public int updateProvider(Good good) {
        return goodsMapper.updateByPrimaryKey(good);
    }
}
