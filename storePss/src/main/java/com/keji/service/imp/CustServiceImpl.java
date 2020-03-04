package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.CustMapper;
import com.keji.pojo.VolunteerPojo;
import com.keji.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sale
 * @description: 客户业务层
 * @author: lxh
 * @create: 2019-09-08 09:17
 **/
@Service
public class CustServiceImpl implements CustService {
    @Autowired
    CustMapper customerMapper;

    @Override
    public PageInfo<VolunteerPojo> findAllVolunteer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<VolunteerPojo> customerPage = customerMapper.findAllVolunteerPojo();
        PageInfo<VolunteerPojo> customersPageInfo = new PageInfo<>(customerPage);
        return customersPageInfo;
    }

    @Override
    public List<VolunteerPojo> findVolunteerByName(String name) {
        return customerMapper.findVolunteerByName(name);
    }

    @Override
    public int addVolunteer(VolunteerPojo customer) {

        return customerMapper.addVolunteerPojo(customer);
    }

    @Override
    public int delVolunteerById(int id) {
        return customerMapper.delVolunteerPojoById(id);
    }

    @Override
    public int updateVolunteerById(VolunteerPojo customer) {
        return customerMapper.updateVolunteerPojoById(customer);
    }

    @Override
    public VolunteerPojo findVolunteerPojoById(int id) {
        return customerMapper.findVolunteerPojoById(id);
    }
}
