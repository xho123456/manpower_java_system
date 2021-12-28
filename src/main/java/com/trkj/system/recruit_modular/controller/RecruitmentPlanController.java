package com.trkj.system.recruit_modular.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.service.RecruitmentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private RecruitmentPlanService recruitmentPlanService;

    /**
     * 招聘计划分页查询
     */
    @GetMapping("/recruitment/selectAll")
    public Object findselectAll(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){

        Page<RecruitmentPlanVo> page = new Page<>(currentPage,pagesize);
        return  recruitmentPlanService.selectAll(page);
    }

}

