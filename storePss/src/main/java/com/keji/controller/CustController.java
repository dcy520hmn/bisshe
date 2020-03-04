package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.CustMapper;
import com.keji.pojo.VolunteerPojo;
import com.keji.service.CustService;
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
 * @description: 客户控制层
 * @author:
 * @create: 2019-09-08 09:45
 **/

@RestController
@RequestMapping("/volunteerController")
public class CustController extends BaseController {
    @Autowired
    private CustService volunteerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustMapper volunteerMapper;

    /**
     * 查询所有客户信息
     *
     * @return
     */
    @RequestMapping("/findAllVolunteer")
    public String findAllVolunteer(int page) {
        PageInfo<VolunteerPojo> volunteerPageInfo = volunteerService.findAllVolunteer(page, 5);
        String volunteer = dealQueryResult(volunteerPageInfo, volunteerPageInfo);
        return volunteer;
    }

    @PostMapping("/addVolunteer")
    public String addVolunteer(VolunteerPojo volunteer, Principal principal, String BirthdayDate) throws ParseException {
        int row = volunteerService.addVolunteer(volunteer);
        if (row == 0) {
            return dealSuccessResutl("添加信息失败", null);
        }
        return dealSuccessResutl("成功添加信息", null);
    }

    @PostMapping("/findVolunteerById")
    public String findVolunteerById(int volunteerId) {
        VolunteerPojo volunteer = volunteerService.findVolunteerPojoById(volunteerId);
        String json = dealQueryResult(volunteer, volunteer);
        return json;
    }

    @PostMapping("/updateVolunteerById")
    public String updateVolunteerById(VolunteerPojo volunteer) {
        int row = volunteerService.updateVolunteerById(volunteer);
        if (row == 0) {
            return dealSuccessResutl("修改信息失败", null);
        }
        return dealSuccessResutl("修改信息成功", null);
    }

    @PostMapping("/deleteVolunteerById")
    public String deleteVolunteerById(int id) {
        int row = volunteerService.delVolunteerById(id);
        if (row == 0) {
            return dealSuccessResutl("删除信息失败", null);
        }
        return dealSuccessResutl("删除信息成功", null);

    }

    @PostMapping("/findVolunteerByname")
    public List<VolunteerPojo> findVolunteerByname(String name){
        List<VolunteerPojo> volunteerPojo = volunteerService.findVolunteerByName(name);
        return volunteerPojo;
    }
}
