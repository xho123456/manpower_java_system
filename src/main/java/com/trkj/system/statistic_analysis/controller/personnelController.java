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
    //查询每月入职人数
    @GetMapping("/charz")
    public List<Map<String, Object>> selectCount(){
        return staffService.selectrz();
    }


    //查询每月入职人数
    @GetMapping("/chalz1")
    public List<Map<String, Object>> selectCount11(){
        return staffService.selectyglz1();
    }


    //查询本月入职人数
    @GetMapping("/chabyrz")
    public List<Map<String, Object>> selectCount1(){
        return staffService.selectbyrz();
    }
    //查询上月入职人数
    @GetMapping("/chasyrz")
    public List<Map<String, Object>> selectCount2(){
        return staffService.selectsyrz();
    }
    //查询本月转正人数
    @GetMapping("/chabyygzz")
    public List<Map<String, Object>> selectCount3(){
        return staffService.selectbyygzz();
    }
    //查询上月转正人数
    @GetMapping("/chasyygzz")
    public List<Map<String, Object>> selectCount4(){
        return staffService.selectsyygzz();
    }

    //查询员工新进律
    @GetMapping("/chaygxj")
    public List<Map<String, Object>> selectCount5(){
        return staffService.selectygxj();
    }

    //查询员工每月请假人数
    @GetMapping("/selectqjrs")
    public List<Map<String, Object>> selectCount6(){
        return staffService.selectqjrs();
    }
    //查询员工本月月请假人数
    @GetMapping("/selectdyqjrs")
    public List<Map<String, Object>> selectCount7(){
        return staffService.selectdyqjrs();
    }

    //查询员工每月出差人数
    @GetMapping("/selectccrs")
    public List<Map<String, Object>> selectCount8(){
        return staffService.selectccrs();
    }

    //查询员工本月出差人数
    @GetMapping("/selectdyccrs")
    public List<Map<String, Object>> selectCount9(){
        return staffService.selectdyccrs();
    }

    //查询员工每月加班总小时
    @GetMapping("/selectjbtime")
    public List<Map<String, Object>> selectCount10(){
        return staffService.selectjbtime();
    }
    //查询员工本月月加班总小时
    @GetMapping("/selectbyjbtime")
    public List<Map<String, Object>> selectCount13(){
        return staffService.selectbyjbtime();
    }
    //查询员工有多少人
    @GetMapping("/selectStaffrs")
    public List<Map<String, Object>> selectCount12(){
        return  staffService.selectStaffrs();
    }


}
