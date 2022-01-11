package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.RecruitmentPlanService;
import com.trkj.system.recruit_modular.service.RecruitmentPlanServiceVo;
import com.trkj.system.recruit_modular.service.ResumeServiceVo;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 招聘计划表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-28
 */
@RestController
public class RecruitmentPlanController {
    /**
     * 招聘计划Vo、部门、职位表 VO视图
     */
    @Autowired
    private RecruitmentPlanServiceVo recruitmentPlanServicevo;
    /**
     * 招聘计划
     */
    @Autowired
    private RecruitmentPlanService recruitmentPlanService;
    /**
     * 简历vo
     */
    @Autowired
    private ResumeServiceVo resumeServiceVo;


    //招聘计划分页查询
    @PostMapping("/recruitment/selectAll")
    public AjaxResponse findselectAll(@RequestBody RecruitmentPlanVo recruitmentPlanVo){
          return AjaxResponse.success(recruitmentPlanServicevo.selectAll(recruitmentPlanVo));
    }

    //关闭计划修改状态
    @PostMapping("/recruitment/updaterecruitmentPlan")
    public AjaxResponse updaterecruitmentPlan(@RequestBody RecruitmentPlan recruitmentPlan) {
        if (recruitmentPlanService.updateRecruitmentPlan(recruitmentPlan)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

    //删除招聘计划
    @PostMapping("/recruitment/deleterecruitmentPlan")
    public AjaxResponse deleterecruitmentPlan(@RequestBody ArrayList<Integer> id) {
           String s="成功";
            for (int i=0;i<id.size();i++){
                if(recruitmentPlanService.deleteRecruitmentPlan(id.get(i))>=1){
                    return AjaxResponse.success(s);
                }
            }
            return AjaxResponse.success("失败");
        }

    //分页 ：通过招聘计划编号查询出该计划招聘的所有简历信息
    @PostMapping("/recruitment/findByidjl")
    public AjaxResponse findByidjl(@RequestBody ResumeVo resumeVo){
        return AjaxResponse.success(resumeServiceVo.findByidresum(resumeVo));
    }




}

