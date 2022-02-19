package com.trkj.system.approval_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.PositiveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import com.trkj.system.approval_management.service.ApprovalService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Approvalonecontroller {
    @Autowired
    private ApprovalService service;

    @GetMapping("/worker")
    public AjaxResponse positveme(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<PositiveEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.positveme(page1));
    }

    @GetMapping("/worker/positveed")
    public AjaxResponse positveed(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<PositiveEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.positveed(page1));
    }

    @GetMapping("/move")
    public AjaxResponse Moveapperme(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<MoveEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.Moveapperme(page1));
    }

    @GetMapping("/move/moveappered")
    public AjaxResponse Moveappered(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<MoveEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.Moveappered(page1));
    }

    @GetMapping("/salary")
    public AjaxResponse salary(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<SalaryincreaseEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.Salaryme(page1));
    }

    @GetMapping("/salary/salaryed")
    public AjaxResponse salaryed(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<SalaryincreaseEntity> page1=new Page<>(currentPage,pagesize);
        return AjaxResponse.success(service.Salaryed(page1));
    }
}
