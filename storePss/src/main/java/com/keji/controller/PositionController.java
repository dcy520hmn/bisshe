package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.PositionMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Position;
import com.keji.pojo.Product;
import com.keji.service.PositionService;
import com.keji.service.ProductService;
import com.keji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

/**
 * @program: sale
 * @description: 职务表现层
 * @author: lxh
 * @create: 2019-09-08 10:20
 **/

@RestController
@RequestMapping("/positionController")
public class PositionController extends BaseController {


    @Autowired
    private PositionService positionService;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private UserService userService;

    /**
     * 获取所有职务信息
     *
     * @return
     */
    @RequestMapping("/findAllPosition")
    public String findAllPosition(int page) {
        PageInfo<Position> pageInfo=positionService.findAllPosition(page,2);
        String position =dealQueryResult(pageInfo,pageInfo);
        return position;
    }

    @PostMapping("/addPosition")
    public String addPosotion(Position position, Principal principal)throws ParseException {
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/
        int row=positionService.addPosition(position);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }

    @PostMapping("/findPositionById")
    public String fingProductById(int posId){
        Position position =positionMapper.findPositionById(posId);
        String json =dealQueryResult(position,position);
        return json;
    }

    @PostMapping("/updatePositionById")
    public String updateProductById(Position position){
        int row=positionMapper.updatePositionById(position);
        if(row==0){
            return dealSuccessResutl("修改信息失败",null);
        }else {
            return dealSuccessResutl("修改信息成功", null);
        }
    }

    @PostMapping("/deletePositionById")
    public String deletePositionById(int posId){
        int row=positionMapper.delPositionById(posId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }
}
