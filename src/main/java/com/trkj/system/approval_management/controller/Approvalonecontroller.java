package com.trkj.system.approval_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.PositiveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import com.trkj.system.approval_management.entity.WorkerVo;
import com.trkj.system.approval_management.service.ApprovalService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/worker/likename")
    public AjaxResponse positvemeByname(@RequestBody PositiveEntity positive){
        return AjaxResponse.success(service.positvemeByname(positive));
    }

    @PostMapping("/positveed/likename")
    public AjaxResponse positveedByname(@RequestBody PositiveEntity positive){
        return AjaxResponse.success(service.positveedByname(positive));
    }

    @PostMapping("/worker/myid")
    public AjaxResponse positvemyid(@RequestBody PositiveEntity positive){
        return AjaxResponse.success(service.positvemyid(positive));
    }

    /**
     * 添加转正 添加三个审批人
     * @param
     * @return
     */
    @PostMapping("/worker/add")
    public Map<String, Object> addpositve3(@RequestBody WorkerVo workerVo){
        System.out.println("controller:  "+workerVo);
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addpositve(workerVo));
        System.out.println("controller2:  "+map1);
        return map1;
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
