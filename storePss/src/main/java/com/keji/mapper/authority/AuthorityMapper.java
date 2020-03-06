package com.keji.mapper.authority;

import com.github.pagehelper.Page;
import com.keji.pojo.authority.Authority;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/11 16:56
 * @description
 */
@Repository
public interface AuthorityMapper extends Mapper<Authority>{

    /**
     * 查询出所有的权限
     * @return 权限的集合
     */
    Page<Authority> findAllAuthority(@Param("id") Integer id);

    /**
     * 通过id查询权限
     * @return
     */
    Authority findAuthorityById(@Param("id") Integer id);

    Page<Authority> findAuthority(@Param("authName") String authName,@Param("parentId") Integer parentId);
}
