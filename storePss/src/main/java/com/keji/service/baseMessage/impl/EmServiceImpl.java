package com.keji.service.baseMessage.impl;

import com.github.pagehelper.PageInfo;
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
        return null;
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
            Emp emp = new Emp();
            emp.setAddress(MapUtils.getString(params, "address"));
            emp.setAreaCode(MapUtils.getString(params, "areaCode"));
            emp.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(MapUtils.getString(params, "birthday")));
            emp.setDeptId(MapUtils.getLongValue(params, "deptId"));
            emp.setGender(MapUtils.getString(params, "gender"));
            emp.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse(MapUtils.getString(params, "hireDate")));
            emp.setIdentity(MapUtils.getString(params, "identity"));
            emp.setName(MapUtils.getString(params, "name"));
            emp.setPhone(MapUtils.getString(params, "phone"));
            emp.setSalary(MapUtils.getDoubleValue(params, "salary"));
            empMapper.insert(emp);

            UserInfo userInfo = new UserInfo();
            String userName = MapUtils.getString(params, "userName");
            //加密处理
            ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
            Object password = new SimpleHash("MD5", MapUtils.getString(params, "password"), credentialsSalt, 1024);
            userInfo.setUserName(userName);
            userInfo.setPassword((String)password);
            ret  =  userMapper.addUser(userInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int deleteEmp(Integer[] id) {
        return 0;
    }

    @Override
    public int updateEmp(Emp emp) {
        return 0;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123456";//密码原值
        int hashIterations = 1024;//加密1024次
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        System.out.println(credentialsSalt);
        Object result = new SimpleHash(hashAlgorithmName, credentialsSalt, hashIterations);
        System.out.println(result);
    }
}
