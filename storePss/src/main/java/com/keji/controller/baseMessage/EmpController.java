package com.keji.controller.baseMessage;

import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Dept;
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

    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Map params){
        int ret =  empService.insertEmp(params);
        return dealQueryResult(ret,ret);
    };
}
