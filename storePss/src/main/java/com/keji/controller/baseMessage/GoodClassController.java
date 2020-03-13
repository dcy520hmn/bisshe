package com.keji.controller.baseMessage;

import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.GoodClass;
import com.keji.service.baseMessage.GoodClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RestController
@RequestMapping("/goodClass")
public class GoodClassController extends BaseController {

    @Autowired
    private GoodClassService goodClassService;

    /**
     * 查村商品类别
     * @param params
     * @return
     */
    @RequestMapping("/findGoodClass")
    public String findGoodClass(@RequestBody Map params){
        List<GoodClass> goodClassList = goodClassService.findGoodClass(params);
        return dealQueryResult(goodClassList,goodClassList);
    }

}
