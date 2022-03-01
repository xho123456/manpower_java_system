package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.Checkfiles;
import com.trkj.system.attendance_management.entity.StaffVo;
import com.trkj.system.attendance_management.service.CheckfilesService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
@RestController
public class CheckfilesController {

    @Autowired
    private CheckfilesService service;

    //考勤月统计
    @PostMapping("Check/queryMoth")
    public AjaxResponse queryMoth(@RequestBody StaffVo staffVo){
        return AjaxResponse.success(service.querymothday(staffVo));
    }

    //考勤数据归档
    @PostMapping("Check/queryMoths")
    public AjaxResponse queryMoths(@RequestBody StaffVo staffVo){
        return AjaxResponse.success(service.addmothday(staffVo));
    }

    //查询当前选择器月份是否有归档数据
    @PostMapping("Check/querygd")
    public AjaxResponse querygd(@RequestBody Checkfiles checkfiles){
        return AjaxResponse.success(service.querygds(checkfiles));
    }

    //查询所有归档月份
    @PostMapping("Check/querydaytimes")
    public AjaxResponse querygds(@RequestBody Checkfiles checkfiles){
        return AjaxResponse.success(service.querysDay(checkfiles));
    }

    //通过日期查询归档表的数据
    @PostMapping("Check/queryBytimes")
    public AjaxResponse queryBytimes(@RequestBody Checkfiles checkfiles){
        return AjaxResponse.success(service.selectDayis(checkfiles));
    }


}

