package com.trkj.system.workbench.controller;


import com.trkj.system.vo.AjaxResponse;
import com.trkj.system.workbench.entity.workRecruitmentPlan;
import com.trkj.system.workbench.entity.workResume;
import com.trkj.system.workbench.service.workRecruitmentPlanService;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 招聘计划表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-06
 */
@RestController

public class workRecruitmentPlanController {
    @Autowired
    private workRecruitmentPlanService service;
    //招聘计划
    @PostMapping("/work/recruites")
    public AjaxResponse selectnumber(@RequestBody workRecruitmentPlan workRecruitmentPlan){
        return AjaxResponse.success(service.selecnumber(workRecruitmentPlan));
    }
    //简历
    @PostMapping("/work/resumes")
    public AjaxResponse selectnum(@RequestBody workResume workResume){
        return AjaxResponse.success(service.selecnumber(workResume));
    }

}

