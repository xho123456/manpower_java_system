package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.service.LeaveService;
import com.trkj.system.vo.AjaxResponse;
import com.trkj.system.workbench.entity.workRecruitmentPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 请假表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@RestController
public class LeaveController {

    @Autowired
    private LeaveService service;
    //查询所有请假信息
    @PostMapping("/leave/queryallqjs")
    public AjaxResponse queryallqjs(@RequestBody Leave leave){
        return AjaxResponse.success(service.selectAllqj(leave));
    }
    //统计请假次数
    @PostMapping("/leave/leavenumbers")
    public AjaxResponse leavenumbers(@RequestBody Leave leave){
        return AjaxResponse.success(service.querynumber(leave));
    }
}

