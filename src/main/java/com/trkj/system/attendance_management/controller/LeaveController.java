package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Overtimeask;
import com.trkj.system.attendance_management.service.LeaveService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


    //查询当前登录用户的打卡情况
    @PostMapping("/leave/queryalls")
    public AjaxResponse queryalls(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectAll(clockRecord));
    }

    //根据当前登录用户查询请假信息
    @PostMapping("/leave/queryallqjs")
    public AjaxResponse queryallqjs(@RequestBody Leave leave){
        return AjaxResponse.success(service.selectAllqj(leave));
    }
    //根据当前登录用户查询加班信息
    @PostMapping("/overtimes/queryallqjb")
    public AjaxResponse queryallqjb(@RequestBody Overtimeask overtimeask){
        return AjaxResponse.success(service.selectAlljb(overtimeask));
    }

    //查询当前登录用户的打卡情况
    @PostMapping("/leave/queryalldk")
    public AjaxResponse queryalldk(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectAlldk(clockRecord));
    }

    //统计请假次数
    @PostMapping("/leave/leavenumbers")
    public AjaxResponse leavenumbers(@RequestBody Leave leave){
        return AjaxResponse.success(service.querynumber(leave));
    }
}

