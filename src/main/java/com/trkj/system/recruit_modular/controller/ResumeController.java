package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.ResumeService;
import com.trkj.system.recruit_modular.service.ResumeServiceVo;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    //简历表vo
    @Autowired
    private ResumeServiceVo resumeServiceVo;
    //简历表
    @Autowired
    private ResumeService service;


    //简历列表分页查询：全部简历
    @PostMapping("/resume/selectAll")
    public AjaxResponse findselectAll(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllresume(resumeVo));
    }

    //简历列表分页查询：候选人
    @PostMapping("/resume/selectAllhxr")
    public AjaxResponse findselectAllhxr(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllhouxr(resumeVo));
    }

    //简历列表分页查询：新简历
    @PostMapping("/resume/selectAllnew")
    public AjaxResponse findselectAllnew(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllnew(resumeVo));
    }

    //简历列表分页查询：淘汰库
    @PostMapping("/resume/findselectAlltt")
    public AjaxResponse findselectAlltt(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAlltt(resumeVo));
    }

    //简历列表分页查询：淘汰库
    @PostMapping("/resume/findselectAllyy")
    public AjaxResponse findselectAllyy(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findAllInvite(resumeVo));
    }

    //招聘个人简历详情查询
    @GetMapping("/resume/findByidAll")
    public AjaxResponse findByid(@RequestParam("id")Long id){
        return AjaxResponse.success(service.findByidselect(id));
    }

    //删除个人简历信息
    @PostMapping("/recruitment/deleteByidResumes")
    public AjaxResponse deleteByidResumes(@RequestBody ArrayList<Integer> id) {
        String s="成功";
        for (int i=0;i<id.size();i++){
            if(service.deleteByidResume(id.get(i))>=1){
                s ="成功";
            }else {
                return  AjaxResponse.success("失败");
            }
        }
        return AjaxResponse.success(s);
    }

    //关闭计划修改状态
    @PostMapping("/resume/updatebz")
    public AjaxResponse updatebz(@RequestBody Resume resume) {
        if (service.updateremarks(resume)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }
}

