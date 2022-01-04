package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.ResumeServiceVo;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 简历表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-31
 */
@RestController
public class ResumeController {
    @Autowired
    private ResumeServiceVo resumeServiceVo;
    //全部简历列表分页查询
    @PostMapping("/resume/selectAll")
    public AjaxResponse findselectAll(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllresume(resumeVo));
    }

    //候选人简历列表分页查询
    @PostMapping("/resume/selectAllhxr")
    public AjaxResponse findselectAllhxr(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllhouxr(resumeVo));
    }

    //候选人简历列表分页查询
    @PostMapping("/resume/selectAllnew")
    public AjaxResponse findselectAllnew(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllnew(resumeVo));
    }
}

