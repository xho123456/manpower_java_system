package com.trkj.system.staff_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import com.trkj.system.staff_management.service.StaffService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        /** 条件查询：id  or   name   */

    @PostMapping("/staff/getId")
    public AjaxResponse findStaffById(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findStaffById(staff));
    }

    @PostMapping("/staff/likename")
    public AjaxResponse findStaffLikeByName(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findStaffLikeByName(staff));
    }

    @PostMapping("/staff/history/getId")
    public AjaxResponse findHistoryStaffById(@RequestBody StaffHistoryEntity staff){
        return AjaxResponse.success(service.findHistoryStaffById(staff));
    }

    @PostMapping("/staff/history/likename")
    public AjaxResponse findHistoryStaffLikeByName(@RequestBody StaffHistoryEntity staff){
        return AjaxResponse.success(service.findHistoryStaffLikeByName(staff));
    }

    @PostMapping("/staff/punishment/getId")
    public AjaxResponse findPunishById(@RequestBody StaffPunishmentEntity staff){
        return AjaxResponse.success(service.findPunishById(staff));
    }

    @PostMapping("/staff/punishment/likename")
    public AjaxResponse findPunishLikeByName(@RequestBody StaffPunishmentEntity staff){
        return AjaxResponse.success(service.findPunishLikeByName(staff));
    }

    @PostMapping("/staff/elite/getId")
    public AjaxResponse findRewardStaffById(@RequestBody StaffEliteEntity staff){
        return AjaxResponse.success(service. findEliteStaffById(staff));
    }

    @PostMapping("/staff/elite/likename")
    public AjaxResponse findRewardStaffLikeByName(@RequestBody StaffEliteEntity staff){
        return AjaxResponse.success(service.findEliteStaffLikeByName(staff));
    }

    @PostMapping("/staff/reward/getId")
    public AjaxResponse findRewardStaffById(@RequestBody StaffRewardEntity staff){
        return AjaxResponse.success(service. findRewardStaffById(staff));
    }

    @PostMapping("/staff/reward/likename")
    public AjaxResponse findRewardStaffLikeByName(@RequestBody StaffRewardEntity staff){
        return AjaxResponse.success(service.findRewardStaffLikeByName(staff));
    }

    @PostMapping("/staff/induction/likename")
    public AjaxResponse findInductionStaffLikeByName(@RequestBody StaffInductionEntity staff){
        return AjaxResponse.success(service.findInductionStaffLikeByName(staff));
    }

    @PostMapping("/staff/giveupinduction/likename")
    public AjaxResponse findgiveupInductionStaffLikeByName(@RequestBody StaffGiveupInductionEntity staff){
        return AjaxResponse.success(service.findgiveupInductionStaffLikeByName(staff));
    }


    @PostMapping("/staff/turnright/getId")
    public AjaxResponse findTurnrightStaffById(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findTurnrightStaffById(staff));
    }

    @PostMapping("/staff/turnright/likename")
    public AjaxResponse findTurnrightStaffByName(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.findTurnrightStaffByName(staff));
    }

    @PostMapping("/staff/transfer/getId")
    public AjaxResponse findTransferStaffById(@RequestBody StaffTransferEntity staff){
        return AjaxResponse.success(service.findTransferStaffById(staff));
    }

    @PostMapping("/staff/transfer/likename")
    public AjaxResponse findTransferStaffLikeByName(@RequestBody StaffTransferEntity staff){
        return AjaxResponse.success(service.findTransferStaffLikeByName(staff));
    }

    @PostMapping("/staff/giveinduction")
    public AjaxResponse updateResume(@RequestBody StaffGiveupInductionEntity resume){
        System.out.println(resume);
        if (service.updateResume(resume)>0){
            return AjaxResponse.success("放弃成功");
        }else {
            return AjaxResponse.success("放弃失败");
        }
    }

    @PostMapping("/staff/givewhy")
    public AjaxResponse addwhy(@RequestBody StaffGiveupInductionEntity resume){
        System.out.println(resume);
        if (service.addwhy(resume)>0){
            return AjaxResponse.success("放弃成功");
        }else {
            return AjaxResponse.success("放弃失败");
        }
    }

    @PostMapping("/staff/addStaff")
    public Map<String, Object> addStaff(@RequestBody StaffInductionEntity staff){
        System.out.println("1111:  "+staff);
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addStaff(staff));
        return map1;
    }

    @PostMapping("/staff/basic")
    public AjaxResponse staff(@RequestBody StaffEntity staff){
        return AjaxResponse.success(service.basicstaff(staff.getStaffId()));
    }

    @PostMapping("/staff/positive")
    public AjaxResponse positive(@RequestBody StaffEntity staff){
        System.out.println(staff);
        if (service.positive(staff)>0){
            return AjaxResponse.success("转正成功");
        }else {
            return AjaxResponse.success("转正失败");
        }
    }
}
