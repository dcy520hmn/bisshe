package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.GoodMapper;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.TProvider;
import com.keji.service.baseMessage.GoodService;
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
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodsMapper;

    @Override
    public PageInfo<Good> queryGood(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        Example example = new Example(Good.class);
        Integer id = MapUtils.getInteger(params, "id");
        String helpNum = MapUtils.getString(params, "helpNum");
        if (StringUtils.isNotEmpty(id)) {
            example.createCriteria().andEqualTo("id", id);
        }
        if (StringUtils.isNotEmpty(helpNum)) {
            example.createCriteria().andLike("helpNum", helpNum);
        }
        example.createCriteria().andEqualTo("state", 1);
        Page<Good> providerPage = (Page<Good>) goodsMapper.selectByExample(example);
        PageInfo<Good> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public List<Good> queryGoodByNoPage(Map params) {
        Example example = new Example(Good.class);
        Integer id = MapUtils.getInteger(params, "id");
        example.createCriteria().andEqualTo("id", id==null?-1:id);
        example.createCriteria().andEqualTo("state", 1);
        List<Good> good = goodsMapper.selectByExample(example);
        return good;
    }

    @Override
    public int insertGood(Good good) {
        return goodsMapper.insert(good);
    }

    @Override
    public int deleteGood(Integer[] ids) {
        int result = 0;
        if (ids != null) {
            for (Integer id : ids) {
                Good good = new Good();
                good.setState(0);
                Example example = new Example(Good.class);
                example.createCriteria().andEqualTo("id", id);
                result = goodsMapper.updateByExampleSelective(good, example);
            }
        }
        return result;
    }

    @Override
    public int updateGood(Good good) {
        return goodsMapper.updateByPrimaryKey(good);
    }
}
