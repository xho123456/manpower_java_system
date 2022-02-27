package com.trkj.system.salary_management.controller;

import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.salary_management.entity.*;
import com.trkj.system.salary_management.service.BusinesssService;
import com.trkj.system.salary_management.service.FixedSalaryService;
import com.trkj.system.salary_management.service.WagenotfileddService;
import com.trkj.system.salary_management.service.WorkschemeService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FixedSalaryController {
    @Autowired
    private FixedSalaryService fixedSalaryService;
    @Autowired
    private WorkschemeService workschemeService;
    @Autowired
    private BusinesssService businesssService;
    @Autowired
    private WagenotfileddService wagenotfileddService;
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
    //添加加班方案
    @PostMapping("/addworkschemee")
    public String addworkschemee(@RequestBody Workschemee workschemee) {
        System.out.println(workschemee);
        try {
            if (workschemeService.addWorkschemee(workschemee) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }


    }
    //加班工资方案查询
    @PostMapping("jbgz/a")
    public AjaxResponse selectPage1(@RequestBody Workscheme workscheme){
        return AjaxResponse.success(workschemeService.selectPaer1(workscheme));
    }
    @PutMapping("/updateWorkscheme/Workscheme")
    public AjaxResponse updateWorkscheme(@RequestBody Workschemee workschemee){

        if (workschemeService.updateWorkscheme(workschemee)>0){
            return  AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }
    //删除加班方案
    @PostMapping("/deleteWorkscheme/b")
    //穿过来一个值时，需要封装
    public AjaxResponse deleteWorkscheme(@RequestBody ArrayList<Integer> id) {
        for (int i=0;i<id.size();i++){
            if (workschemeService.deleteWorkscheme(id.get(i)) > 0) {
                return AjaxResponse.success("删除成功");
            }
        }
        return AjaxResponse.success("删除失败");
    }
    //////////以下为出差方案
    //出差方案查询
    @PostMapping("chuaifanan/a")
    public AjaxResponse selectPage(@RequestBody Businesss businesss){
        return AjaxResponse.success(businesssService.selectPaer(businesss));
    }

    //查询工资未归档
    @PostMapping("chagzweiguidan/a")
    public AjaxResponse selectPage11(@RequestBody Wagenotfiledd wagenotfiledd){
        return AjaxResponse.success(wagenotfileddService.selectPaer(wagenotfiledd));
    }

}
