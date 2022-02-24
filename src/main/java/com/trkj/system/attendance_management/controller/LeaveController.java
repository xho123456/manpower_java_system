package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Overtimeask;
import com.trkj.system.attendance_management.entity.StaffVo;
import com.trkj.system.attendance_management.service.LeaveService;
import com.trkj.system.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Slf4j
public class LeaveController {

    @Autowired
    private LeaveService service;


    //查询All打卡情况
    @PostMapping("/leave/queryalls")
    public AjaxResponse queryalls(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectAll(clockRecord));
    }

    //查询当前登录用户的打卡情况
    @PostMapping("/leave/queryalldk")
    public AjaxResponse queryalldk(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectAlldk(clockRecord));
    }

    //根据当前登录用户查询请假信息
    @PostMapping("/leave/queryallqjs")
    public AjaxResponse queryallqjs(@RequestBody Leave leave){
        return AjaxResponse.success(service.selectAllqj(leave));
    }

    //统计请假次数
    @PostMapping("/leave/leavenumbers")
    public AjaxResponse leavenumbers(@RequestBody Leave leave){
        return AjaxResponse.success(service.querynumber(leave));
    }

    //根据当前登录用户查询加班信息
    @PostMapping("/overtimes/queryallqjb")
    public AjaxResponse queryallqjb(@RequestBody Overtimeask overtimeask){
        return AjaxResponse.success(service.selectAlljb(overtimeask));
    }

    //根据当前登录用户查询迟到信息
    @PostMapping("/clock/queryallcds")
    public AjaxResponse queryallcds(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectByAllchid(clockRecord));
    }

    //根据当前登录用户查询早退信息
    @PostMapping("/clock/queryallzts")
    public AjaxResponse queryallzts(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectByAllzaot(clockRecord));
    }

    //根据当前登录用户查询旷工信息
    @PostMapping("/clock/queryallkuangs")
    public AjaxResponse queryallkuangs(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selectByAllkuang(clockRecord));
    }

    //统计迟到次数
    @PostMapping("/clock/querycdnumbers")
    public AjaxResponse querycdnumbers(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selchidnumber(clockRecord));
    }

    //统计早退次数
    @PostMapping("/clock/queryzhaotnumbers")
    public AjaxResponse queryzhaotnumbers(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selzaotnumber(clockRecord));
    }

    //统计旷工次数
    @PostMapping("/clock/querykgnumbers")
    public AjaxResponse querykgnumbers(@RequestBody ClockRecord clockRecord){
        return AjaxResponse.success(service.selkuangnumber(clockRecord));
    }

    //考勤月统计
    @PostMapping("/leave/queryallsmothday")
    public AjaxResponse queryallsmothday(@RequestBody StaffVo staffVo){
        return AjaxResponse.success(service.selectAllmothday(staffVo));
    }

}

