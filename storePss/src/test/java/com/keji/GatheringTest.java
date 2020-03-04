package com.keji;

import com.keji.mapper.GatheringMapper;
import com.keji.pojo.Emp;
import com.keji.service.DeptStatisticsService;
import com.keji.service.SalaryBillsService;
import com.keji.service.imp.DeptServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/7 19:38
 * 订单详情
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StorePssApplication.class)
public class GatheringTest {
    @Autowired
    GatheringMapper gatheringMapper;

    @Autowired
    private DeptStatisticsService deptStatisticsService;

    @Autowired
    DeptServiceimpl deptServiceimpl;

    @Autowired
    private SalaryBillsService salaryBillsService;

    @Test
    public void  testFindUserByUserName() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = simpleDateFormat.parse("2019-09-15");
        Date endDate = simpleDateFormat.parse("2019-10-15");
        List<Emp> emps = salaryBillsService.findTheDeptAllEmp(1,beginDate,endDate);
        System.out.println(emps);
    }

}
