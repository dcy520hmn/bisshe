package com.keji.controller.area;

import com.keji.common.web.BaseController;
import com.keji.pojo.area.Area;
import com.keji.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RestController
@RequestMapping("/area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/findAreaByParentId")
    public String findAreaByParentId(Integer parentId){
        List<Area> areaList = areaService.findAreaByParentId(parentId);
        return dealQueryResult(areaList,areaList);
    }

    @RequestMapping("/findAreaByIds")
    public String findAreaByIds(Integer[] ids){
        List ids1 = Arrays.asList(ids);
        List<Area> areas = areaService.findAreaByIds(ids1);
        return dealQueryResult(areas,areas);
    }
}
