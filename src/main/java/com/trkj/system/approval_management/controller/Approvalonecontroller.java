package com.trkj.system.approval_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.*;
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
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addpositve(workerVo));
        return map1;
    }


    @PostMapping ("/move")
    public AjaxResponse Moveapperme(@RequestBody MoveEntity move){
        System.out.println(move);
        return AjaxResponse.success(service.Moveapperme(move));
    }

    @PostMapping("/move/moveappered")
    public AjaxResponse Moveappered(@RequestBody MoveEntity move){
        System.out.println(move);
        return AjaxResponse.success(service.Moveappered(move));
    }
    @PostMapping ("/move/movemy")
    public AjaxResponse Moveappermy(@RequestBody MoveEntity move){
        System.out.println(move);
        return AjaxResponse.success(service.Moveappermy(move));
    }

    @PostMapping("/move/add")
    public Map<String, Object> addmove(@RequestBody MoveEntity move){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addmove(move));
        return map1;
    }

    @PostMapping("/salary")
    public AjaxResponse salary(@RequestBody SalaryincreaseEntity salaryincrease){
        System.out.println(salaryincrease);
        return AjaxResponse.success(service.Salaryme(salaryincrease));
    }

    @PostMapping("/salary/salaryed")
    public AjaxResponse salaryed(@RequestBody SalaryincreaseEntity salaryincrease){
        System.out.println(salaryincrease);
        return AjaxResponse.success(service.Salaryed(salaryincrease));
    }

    @PostMapping("/salary/salarymy")
    public AjaxResponse salarymy(@RequestBody SalaryincreaseEntity salaryincrease){
        System.out.println(salaryincrease);
        return AjaxResponse.success(service.Salarymy(salaryincrease));
    }

    @PostMapping("/salary/add")
    public Map<String, Object> addsalary(@RequestBody SalaryincreaseEntity salaryincrease){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addsalary(salaryincrease));
        return map1;
    }

    @PostMapping("/quit/departureMe")
    public AjaxResponse DepartureMe(@RequestBody DepartureEntity departure){
        return AjaxResponse.success(service.departureMe(departure));
    }

    @PostMapping("/quit/departureLikeName")
    public AjaxResponse DepartureLikeName(@RequestBody DepartureEntity departure){
        return AjaxResponse.success(service.departureLikeName(departure));
    }

    @PostMapping("/quit/departureMy")
    public AjaxResponse DepartureMy(@RequestBody DepartureEntity departure){
        return AjaxResponse.success(service.departureMy(departure));
    }

    @PostMapping("/quit/add")
    public Map<String, Object> adddeparture(@RequestBody DepartureEntity departure){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.adddeparture(departure));
        return map1;
    }

    @PostMapping("/workover/workoverMe")
    public AjaxResponse workoverMe(@RequestBody WorkovertimeEntity workovertime){
        System.out.println("workoverMe:  "+workovertime);
        return AjaxResponse.success(service.workoverMe(workovertime));
    }

    @PostMapping("/workover/LikeName")
    public AjaxResponse  workoverLikeName(@RequestBody WorkovertimeEntity workovertime){
        System.out.println("workoverLikeName:  "+workovertime);
        return AjaxResponse.success(service. workoverLikeName(workovertime));
    }

    @PostMapping("/workover/workoverMy")
    public AjaxResponse workoverMy(@RequestBody WorkovertimeEntity workovertime){
        System.out.println("workoverMy:  "+workovertime);
        return AjaxResponse.success(service.workoverMy(workovertime));
    }

    @PostMapping("/workover/add")
    public Map<String, Object> adddworkover(@RequestBody WorkovertimeEntity workovertime){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.adddworkover(workovertime));
        return map1;
    }

    @PostMapping("/fillclock/fillclockMe")
    public AjaxResponse fillclockMe(@RequestBody FillclockEntity fillclock){
        System.out.println(fillclock);
        return AjaxResponse.success(service.fillclockMe(fillclock));
    }

    @PostMapping("/fillclock/LikeName")
    public AjaxResponse  fillclockLikeName(@RequestBody FillclockEntity fillclock){
        System.out.println(fillclock);
        return AjaxResponse.success(service. fillclockLikeName(fillclock));
    }

    @PostMapping("/fillclock/fillclockMy")
    public AjaxResponse fillclockMy(@RequestBody FillclockEntity fillclock){
        return AjaxResponse.success(service.fillclockMy(fillclock));
    }

    @PostMapping("/fillclock/add")
    public Map<String, Object> addfillclock(@RequestBody FillclockEntity fillclock){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addfillclock(fillclock));
        return map1;
    }

    @PostMapping("/erection/erectionMe")
    public AjaxResponse erectionMe(@RequestBody ErectionEntity erection){
        return AjaxResponse.success(service.erectionMe(erection));
    }

    @PostMapping("/erection/LikeName")
    public AjaxResponse  erectionLikeName(@RequestBody ErectionEntity erection){
        return AjaxResponse.success(service. erectionLikeName(erection));
    }
    @PostMapping("/erection/erectionMy")
    public AjaxResponse erectionMy(@RequestBody ErectionEntity erection){
        return AjaxResponse.success(service.erectionMy(erection));
    }

    @PostMapping("/erection/add")
    public Map<String, Object> adderection(@RequestBody ErectionEntity erection){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.adderection(erection));
        return map1;
    }

    @PostMapping("/leaver/leaverMe")
    public AjaxResponse leaverMe(@RequestBody LeaveEntity leave){
        return AjaxResponse.success(service.leaverMe(leave));
    }

    @PostMapping("/leaver/LikeName")
    public AjaxResponse  leaverLikeName(@RequestBody LeaveEntity leave){
        return AjaxResponse.success(service. leaverLikeName(leave));
    }

    @PostMapping("/leaver/leaverMy")
    public AjaxResponse leaverMy(@RequestBody LeaveEntity leave){
        return AjaxResponse.success(service.leaverMy(leave));
    }

    @PostMapping("/leaver/add")
    public Map<String, Object> addleaver(@RequestBody LeaveEntity leave){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", service.addleaver(leave));
        return map1;
    }

}
