package com.keji.controller.authority;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.PageResult;
import com.keji.common.web.BaseController;
import com.keji.pojo.authority.Authority;
import com.keji.service.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dcy
 * @date 2019/9/15 11:45
 * @description
 */
@RestController
@RequestMapping("/auth")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;


    /**
     * 查询锁有的权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllAuthority")
    public  String  findAllAuthority(Integer pageNum,Integer pageSize,Integer id){
        PageInfo<Authority> authorityPageInfo = authorityService.findAllAuthority(pageNum,pageSize,id);
        return dealQueryResult(authorityPageInfo,authorityPageInfo);
    }

    /**
     * 查询权限
     * @param pageNum
     * @param pageSize
     * @param
     * @return
     */
    @RequestMapping("/findAuth")
    public  String findAuth(Integer pageNum,Integer pageSize,String name,Integer parentId){
        PageInfo<Authority> authorityPageResult = authorityService.findAuthority(pageNum,pageSize,name,parentId);
        return dealQueryResult(authorityPageResult,authorityPageResult);
    }

    /**
     * 增加权限
     * @param authority
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Authority authority){
        int ret = authorityService.addAuth(authority);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改权限
     * @param authority
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody Authority authority){
        int ret = authorityService.modifyAuth(authority);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除权限
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret = authorityService.deleteAuth(ids);
        return dealQueryResult(ret,ret);
    }
}
