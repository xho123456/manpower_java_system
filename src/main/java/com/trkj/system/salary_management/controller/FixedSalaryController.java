package com.trkj.system.salary_management.controller;

import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.salary_management.entity.*;
import com.trkj.system.salary_management.service.FixedSalaryService;
import com.trkj.system.salary_management.service.WorkschemeService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FixedSalaryController {
    @Autowired
    private FixedSalaryService fixedSalaryService;
    @Autowired
    private WorkschemeService workschemeService;
    //查询员工 部门 固定工资 职位
      @PostMapping("FixedSalarySelect/DeptName")
    public AjaxResponse selectPage2(@RequestBody FixedSalary fixedSalary){
          return AjaxResponse.success(fixedSalaryService.selectPaer2(fixedSalary));
      }
    //查询部门有哪些
    @GetMapping(value = "/FixedSalarySelectDept")
    public List<Dept> girlList1(){
        return fixedSalaryService.findAll();
    }
    //添加调薪表
    @PostMapping("/adSalary/salary")
    public AjaxResponse addSalary(@RequestBody Salary salary) {
          System.out.println(salary);
            if (fixedSalaryService.addSalary(salary) >=0) {
                return AjaxResponse.success("成功");
            } else {
                return AjaxResponse.success("失败");
            }
    }
    //查询调薪，员工，部门
    @PostMapping("/Salary/Salary")
    public AjaxResponse selectPage3(@RequestBody SalaryList salaryList){
        return AjaxResponse.success(fixedSalaryService.selectPaer3(salaryList));
    }
    //修改固定工资
    @PutMapping("/updateFixedSalary/fixedSalary")
    public AjaxResponse updateFixedSalary(@RequestBody Fixedwage fixedwage){
        System.out.println(fixedwage);
        if (fixedSalaryService.updateFixedSalary(fixedwage)>0){
            return  AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }
    //////////以下为加班工资方案
    //加班工资方案查询
    @PostMapping("jbgz/a")
    public AjaxResponse selectPage1(@RequestBody Workscheme workscheme){
        return AjaxResponse.success(workschemeService.selectPaer1(workscheme));
    }

}
