package com.trkj.system.salary_management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.StaffWag;
import com.trkj.system.organizational_management.mapper.StaffWagMapper;
import com.trkj.system.salary_management.mapper.MoneypigeonholeMapper;
import com.trkj.system.salary_management.mapper.entity.*;
import com.trkj.system.salary_management.service.*;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AttendandceService attendandceService;
    @Autowired
    private  StaffSalaryService staffSalaryService;
    @Autowired
    private MoneypigeonholeService moneypigeonholeService;
    @Autowired
    private MoneypigeonholeMapper moneypigeonholeMapper;
    @Autowired
    private StaffWagMapper staffWagMapper;
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
    }  //修改加班方案
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
    //删除加班方案
    @PostMapping("/deleteBusinessss/b")
    //穿过来一个值时，需要封装
    public AjaxResponse deleteBusinessss(@RequestBody ArrayList<Integer> id) {
        for (int i=0;i<id.size();i++){
            if (businesssService.deleteBusinessss(id.get(i)) > 0) {
                return AjaxResponse.success("删除成功");
            }
        }
        return AjaxResponse.success("删除失败");
    }

    //添加出差方案
    @PostMapping("/addbusinesss")
    public String addbusinesss(@RequestBody Businessss businessss) {
        System.out.println(businessss);
        try {
            if (businesssService.addBusinesss(businessss) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }

    }
    //修改出差方案
    @PutMapping("/updateBusinessss/Businessss")
    public AjaxResponse updateBusinessss(@RequestBody Businessss businessss){

        if (businesssService.updatebusinessss(businessss)>0){
            return  AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }
//////////////////
    //以下为考勤

    //考勤方案查询
    @PostMapping("kqfan/select")
    public AjaxResponse selectPage2(@RequestBody Attendandce attendandce){
        return AjaxResponse.success(attendandceService.selectPaer(attendandce));
    }
    //添加出差方案
    @PostMapping("/addAttendandce")
    public String addAttendandce(@RequestBody Attendandcee attendandcee) {
        System.out.println(attendandcee);
        try {
            if (attendandceService.addAttendandcee(attendandcee) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }

    }
    //删除加班方案
    @PostMapping("/deleteAttendandcee/delete")
    //穿过来一个值时，需要封装
    public AjaxResponse deleteAttendandcee(@RequestBody ArrayList<Integer> id) {
        for (int i=0;i<id.size();i++){
            if (attendandceService.deleteAttendandcee(id.get(i)) > 0) {
                return AjaxResponse.success("删除成功");
            }
        }
        return AjaxResponse.success("删除失败");
    }

    //修改考勤方案
    @PutMapping("/updateAttendandcee/Attendandcee")
    public AjaxResponse updateAttendandcee(@RequestBody Attendandcee attendandcee){

        if (attendandceService.updateAttendandcee(attendandcee)>0){
            return  AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }

////////////////////////////
    //以下为工资部分
    //查询工资未归档
    @PostMapping("chagzweiguidan/a")
    public AjaxResponse selectPage11(@RequestBody Wagenotfiledd wagenotfiledd){
        return AjaxResponse.success(wagenotfileddService.selectPaer(wagenotfiledd));
    }

    //查询员工工资详细信息
    @PostMapping("StaffSalarySelect/Staff")
    public AjaxResponse selectPage(@RequestBody StaffSalary staffSalary){
        return AjaxResponse.success(staffSalaryService.selectPaer(staffSalary));
    }
    //查询工资表
    @GetMapping(value = "/selectStaffSalary")
    public List<StaffSalary> girlList11(){
        return staffSalaryService.findAll11();
    }

    //工资表归档
    @PostMapping("/guidanwag")
    public String guidanwag(@RequestBody Moneypigeonhole moneypigeonhole) {
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        try {
         moneypigeonholeService.guidanwag(moneypigeonhole);
            Long id = moneypigeonholeMapper.maxId();
            List<StaffWag> staffWag = staffWagMapper.selectList(new QueryWrapper<StaffWag>().eq("TO_CHAR(CREATED_TIME,'yyyy-MM')", format));

            if(staffWag.size()>0){
                System.err.println("判断================="+staffWag);
               staffWag.forEach(e->{
                   e.setMoneypigeonholeId(id);
                   staffWagMapper.updateById(e);
               });
           }
           return "成功";

        } catch (Exception e) {
            throw new RuntimeException("错误："+e.getMessage());
//            return "失败";
        }

    }
    //查询本月工资表id
    @GetMapping("/selectbyid")
    public List<Map<String, Object>> selectbyid(){
        return moneypigeonholeService.selectbyid();
    }
    //查询本月工资表是否有
    @GetMapping("/selectbyyf")
    public List<Map<String, Object>> selectbyyf(){
        return moneypigeonholeService.selectbyyf();
    }


    //查工资归档表信息
    @PostMapping("moneypigeonhole/select")
    public AjaxResponse selectPage1(@RequestBody Moneypigeonhole moneypigeonhole){
        return AjaxResponse.success(moneypigeonholeService.selectPaer(moneypigeonhole));
    }
    //根据归档编号查询id
    @PostMapping("StaffSalarySelect1/Staff1")
    public AjaxResponse selectPage12(@RequestBody StaffSalary staffSalary){
        return AjaxResponse.success(staffSalaryService.selectPaer1(staffSalary));
    }
}
