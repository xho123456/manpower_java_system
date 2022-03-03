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
  //查询员工年代
    @GetMapping("/chand")
    public List<Map<String, Object>> selectCount12(){
        return staffService.selectnd();
    }

    //查询员工离职人数
    @GetMapping("/chayglz")
    public List<Map<String, Object>> selectCount13(){
        return staffService.selectyglz();
    }
    //查询单月员工离职人数
    @GetMapping("/chadylz")
    public List<Map<String, Object>> selectCount131(){
        return staffService.selectdylz();
    }
    //查询单月员工离职人数
    @GetMapping("/chasylz")
    public List<Map<String, Object>> selectCount132(){
        return staffService.selectsylz();
    }
    //查询员工离职状态
    @GetMapping("/chaygzz")
    public List<Map<String, Object>> selectCount14(){
        return staffService.selectygzz();
    }
    //查询部门top榜
    @GetMapping("/chadepttop")
    public List<Map<String, Object>> selectCount15(){
        return staffService.selectdepttop();
    }

    //查询每月计薪人数
    @GetMapping("/chajxrs")
    public List<Map<String, Object>> selectCount16(){
        return staffService.selectjxrs();
    }
    //查询本月计薪人数
    @GetMapping("/chabyjxrs")
    public List<Map<String, Object>> selectCount18(){
        return staffService.selectbyjxrs();
    }

    //查询每月人力成本
    @GetMapping("/charlcb")
    public List<Map<String, Object>> selectCount17(){
        return staffService.selectrlcb();
    }
    //查询每月人力成本
    @GetMapping("/chabyrlcb")
    public List<Map<String, Object>> selectCount19(){
        return staffService.selectbyrlcb();
    }
    //查询每月参保人数
    @GetMapping("/chabxrs")
    public List<Map<String, Object>> selectCount20(){
        return staffService.selectbxrs();
    }
    //查询本月参保人数
    @GetMapping("/chabybxrs")
    public List<Map<String, Object>> selectCount21(){
        return staffService.selectbybxrs();
    }

    //查询每月员工参保金额
    @GetMapping("/chaygsbje")
    public List<Map<String, Object>> selectCount22(){
        return staffService.selectygsbje();
    }
    //查询本月员工参保金额
    @GetMapping("/chabyygsbje")
    public List<Map<String, Object>> selectCount23(){
        return staffService.selectbyygsbje();
    }
    //查询每月公司参保金额
    @GetMapping("/chagssbje")
    public List<Map<String, Object>> selectCount24(){
        return staffService.selectgssbje();
    }
    //查询本月公司参保金额
    @GetMapping("/chabygssbje")
    public List<Map<String, Object>> selectCount25(){
        return staffService.selectbygssbje();
    }
    //查询本月试用基本工资
    @GetMapping("/chabysyjbgz")
    public List<Map<String, Object>> selectCount26(){
        return staffService.selectbysyjbgz();
    }
    //查询本月正式基本工资
    @GetMapping("/chabyzsjbgz")
    public List<Map<String, Object>> selectCount27(){
        return staffService.selectbyzsjbgz();
    }
    //查询本月基本工资
    @GetMapping("/chabyzsjbgzz")
    public List<Map<String, Object>> selectCount28(){
        return staffService.selectbyzsjbgzz();
    }
    //查询本月个人缴公积金
    @GetMapping("/chabygrgjj")
    public List<Map<String, Object>> selectCount29(){
        return staffService.selectbygrgjj();
    }
    //查询本月个人缴社保
    @GetMapping("/chabygrsb")
    public List<Map<String, Object>> selectCount30(){
        return staffService.selectbygrsb();
    }
    //查询本月公司缴社保
    @GetMapping("/chabygssb")
    public List<Map<String, Object>> selectCount31(){
        return staffService.selectbygssb();
    }
    //查询本月公司缴公积金
    @GetMapping("/chabygsgjj")
    public List<Map<String, Object>> selectCount32(){
        return staffService.selectbygsgjj();
    }

    //部门工资top榜
    @GetMapping("/chabmgztop")
    public List<Map<String, Object>> selectCount33(){
        return staffService.selectbmgztop();
    }

    //部门工资top榜
    @GetMapping("/chabmgzpj")
    public List<Map<String, Object>> selectCount34(){
        return staffService.selectbmgzpj();
    }
    //本月员工离职人数
    @GetMapping("/chayglz11")
    public List<Map<String, Object>> selectCount35(){
        return staffService.selectyglz11();
    }
    //本月试用员工人数
    @GetMapping("/selectbysyyg")
    public List<Map<String, Object>> selectbysyyg(){
        return staffService.selectbysyyg();
    }
    //本月正式员工人数
    @GetMapping("/selectbyzsyg")
    public List<Map<String, Object>> selectbyzsyg(){
        return staffService.selectbyzsyg();
    }
    //本月调薪
    @GetMapping("/selectbytx")
    public List<Map<String, Object>> selectbytx(){
        return staffService.selectbytx();
    }

}
