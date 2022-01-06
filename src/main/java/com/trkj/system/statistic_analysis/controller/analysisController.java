package com.trkj.system.statistic_analysis.controller;


import com.trkj.system.organizational_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class analysisController {
    @Autowired
    private StaffService staffService;
    //查询员工性别分布
    @GetMapping("/chasex")
    public List<Map<String, Object>> selectCount(){
        return staffService.selectSex();
    }
    //查询员工婚姻分布
    @GetMapping("/chahy")
    public List<Map<String, Object>> selectCount1(){
        return staffService.selecthy();
    }
    //查询员工工龄小于一年的
    @GetMapping("/chagl1")
    public List<Map<String, Object>> selectCount2(){
        return staffService.selectgl1();
    }
    //查询员工工龄对于一年的
    @GetMapping("/chagl11")
    public List<Map<String, Object>> selectCount3(){
        return staffService.selectgl11();
    }
    //查询员工工龄等于二年的
    @GetMapping("/chagl2")
    public List<Map<String, Object>> selectCount4(){
        return staffService.selectgl2();
    }
    //查询员工工龄等于三年的
    @GetMapping("/chagl3")
    public List<Map<String, Object>> selectCount5(){
        return staffService.selectgl3();
    }
    //查询员工工龄等于四年的
    @GetMapping("/chagl4")
    public List<Map<String, Object>> selectCount6(){
        return staffService.selectgl4();
    }
    //查询员工工龄五年及上的
    @GetMapping("/chagl5")
    public List<Map<String, Object>> selectCount7(){
        return staffService.selectgl5();
    }

    //查询员工学历
    @GetMapping("/chaxl")
    public List<Map<String, Object>> selectCount8(){
        return staffService.selectxl();
    }
    //查询员工年龄
    @GetMapping("/chanl")
    public List<Map<String, Object>> selectCount9(){
        return staffService.selectnl();
    }
    //查询员工星座
    @GetMapping("/chaxz")
    public List<Map<String, Object>> selectCount10(){
        return staffService.selectxz();
    }

    //查询员工在职状态
    @GetMapping("/chaygzt")
    public List<Map<String, Object>> selectCount11(){
        return staffService.selectygzt();
    }
    @GetMapping("/chand")
    public List<Map<String, Object>> selectCount12(){
        return staffService.selectnd();
    }
}
