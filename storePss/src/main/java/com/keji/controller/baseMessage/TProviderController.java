package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.TProvider;
import com.keji.service.baseMessage.TProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@RequestMapping("/provider")
@RestController
public class TProviderController extends BaseController {

    @Autowired
    private TProviderService tProviderService;

    @RequestMapping("/findProvider")
    public String findProvider(@RequestBody  Map params){
        PageInfo<TProvider> pageInfo = tProviderService.queryProvider(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    /**
     * 增加供应商
     * @param authority
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody TProvider authority){
        int ret =  tProviderService.insertProvider(authority);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改供应商
     * @param authority
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody TProvider authority){
        int ret =  tProviderService.updateProvider(authority);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除供应商
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret =  tProviderService.deleteProvider(ids);
        return dealQueryResult(ret,ret);
    }
}
