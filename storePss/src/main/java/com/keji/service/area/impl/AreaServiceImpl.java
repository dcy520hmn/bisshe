package com.keji.service.area.impl;

import com.keji.mapper.area.AreaMapper;
import com.keji.pojo.area.Area;
import com.keji.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> findAreaByParentId(Integer parentId) {
        List<Area> areas = null;
        Example example = new Example(Area.class);
        if(parentId!=null){
            example.createCriteria().andEqualTo("parent",parentId);
            areas = areaMapper.selectByExample(example);
        }
        return areas;
    }
}
