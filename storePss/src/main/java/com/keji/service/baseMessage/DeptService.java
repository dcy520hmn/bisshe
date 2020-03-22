package com.keji.service.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.baseMessage.Dept;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:商品服务层
 * @author: runoob
 * @date:
 */
public interface DeptService {
    PageInfo<Dept> queryDept(Map params);

    List<Dept> queryAllDept();

    int insertDept(Dept good);

    int deleteDept(Integer[] id);

    int updateDept(Dept good);
}
