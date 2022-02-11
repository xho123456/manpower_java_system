package com.trkj.system.attendance_management.controller;


import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.service.ShiftAllService;
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

}

