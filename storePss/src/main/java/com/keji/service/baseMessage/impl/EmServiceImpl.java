package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.StringUtils;
import com.keji.mapper.authority.UserMapper;
import com.keji.mapper.baseMessage.EmpMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.Emp;
import com.keji.service.baseMessage.EmpService;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EmServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Emp> queryEmp(Map params) {
        PageHelper.startPage(MapUtils.getInteger(params, "pageNum"), MapUtils.getInteger(params, "pageSize"));
        Integer deptId = MapUtils.getIntValue(params, "deptId");
        Integer empId = MapUtils.getIntValue(params, "empId");
        Page<Emp> providerPage = (Page<Emp>) empMapper.findUserByConditions(deptId, empId);
        PageInfo<Emp> pageInfo = new PageInfo<>(providerPage);
        return pageInfo;
    }

    /**
     * 业务逻辑，添加员工时，同时注册用户名和密码
     *
     * @param
     * @return
     */
    @Override
    @Transactional
    public int insertEmp(Map params) {
        int ret = 0;
        try {
            //检测用户名是否存在
            UserInfo haveUserInfo = userMapper.findUserByUserName(MapUtils.getString(params, "userName"));
            if (haveUserInfo != null) {
                return -1;
            }
            //添加员工
            Emp emp = new Emp();
            emp.setAddress(MapUtils.getString(params, "address"));
            emp.setAreaCode(MapUtils.getString(params, "areaCode"));
            emp.setBirthday(new SimpleDateFormat("yyyy年MM月dd日").parse(MapUtils.getString(params, "birthday")));
            emp.setDeptId(MapUtils.getLongValue(params, "deptId"));
            emp.setGender(MapUtils.getString(params, "gender"));
            emp.setHireDate(new SimpleDateFormat("yyyy年MM月dd日").parse(MapUtils.getString(params, "hireDate")));
            emp.setIdentity(MapUtils.getString(params, "identity"));
            emp.setName(MapUtils.getString(params, "name"));
            emp.setPhone(MapUtils.getString(params, "phone"));
            emp.setSalary(MapUtils.getDoubleValue(params, "salary"));
            empMapper.insert(emp);
            //注册用户
            UserInfo userInfo = new UserInfo();
            String userName = MapUtils.getString(params, "userName");
            //加密处理
            ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
            SimpleHash password = new SimpleHash("MD5", MapUtils.getString(params, "password"), credentialsSalt, 1024);
            userInfo.setUserName(userName);
            userInfo.setPassword(password.toString());
            userInfo.setEmpId(emp.getId());
            userMapper.addUser(userInfo);
            ret = userMapper.addRole(userInfo.getId(), MapUtils.getInteger(params, "roleId"));
            //增加权限
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int deleteEmp(Integer[] ids) {
        int result = 0;
        if (ids != null) {
            for (Integer id : ids) {
                result = empMapper.deleteByPrimaryKey(id);
            }
        }
        return result;
    }

    @Override
    @Transactional
    public int updateEmp(Map params) {
        int ret = 0;
        try {
            Emp emp = new Emp();
            emp.setId(MapUtils.getInteger(params, "id"));
            emp.setAddress(MapUtils.getString(params, "address"));
            emp.setAreaCode(MapUtils.getString(params, "areaCode"));
            emp.setBirthday(new SimpleDateFormat("yyyy年MM月dd日").parse(MapUtils.getString(params, "birthday")));
            emp.setDeptId(MapUtils.getLongValue(params, "deptId"));
            emp.setGender(MapUtils.getString(params, "gender"));
            emp.setHireDate(new SimpleDateFormat("yyyy年MM月dd日").parse(MapUtils.getString(params, "hireDate")));
            emp.setIdentity(MapUtils.getString(params, "identity"));
            emp.setName(MapUtils.getString(params, "name"));
            emp.setPhone(MapUtils.getString(params, "phone"));
            emp.setSalary(MapUtils.getDoubleValue(params, "salary"));
            empMapper.updateByPrimaryKey(emp);
            UserInfo userInfo = userMapper.findUserByEmpId(emp.getId());
            ret = userMapper.updateUserRole(userInfo.getId(), MapUtils.getInteger(params, "roleId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
