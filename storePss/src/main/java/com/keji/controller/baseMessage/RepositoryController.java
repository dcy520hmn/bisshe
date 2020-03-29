package com.keji.controller.baseMessage;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.baseMessage.Repository;
import com.keji.service.baseMessage.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/repository")
@RestController
public class RepositoryController extends BaseController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/findRepository")
    public String findRepository(@RequestBody  Map params){
        PageInfo<Repository> pageInfo = repositoryService.queryRepository(params);
        return dealQueryResult(pageInfo,pageInfo);
    }

    /**
     * 增加仓库信息
     * @param repository
     * @return
     */
    @RequestMapping("/insert")
    public String insertAuth(@RequestBody Repository repository){
        int ret =  repositoryService.insertRepository(repository);
        return dealQueryResult(ret,ret);
    };

    /**
     * 修改仓库信息
     * @param repository
     * @return
     */
    @RequestMapping("/update")
    public String updateAuth(@RequestBody Repository repository){
        int ret =  repositoryService.updateRepository(repository);
        return dealQueryResult(ret,ret);
    }

    /**
     * 删除仓库信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAuth(@RequestBody Integer[] ids){
        int ret =  repositoryService.deleteRepository(ids);
        return dealQueryResult(ret,ret);
    }
}
