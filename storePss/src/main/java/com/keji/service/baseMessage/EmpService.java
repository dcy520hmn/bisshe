package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Emp;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface EmpService {
    PageInfo<Emp> queryEmp(Map params);

    List<Emp> findAllEmpByNoPage();

    int insertEmp(Map params);

    int deleteEmp(Integer[] id);

    int updateEmp(Map params);
}
