package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.baseMessage.DeptMapper;
import com.keji.pojo.baseMessage.Dept;
import com.keji.pojo.baseMessage.Good;
import com.keji.service.baseMessage.DeptService;
import com.keji.service.baseMessage.EmpService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
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
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpService empService;

    @Override
    public List<Dept> queryAllDept() {
        return deptMapper.selectAll();
    }

    @Override
    public PageInfo<Dept> queryDept(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
        Example example = new Example(Dept.class);
        Integer id = MapUtils.getInteger(params,"deptId");
        String deptName = MapUtils.getString(params,"deptName");
        example.createCriteria().andEqualTo("state",1);
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
                Dept dept = new Dept();
                dept.setState(0);
                Example example = new Example(Dept.class);
                example.createCriteria().andEqualTo("id",id);
                result = deptMapper.updateByExampleSelective(dept,example);
            }
        }
        return result;
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByPrimaryKey(dept);
    }
}
