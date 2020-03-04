package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.Gathering;
import com.keji.service.GatheringService;
import com.keji.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李天笑
 * @date 2019/9/9 19:39
 * 还款控制器
 */

@RestController
@RequestMapping("/gatheringController")
public class GatheringController extends BaseController {

    @Resource
    private GatheringService gatheringService;

    @RequestMapping("/addGathering")
    public String addGathering(String orderId, BigDecimal money){
        Gathering gathering = new Gathering();
        //添加订单编号
        gathering.setGathOrderId(orderId);
        //添加还款金额
        gathering.setGathMoney(money);
        gathering.setGathCreateDate(new Date());
        gathering.setGathDate(new Date());
        gatheringService.addGathering(gathering);

        return dealSuccessResutl("ok",null);
    }
}
