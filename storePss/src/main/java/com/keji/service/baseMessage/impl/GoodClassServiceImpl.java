package com.keji.service.baseMessage.impl;

import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.GoodClassMapper;
import com.keji.pojo.baseMessage.GoodClass;
import com.keji.service.baseMessage.GoodClassService;
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
public class GoodClassServiceImpl implements GoodClassService {

    @Autowired
    private GoodClassMapper goodClassMapper;

    @Override
    public List<GoodClass> findGoodClass(Map params) {
        List ret = null;
        Example example = new Example(GoodClass.class);
        String parentCode = MapUtils.getString(params, "parentCode");
        if (StringUtils.isNotEmpty(parentCode)) {//查询父编码
            example.createCriteria().andEqualTo("parentCode", parentCode);
            ret = goodClassMapper.selectByExample(example);
        }
        return ret;
    }
}
