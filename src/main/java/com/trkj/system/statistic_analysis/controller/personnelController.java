package com.trkj.system.statistic_analysis.controller;

import com.trkj.system.organizational_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class personnelController {
    @Autowired
    private StaffService staffService;
    //查询员工性别分布
    @GetMapping("/charz")
    public List<Map<String, Object>> selectCount(){
        return staffService.selectrz();
    }
}
