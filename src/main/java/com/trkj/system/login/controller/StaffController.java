package com.trkj.system.login.controller;


import com.trkj.system.login.entity.Staff;
import com.trkj.system.login.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */
@RestController
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping("/staff")
    public Staff findStaff(Long id){
        return service.selectstaff(id);
    }
}

