package com.keji.mapper.repository;

import com.keji.pojo.stock.AllotOrder;
import com.keji.pojo.stock.AllotOrderDetail;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AllotOrderDetailMapper extends Mapper<AllotOrderDetail> {

}
