package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Good;
import com.keji.service.baseMessage.GoodService;
import com.keji.service.baseMessage.GoodService;
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
@RequestMapping("/good")
@RestController
public class GoodController extends BaseController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("/findGood")
    public String findGood(@RequestBody  Map params){
        PageInfo<Good> pageInfo = goodService.queryGood(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    @RequestMapping("/findGoodByNoPage")
    public String findGoodByNoPage(@RequestBody  Map params){
        List<Good> info = goodService.queryGoodByNoPage(params);
        return dealQueryResult(info,info);
    }

    /**
     * 增加商品信息
     * @param authority
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Good authority){
        int ret =  goodService.insertGood(authority);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改商品信息
     * @param authority
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody Good authority){
        int ret =  goodService.updateGood(authority);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret =  goodService.deleteGood(ids);
        return dealQueryResult(ret,ret);
    }
}
