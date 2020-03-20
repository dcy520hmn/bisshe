package com.keji.mapper.baseMessage;

import com.keji.pojo.baseMessage.Dept;
import com.keji.pojo.baseMessage.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Repository
public interface EmpMapper extends Mapper<Emp> {
}
