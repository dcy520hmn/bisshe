package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.ProductMapper;
import com.keji.pojo.Position;
import com.keji.pojo.Product;
import com.keji.pojo.Supplier;
import com.keji.pojo.UserInfo;
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
 * @program: sale_System
 * @description: 商品表现层
 * @author: 李东升
 * @create: 2019-09-08 09:06
 **/
@RestController
@RequestMapping("/productController")
public class ProductController extends BaseController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    /**
     * 获取所有商品信息
     *
     * @return
     */
    @RequestMapping("/findAllProducts")
    public String findAllProducts(int page) {
        PageInfo<Product> pageInfo=productService.findAllProduct(page,2);
        String product=dealQueryResult(pageInfo,pageInfo);
        return product;
    }

    /**
     * 获取商品类别
     * @return
     */
    @RequestMapping("/getfingAllType")
    public String getfingAllType(){
        List<Product> Producttype= productService.fingAllType();
        String result =dealQueryResult(Producttype,Producttype);
        System.out.println(result);
        return result;
    }

    /**
     * 多条件分页查询
     * @param page
     * @param name
     * @param type
     * @return
     */
    @RequestMapping("/getProduct")
    public String getProduct(int page,String name,String type){
        PageInfo<Product> productPageInfo = productService.findProduct(page,5,name,type);
        List<Product> list= productPageInfo.getList();
        String result=dealQueryResult(list,list);
        String result1=dealQueryResult(productPageInfo,productPageInfo);
        return result1;
    }

    /**
     * 根据id查商品
     * @param productId
     * @return
     */
    @RequestMapping("/getOneProduct")
    public String getOneProduct(int productId){
        Product product= productService.findOneProduct(productId);
        String result=dealQueryResult(product,product);
        System.out.println(result);
        return result;
    }

    /**
     * 根据商品编号查询商品名称
     */
    @RequestMapping("/findProduct")
    public String findProduct(int productId) {
        Product product = productMapper.findProductById(productId);
        String result = dealQueryResult(product, product);
        System.out.println(result);
        return result;
    }

    /*
    添加商品
     */
    @PostMapping("/addProduct")
    public String addProduct(Product product, Principal principal)throws ParseException{
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/
       int row=productService.addProduct(product);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }

    @PostMapping("/findProductById")
    public String findProductById(int productId){
        Product product=productMapper.findProductById(productId);
        String json =dealQueryResult(product,product);
        return json;
    }

    @PostMapping("/updateProduct")
    public String UpdateProduct(Product product){
        int row = productMapper.updateProductById(product);
        System.out.println(row);
        if(row==0){
            return dealSuccessResutl("修改信息失败",null);
        }else {
            return dealSuccessResutl("修改信息成功", null);
        }
    }

    @PostMapping("/deleteProductById")
    public String deleteProductById(int productId){
        int row=productMapper.deleteProductById(productId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }

}
