package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Emp;

import java.text.ParseException;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface EmpService {
    Object queryEmp(Map params);

    int insertEmp(Map params);

    int deleteEmp(Integer[] id);

    int updateEmp(Emp emp);
}
