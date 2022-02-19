package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.Educationss;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.entity.WorkExperiencess;
import com.trkj.system.recruit_modular.service.EducationssService;
import com.trkj.system.recruit_modular.service.WorkExperiencessService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 受教育经历表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@RestController
public class EducationssController {
    //教育经历
    @Autowired
    private EducationssService service;

    //工作经历
    @Autowired
    private WorkExperiencessService workExperiencessService;


    //个人简历信息页面：教育经历查询
    @PostMapping("/resume/findByidEd")
    public AjaxResponse findByidEd(@RequestBody Educationss educationss){
        return AjaxResponse.success(service.selectByidEd(educationss));
    }

    //个人简历信息页面：工作经历查询
    @PostMapping("/resume/findByidWork")
    public AjaxResponse findByidWork(@RequestBody WorkExperiencess workExperiencess){
        return AjaxResponse.success(workExperiencessService.selectByidWork(workExperiencess));
    }

    //个人简历信息页面：工作经历添加
    @PostMapping("/resume/addworks")
    public AjaxResponse addworks(@RequestBody WorkExperiencess workExperiencess){
        if (workExperiencessService.addWorkexper(workExperiencess)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }

    }

    //删除个人工作经历信息
    @GetMapping("/resume/deleteByidhomes")
    public AjaxResponse deleteByidhomes(@RequestParam("id") Integer id) {
            if(workExperiencessService.deletehomes(id)>=1){
                return  AjaxResponse.success("成功");
            }else {
                return  AjaxResponse.success("失败");
            }

    }

    //个人简历信息页面：教育经历添加
    @PostMapping("/resume/addEduation")
    public AjaxResponse addEduation(@RequestBody Educationss educationss){
        if (service.addEducation(educationss)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }

    }

    //删除个人教育经历信息
    @GetMapping("/resume/deleteByEduationid")
    public AjaxResponse deleteByEduationid(@RequestParam("id") Integer id) {
        if(service.deleteEducation(id)>=1){
            return  AjaxResponse.success("成功");
        }else {
            return  AjaxResponse.success("失败");
        }

    }


}

