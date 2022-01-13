package com.trkj.system.organizational_management.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.*;
import com.trkj.system.organizational_management.service.DeptPostSelectService;
import com.trkj.system.organizational_management.service.DeptService;
import com.trkj.system.organizational_management.service.UserService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController

public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DeptPostSelectService deptPostSelectService;
    @Autowired
    private UserService userService;


//    @GetMapping("/home")
//    public Object selectPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int  pagesize) {
//
//        Page<DeptStaff> page1 = new Page<>(currentPage,pagesize);
//        return deptService.selectpage(page1);
//    }
         //部门与员工查询
    @PostMapping("/home/a")
    public AjaxResponse selectPage(@RequestBody DeptStaff deptStaff){
        return AjaxResponse.success(deptService.selectPaer(deptStaff));
    }
    //部门与职位查询
    @PostMapping("/zhiwei/a")
    public AjaxResponse selectPage1(@RequestBody DeptDeptPost deptDeptPost){
        return AjaxResponse.success(deptService.selectPaer1(deptDeptPost));
    }

  /*        //逻辑删除
    @PostMapping("/updatedept")
    public String updateUser(@RequestBody Dept dept){
        try {
            if (deptService.updateUser(dept.getDeptId())>0) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }
    }*/
       //查询员工有哪些
    @GetMapping(value = "/cha")
    public List<Staff> girlList(){
        return deptService.findAll();
    }
    //查询职位有哪些
    @GetMapping(value = "/chapost")
    public List<Dept> girlList1(){
        return deptPostSelectService.findAll();
    }

    @PostMapping("/addDept")
    public String addDept(@RequestBody Dept dept) {
        System.out.println(dept);
        try {
            if (deptService.addDept(dept) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }


    }
       //职位删除
       @PostMapping("/deletePost")
       //穿过来一个值时，需要封装
       public AjaxResponse deleteDeptPost(@RequestBody ArrayList<Integer> id) {
           for (int i=0;i<id.size();i++){
               if (deptPostSelectService.deleteId(id.get(i)) > 0) {
                   return AjaxResponse.success("删除成功");
               }
           }
           return AjaxResponse.success("删除失败");
       }
       //职位添加
    @PostMapping("/addDeptPost")
    public String addDeptPost(@RequestBody DeptPostOne deptPostOne) {
        System.out.println(deptPostOne);
        try {
            if (deptPostSelectService.addDeptPost(deptPostOne) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }
    }
    @PutMapping("/updatePost/post")
    public AjaxResponse updatePost(@RequestBody DeptPostOne deptPostOne){
        System.out.println(deptPostOne);
        if (deptPostSelectService.updatePost(deptPostOne)>0){
            return  AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }

}

