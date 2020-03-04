package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.VolunteerPojo;
import com.keji.pojo.VolunteerPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lxh
 * 订单详情接口:客户持久层】】】
 *
 */
@Mapper
public interface CustMapper {
    //查询客户所有信息
    Page<VolunteerPojo> findAllVolunteerPojo();

    //通过客户编号查询一条客户信息
    VolunteerPojo findVolunteerPojoById(@Param("id") int id);

    //通过客户编号删除客户信息(直接传一个客户对象即可)
    int delVolunteerPojoById(@Param("id") int id);

    //通过id修改一条客户信息
    int updateVolunteerPojoById(VolunteerPojo volunteer);

    //添加一条客户信息
    int addVolunteerPojo(VolunteerPojo volunteer);

    //根据客户名称查询客户
    List<VolunteerPojo> findVolunteerByName(@Param("name") String name);
}
