package com.keji.pojo.authority;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/10 21:22
 * @description
 */
@Data
@Table(name = "t_auth")
public class Authority {
    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//权限id
    @Column(name = "auth_name")
    private String name;//权限名称
    @Column(name = "auth_describe")
    private String describe;//权限描述
    @Column(name = "auth_path")
    private String path;//权限路径
    @Column(name = "auth_parent_id")
    private Integer parId;//父权限的id

    @Transient
    private Authority parentAuthority;//父模块名称
}
