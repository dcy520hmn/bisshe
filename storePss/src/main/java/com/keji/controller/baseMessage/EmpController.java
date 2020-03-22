package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Emp;
import com.keji.service.baseMessage.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:员工
 * @author: runoob
 * @date:
 */
@RestController
@RequestMapping("/emp")
public class EmpController extends BaseController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/query")
    public String queryEmp (@RequestBody Map params){
        PageInfo<Emp> pageInfo = empService.queryEmp(params);
        return dealQueryResult(pageInfo,pageInfo);
    };

    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Map params){
        int ret =  empService.insertEmp(params);
        return dealQueryResult(ret,ret);
    };

    @RequestMapping("/update")
    public String update(@RequestBody Emp emp){
        int ret = empService.updateEmp(emp);
        return dealQueryResult(ret,ret);
    }

}
