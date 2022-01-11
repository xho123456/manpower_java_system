package com.trkj.system.organizational_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.service.UserService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/deleteUser")
    //穿过来一个值时，需要封装
    public AjaxResponse deleteUser(@RequestBody ArrayList<Integer> id) {
        for (int i=0;i<id.size();i++){
            if (userService.deleteId(id.get(i)) > 0) {
                return AjaxResponse.success("删除成功");
            }
        }
        return AjaxResponse.success("删除失败");
    }
    @PutMapping("/updateDept/dept")
    public AjaxResponse updateDept(@RequestBody Dept dept){
        System.out.println(dept+"-----------------------");
        try {
            if (userService.updateDept(dept) >0) {
                return AjaxResponse.success("成功");
            } else {
                return AjaxResponse.success("失败");
            }
        } catch (Exception e) {
            return AjaxResponse.success("失败");
        }
    }


}
