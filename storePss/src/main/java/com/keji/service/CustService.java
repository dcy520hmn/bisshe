package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.VolunteerPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale
 * @author:lxh 业务逻辑层
 */


public interface CustService {
    //获取所有客户信息
     PageInfo<VolunteerPojo> findAllVolunteer(int pageNum, int pageSize);

    //根据电话查询客户
    public List<VolunteerPojo> findVolunteerByName(@Param("phone") String phone);

    //通过客户编号删除客户信息(直接传一个客户对象即可)
    public int delVolunteerById(@Param("id") int id);

    //通过id修改一条客户信息
    public int updateVolunteerById(VolunteerPojo customer);

    VolunteerPojo findVolunteerPojoById(int id);

    //添加一条客户信息
    public int addVolunteer(VolunteerPojo customer);
}
