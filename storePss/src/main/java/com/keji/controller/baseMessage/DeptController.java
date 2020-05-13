package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Dept;
import com.keji.service.baseMessage.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RequestMapping("/dept")
@RestController
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAllDept")
    public String queryAllDept(){
        List<Dept> ret = deptService.queryAllDept();
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/findDept")
    public String findDept(@RequestBody  Map params){
        PageInfo<Dept> pageInfo = deptService.queryDept(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    @RequestMapping("/findDept1")
    public String findDept1(@RequestParam Map params){
        PageInfo<Dept> pageInfo = deptService.queryDept(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    /**
     * 增加商品信息
     * @param dept
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Dept dept){
        int ret =  deptService.insertDept(dept);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改商品信息
     * @param dept
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody Dept dept){
        int ret =  deptService.updateDept(dept);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret =  deptService.deleteDept(ids);
        return dealQueryResult(ret,ret);
    }
}
