package com.trkj.system.salary_management.controller;

import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptPostOne;
import com.trkj.system.salary_management.entity.FixedSalary;
import com.trkj.system.salary_management.entity.Fixedwage;
import com.trkj.system.salary_management.entity.Salary;
import com.trkj.system.salary_management.entity.SalaryList;
import com.trkj.system.salary_management.mapper.SalaryMapper;
import com.trkj.system.salary_management.service.FixedSalaryService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FixedSalaryController {
    @Autowired
    private FixedSalaryService fixedSalaryService;

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
}
