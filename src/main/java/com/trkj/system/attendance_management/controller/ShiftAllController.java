package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.ClassesVo;
import com.trkj.system.attendance_management.service.ShiftAllService;
import com.trkj.system.recruit_modular.entity.Evaluate;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 班次管理 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@RestController
public class ShiftAllController {

    @Autowired
    private ShiftAllService server;

    @PostMapping("/Classes/pageall")
    public AjaxResponse selectAllPage(@RequestBody Classes classes){
        return AjaxResponse.success(server.selectAllPage(classes));
    }

    @PostMapping("/Classes/isdeleteds")
    public AjaxResponse isdeleteds(@RequestBody ArrayList<Integer> id) {
        String s="成功";
        for (int i=0;i<id.size();i++){
            if(server.isdeletedCl(id.get(i))>=1){
                s ="成功";
            }else {
                return  AjaxResponse.success("失败");
            }
        }
        return AjaxResponse.success(s);
    }
    //班次添加
    @PostMapping("/Classes/isaddclass")
    public AjaxResponse isaddclass(@RequestBody ClassesVo classes){
        if(server.addClases(classes)>=1) {
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

    //通过id查询班次消息
    @GetMapping("/Classes/isquerybyid")
    public AjaxResponse isquerybyid(@RequestParam("id") Integer id){
        return AjaxResponse.success(server.isfindByid(id));
    }

    //班次修改
    @PostMapping("/Classes/isupdatebyentity")
    public AjaxResponse isupdatebyentity(@RequestBody ClassesVo classesVo) {
        if (server.isupdateClases(classesVo)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

    //禁用所有班次
    @PostMapping("/Classes/upclasesall")
    public AjaxResponse upclasesall(){
        if (server.updateclasesall()>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

}

