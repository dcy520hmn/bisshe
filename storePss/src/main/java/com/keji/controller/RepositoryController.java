package com.keji.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.Repository;
import com.keji.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author TianXiangbo
 * @date 2019/9/8 00088:25
 * Content:
 */
@RestController
@RequestMapping("/rep")
public class RepositoryController extends BaseController {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 条件分页动态查询数据库数据并返回前端
     * @param page 当前页
     * @param productName 商品名称
     * @param repId 库存编号
     * @param warning 自定义预警值
     * @return pageInfo
     */
    @PostMapping("/Reps")
    public String findAllReps(Integer page,String productName,Integer repId,Integer warning){
        //将查询条件封装成对象进行查询
        Repository repository = new Repository();
        repository.setProductName( productName );
        repository.setRepId( repId );
        repository.setProductWarning( warning );
        PageInfo<Repository> repPageInfo = repositoryService.findRepositoryByPage( page,5,repository );
        String json = dealQueryResult( repPageInfo,repPageInfo );
        return json;
    }

    /**
     * 根据id查询库存信息并填入下面框中
     * @return json类型的对象
     */
    @PostMapping("findRepById")
    public String findRepsById(Integer repId){
        Repository repository = new Repository();
        repository.setRepId( repId);
        PageInfo<Repository> repPageInfo = repositoryService.findRepositoryByPage( 1,5,repository );
        List<Repository> rep = repPageInfo.getList();
        String json = dealQueryResult( rep,rep );
        return json;
    }

    /**
     * 查询所有预警商品
     * @return json类型的对象
     */
    @PostMapping("findRepsWarn")
    public String findRepsWarn(Integer page){
        PageInfo<Repository> repPageInfo = repositoryService.findAllWarnRep( page,5 );
        String json = dealQueryResult( repPageInfo,repPageInfo );
        return json;
    }

    /**
     * 添加库存
     */
    @PostMapping("/addQuantity")
    public String addQuantity(String[] json) throws ParseException {
        String str="";
        for(int i=0;i<json.length;i++){
            str+=json[i]+",";
        }
        System.out.println(str);
        String subData = str.substring(str.indexOf("[") + 1, str.lastIndexOf("],"));
        System.out.println(subData);
        String upData= subData.replaceAll("},\\{","}!{");
        System.out.println(upData);
        String [] arr =upData.split("!");
         for(int i=0;i<arr.length;i++){
             Repository repository=new Repository();
            System.out.println("这是"+arr[i]);
            JSONObject jsonObject = JSONObject.parseObject(arr[i]);
            Set<Map.Entry<String,Object>> set=jsonObject.entrySet();
            Iterator<Map.Entry<String,Object>> iterator= set.iterator();
            int con=4;
                while(iterator.hasNext()){
                    con++;
                    Map.Entry<String,Object> map=iterator.next();
                    //System.out.println(map.getKey()+" "+map.getValue());
                    if(con%4!=0){
                        if(map.getKey().equals( "repId" )){
                            int repId = (Integer) map.getValue();
                            Repository r = repositoryService.findRepositoryById( repId );
                            repository.setProductName( r.getProductName() );
                            repository.setSupName( r.getSupName() );
                            repository.setProductAddress( r.getProductAddress() );
                            repository.setProductStandard( r.getProductStandard() );
                        }
                        if(map.getKey().equals( "repPurchDate" )){
                            repository.setRepPurchDate(new SimpleDateFormat("yyyy-MM-dd").parse( (String)map.getValue() ));
                        }
                        if(map.getKey().equals( "repQuantity" )){
                            repository.setRepQuantity(Integer.parseInt((String) map.getValue() ));
                        }
                        if(map.getKey().equals( "repPurch" )){
                            repository.setRepPurch(new BigDecimal(Integer.parseInt((String) map.getValue())));
                        }

                    }
                }
             System.out.println(repository);
             repositoryService.updateRepository(repository);
        }
        return dealSuccessResutl( "信息修改成功",null );
    }

}
