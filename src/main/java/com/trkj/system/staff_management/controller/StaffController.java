package com.trkj.system.staff_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import com.trkj.system.staff_management.service.StaffService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping("/staff")
    public AjaxResponse findStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findStaff(page1));
    }
    @GetMapping("/staff/history")
    public AjaxResponse findHistoryStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffHistoryEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findHistoryStaff(page1));
    }
    @GetMapping("/staff/elite")
    public AjaxResponse findEliteStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffEliteEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findEliteStaff(page1));
    }
    @GetMapping("/staff/punishment")
    public AjaxResponse findPunishmentStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffPunishmentEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findPunishmentStaff(page1));
    }
    @GetMapping("/staff/reward")
    public AjaxResponse findRewardStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffRewardEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findRewardStaff(page1));
    }
    @GetMapping("/staff/induction")
    public AjaxResponse findInductionStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffInductionEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findInductionStaff(page1));
    }
    @GetMapping("/staff/giveupinduction")
    public AjaxResponse findgiveupInductionStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffGiveupInductionEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findgiveupInductionStaff(page1));
    }
    @GetMapping("/staff/turnright")
    public AjaxResponse findTurnrightStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findTurnrightStaff(page1));
    }
    @GetMapping("/staff/transfer")
    public AjaxResponse findTransferStaff(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<StaffTransferEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.findTransferStaff(page1));
    }


    @PostMapping("/staff/getId")
    public AjaxResponse findStaffById(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findStaffById(staff));
    }

    @PostMapping("/staff/likename")
    public AjaxResponse findStaffLikeByName(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findStaffLikeByName(staff));
    }

}
