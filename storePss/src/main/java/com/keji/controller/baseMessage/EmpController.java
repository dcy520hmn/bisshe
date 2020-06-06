package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Emp;
import com.keji.service.baseMessage.EmpService;
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

    @RequestMapping("/queryByNoPage1")
    public String queryEmpByNoPage1 (@RequestBody Map params){
        List<Emp> info = empService.findAllEmpByNoPage(params);
        return dealQueryResult(info,info);
    };

    @RequestMapping("/queryByNoPage")
    public String queryEmpByNoPage (@RequestParam Map params){
        List<Emp> info = empService.findAllEmpByNoPage(params);
        return dealQueryResult(info,info);
    };


    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Map params){
        int ret =  empService.insertEmp(params);
        return dealQueryResult(ret,ret);
    };

    @RequestMapping("/update")
    public String update(@RequestBody Map params){
        int ret = empService.updateEmp(params);
        return dealQueryResult(ret,ret);
    }

    @RequestMapping("/delete")
    public String delete(@RequestBody Integer[] ids){
        int ret = empService.deleteEmp(ids);
        return dealQueryResult(ret,ret);
    }
}
