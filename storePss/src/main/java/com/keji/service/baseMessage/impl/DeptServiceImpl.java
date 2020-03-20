package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.DeptMapper;
import com.keji.pojo.baseMessage.Dept;
import com.keji.service.baseMessage.DeptService;
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
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public PageInfo<Dept> queryDept(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Example example = new Example(Dept.class);
        Integer id = MapUtils.getInteger(params,"deptId");
        String deptName = MapUtils.getString(params,"deptName");
        if(StringUtils.isNotEmpty(id)){
            example.createCriteria().andEqualTo("id",id);
        }
        if(StringUtils.isNotEmpty(deptName)){
            example.createCriteria().andLike("deptName",deptName);
        }
        Page<Dept> providerPage = (Page<Dept>) deptMapper.selectByExample(example);
        PageInfo<Dept> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    @Override
    public int insertDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int deleteDept(Integer[] ids) {
        int result = 0;
        if(ids != null){
            for (Integer id : ids) {
                result =  deptMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByPrimaryKey(dept);
    }
}
