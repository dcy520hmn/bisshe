package com.keji.service.baseMessage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.MapUtil;
import com.keji.mapper.authority.UserMapper;
import com.keji.mapper.baseMessage.EmpMapper;
import com.keji.pojo.authority.UserInfo;
import com.keji.pojo.baseMessage.Dept;
import com.keji.pojo.baseMessage.Emp;
import com.keji.service.baseMessage.EmpService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
    public Object queryEmp(Map params) {
        Example example = new Example(Emp.class);
        Integer deptId = MapUtils.getIntValue(params,"deptId");
        if(deptId!=null){
            example.createCriteria().andEqualTo("deptId",deptId);
        }
        Integer pageNum = MapUtils.getInteger(params,"pageNum");
        Integer pageSize = MapUtils.getInteger(params,"pageSize");
        if(pageNum!=null && pageSize!=null){
            PageHelper.startPage(MapUtils.getInteger(params,"pageNum"),MapUtils.getInteger(params,"pageSize"));
            Page<Emp> providerPage = (Page<Emp>) empMapper.selectByExample(example);
            PageInfo<Emp> pageInfo = new PageInfo<>(providerPage);
            return pageInfo;
        }else{
            List ret = empMapper.selectByExample(example);
            return ret;
        }
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
            UserInfo haveUserInfo = userMapper.findUserByUserName(MapUtils.getString(params,"userName"));
            if(haveUserInfo != null){
                return -1;
            }
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

            UserInfo userInfo = new UserInfo();
            String userName = MapUtils.getString(params, "userName");
            //加密处理
            ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
            SimpleHash password = new SimpleHash("MD5", MapUtils.getString(params, "password"), credentialsSalt, 1024);
            userInfo.setUserName(userName);
            userInfo.setPassword(password.toString());
            userInfo.setEmpId(emp.getId());
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
