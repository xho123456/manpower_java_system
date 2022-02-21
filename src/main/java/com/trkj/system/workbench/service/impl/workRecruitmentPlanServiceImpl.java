package com.trkj.system.workbench.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.workbench.entity.workRecruitmentPlan;
import com.trkj.system.workbench.entity.workResume;
import com.trkj.system.workbench.mapper.workRecruitmentPlanMapper;
import com.trkj.system.workbench.service.workRecruitmentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 招聘计划表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-06
 */
@Service
public class workRecruitmentPlanServiceImpl implements workRecruitmentPlanService {
    @Autowired
    private workRecruitmentPlanMapper recruitmentPlanMapper;
    //招聘计划
    @Override
    public int selecnumber(workRecruitmentPlan workRecruitmentPlan) {
        QueryWrapper<workRecruitmentPlan> wrapper = new QueryWrapper<>();
        //查询条件
        wrapper.eq("RECRUITMENT_ZT",workRecruitmentPlan.getRecruitmentZt());
        //逻辑删除
        wrapper.eq("IS_DELETED",0);
        return recruitmentPlanMapper.selecnumber(wrapper);
    }
    //简历
    @Override
    public int selecnumber(workResume workResume) {
        QueryWrapper<workResume> wrapper = new QueryWrapper<>();
        //查询条件
        wrapper.eq("RESUME_ZT",workResume.getResumeZt());
        //逻辑删除
        wrapper.eq("IS_DELETED",0);
        return recruitmentPlanMapper.selectnum(wrapper);
    }



}
