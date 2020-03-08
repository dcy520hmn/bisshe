package com.keji.service.area;

import com.keji.pojo.area.Area;

import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
public interface AreaService {
    List<Area> findAreaByParentId(Integer parentId);

    List<Area> findAreaByIds(List  ids);
}
