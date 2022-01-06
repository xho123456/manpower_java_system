package com.trkj.system.organizational_management.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;
import com.trkj.system.organizational_management.entity.User;
import com.trkj.system.organizational_management.service.DeptService;
import com.trkj.system.organizational_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-28
 */
@RestController

public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public Object selectPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int  pagesize) {

        Page<DeptStaff> page1 = new Page<>(currentPage,pagesize);
        return deptService.selectpage(page1);
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

    @GetMapping(value = "/cha")
    public List<Staff> girlList(){
        return deptService.findAll();
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
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        try {
            if (userService.addUser(user) >= 1) {
                return "成功";
            } else {
                return "失败";
            }
        } catch (Exception e) {
            return "失败";
        }
    }


}

