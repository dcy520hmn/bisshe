package com.keji.pojo.authority;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 段春玉
 * @Date: 2019-8-27 12：55
 * @Version 1.0
 * User 表用户表
 */


@Data
public class UserInfo implements Serializable {
    private Integer id;//用户id
    private String userName;//用户名
    private String password;//用户密码
    private Date createDate;//创建日期
    private Date updateDate;//更新日期
    private Integer deleteStatus;//删除状态
    private Integer modifierId;//修改人id
    private Integer status;//用户的启用状态
    private long empId;//员工id
    private List<Role> roles;
}
