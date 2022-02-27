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

    @PostMapping("Check/queryMoth")
    public AjaxResponse queryMoth(@RequestBody StaffVo staffVo){
        System.out.println("1111111111111111111");
        return AjaxResponse.success(service.querymothday(staffVo));
    }

}

